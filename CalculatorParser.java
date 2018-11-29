package org.ioopm.calculator.parser;

import org.ioopm.calculator.ast.*;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.IOException;

public class CalculatorParser {
    private StreamTokenizer st;
    //private StreamTokenizer st = new StreamTokenizer(System.in);

    /*
    public CalculatorParser() {
        this.st.eolIsSignificant(true);
        this.st.ordinaryChar('-');
        this.st.ordinaryChar('/');
        //this.st.ordinaryChar('=');
    }
    */

    public SymbolicExpression parse(String input) throws IOException, SyntaxErrorException {
        st = new StreamTokenizer(new StringReader(input));
        this.st.eolIsSignificant(true);
        this.st.ordinaryChar('-');
        this.st.ordinaryChar('/');
        return statement();
    }

    public SymbolicExpression statement() throws IOException, SyntaxErrorException {
        SymbolicExpression result;
        this.st.nextToken();

        if (isInvalidIdentifier()) {
            result = this.command();
        } else {
            this.st.pushBack();
            result = this.assignment();
        }
        return result;
    }

    public SymbolicExpression command() throws IOException, SyntaxErrorException {
        SymbolicExpression result;

        if (this.st.sval.equals("quit")) {
            result = Quit.instance();
        } else {
            result = Vars.instance();
        }
        return result;
    }

    public SymbolicExpression assignment() throws IOException, SyntaxErrorException {
        SymbolicExpression result = expression();
        this.st.nextToken();

        while (this.st.ttype == '=') {
            this.st.nextToken();
            if (this.st.ttype == this.st.TT_WORD) {
                if (this.st.sval.equals("quit") || this.st.sval.equals("vars") || this.st.sval.equals("clear")) {
                    throw new IllegalExpressionException("Cannot assign command '" + this.st.sval + "' to a value");
                }
                else if (Constants.namedConstants.containsKey(this.st.sval)) {
                    throw new IllegalExpressionException("Cannot redefine named constant '" + this.st.sval + "'");
                }
                else {
                    result = new Assignment(result, new Variable(this.st.sval));
                    this.st.nextToken();
                }
            }
            else {
                throw new IllegalExpressionException("Cannot assign a new value to a constant");
            }
        }
        this.st.pushBack();
        return result;
    }

    public SymbolicExpression expression() throws IOException, SyntaxErrorException {
        SymbolicExpression result = term();
        this.st.nextToken();

        while(this.st.ttype == '+' || this.st.ttype == '-') {
            if (this.st.ttype  == '+') {
                result = new Addition(result, term());
            }
            else {
                result = new Subtraction(result, term());
            }
            this.st.nextToken();
        }
        this.st.pushBack();
        return result;
    }

    public SymbolicExpression term() throws IOException, SyntaxErrorException {
        SymbolicExpression result = primary();
        this.st.nextToken();

        while (this.st.ttype == '*' || this.st.ttype == '/') {
            if (this.st.ttype  == '/') {
                result = new Division(result, primary());
            }
            else {
                result = new Multiplication(result, primary());
            }
            this.st.nextToken();
        }
        this.st.pushBack();
        return result;
    }

    public SymbolicExpression unary() throws IOException, SyntaxErrorException {
        SymbolicExpression result;
        if (this.st.ttype == '-') {
            result = new Negation(primary());
        }
        else if (this.st.sval.equals("sin")) {
            result = new Sin(primary());
        }
        else if (this.st.sval.equals("cos")) {
            result = new Cos(primary());
        }
        else if (this.st.sval.equals("log")) {
            result = new Log(primary());
        }
        else if (this.st.sval.equals("exp")) {
            result = new Exp(primary());
        }
        else {
            throw new SyntaxErrorException("Unexpected: '" + this.st.sval + "'");
        }
        return result;
    }

    public SymbolicExpression primary() throws IOException, SyntaxErrorException {
        SymbolicExpression result;
        this.st.nextToken();

        if (this.st.ttype == '(') {
            result = assignment();
            if (this.st.nextToken() != ')') {
                throw new SyntaxErrorException("Expected: )");
            }
        }
        else if (this.st.ttype == this.st.TT_WORD || this.st.ttype == '-' ) {
            if (isUnary()) {
                result = unary();
            }
            else if (Constants.namedConstants.containsKey(this.st.sval)) {
                result =  new NamedConstant(this.st.sval, Constants.namedConstants.get(this.st.sval));
            }
            else {
                if(isInvalidIdentifier()) {
                    throw new SyntaxErrorException("'quit' and 'vars' invalid identifiers");
                }
                result =  new Variable(this.st.sval);
            }
        }
        else if (this.st.ttype == this.st.TT_NUMBER){
            result = new Constant(this.st.nval);
        }
        else {
            throw new SyntaxErrorException("Unexpected: '" + Character.toString((char) this.st.ttype) + "'");
        }
        return result;
    }

    private boolean isUnary() {
        if(this.st.ttype == '-') {return true;}

        return this.st.sval.equals("sin") || this.st.sval.equals("cos") || this.st.sval.equals("exp") || this.st.sval.equals("log");
    }

    private boolean isInvalidIdentifier() {
        boolean result;

        if (this.st.ttype == this.st.TT_WORD) {
            result = this.st.sval.equals("quit") || this.st.sval.equals("vars");
        } else {
            result = false;
        }
        return result;
    }
}

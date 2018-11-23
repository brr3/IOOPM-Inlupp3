package org.ioopm.calculator.parser;

import org.ioopm.calculator.ast.*;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.IOException;

public class CalculatorParser {
    StreamTokenizer st = new StreamTokenizer(System.in);

    public SymbolicExpression parse() throws IOException {
        return assignment();
    }

    public CalculatorParser() {
        this.st.eolIsSignificant(true);
        this.st.ordinaryChar('/');
        this.st.ordinaryChar('-');
    }

    public SymbolicExpression primary() throws IOException {
        this.st.nextToken();
        SymbolicExpression result;

        if(this.st.ttype == '(') {
            result = assignment();

            if(this.st.nextToken() != ')') {
                throw new SyntaxErrorException("Expected ')'");
            }
        }

        else if (this.st.ttype == this.st.TT_WORD) {
            if (isUnary()) {
                result = unary();
            } else {
                result = new Variable(this.st.sval);
            }
        }
        else if(this.st.ttype == this.st.TT_NUMBER) {
            result = new Constant(this.st.nval);
        }
        else {
            throw new RuntimeException();
        }
        return result;
    }

    public SymbolicExpression unary() throws IOException {
        SymbolicExpression result;

        if (this.st.sval.equals("sin")) {
            result = new Sin(primary());
        }
        else if (this.st.sval.equals("cos")) {
            result = new Cos(primary());
        }
        else if (this.st.sval.equals("log")) {
            result = new Log(primary());
        }
        else if (this.st.sval.equals("^")) { //dessa två suger röv
            result = new Exp(primary());
        }
        else if (this.st.sval.equals("-")) { // asså den här också
            result = new Negation(primary());
        }
        else {
            throw new RuntimeException();
        }
        return result;
    }

    public SymbolicExpression term() throws IOException {
        SymbolicExpression result = primary();
        this.st.nextToken();

        while (this.st.ttype == '*' || this.st.ttype == '/') {
            if (this.st.ttype  == '/') {
                result = new Division(result, primary());
            } else {
                result = new Multiplication(result, primary());
            }
            this.st.nextToken();
        }

        this.st.pushBack();
        return result;
    }

    public SymbolicExpression expression() throws IOException {
        SymbolicExpression result = term();
        this.st.nextToken();

        while(this.st.ttype == '+' || this.st.ttype == '-') {
            if (this.st.ttype  == '+') {
                result = new Addition(result, term());
            } else {
                result = new Subtraction(result, term());
            }
            this.st.nextToken();
        }

        this.st.pushBack();
        return result;
    }

    private boolean isUnary() {
        return this.st.sval.equals("sin") || this.st.sval.equals("cos") || this.st.sval.equals("^") || this.st.sval.equals("-") || this.st.sval.equals("log");
    }

    public SymbolicExpression assignment() throws IOException {
        SymbolicExpression result = expression();
        this.st.nextToken();

        if (this.st.ttype == '=') {
            this.st.nextToken();
            if (this.st.ttype != this.st.TT_WORD) {
                return result;
            } else {
                result = new Assignment(result, assignment());
            }
        }

        this.st.pushBack();
        return result;
    }
}
import org.ioopm.calculator.parser.SymbolicExpression;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class CalculatorParser {
    private final StreamTokenizer st = new StreamTokenizer(new StringReader(parse()));

    public CalculatorParser() {
        this.st.ordinaryChar('-');
        this.st.eolIsSignificant(true);
    }

    public String parse() {
        String string = "(5+x)*(5-u)";
        return string;
    }

    public SymbolicExpression expression() {
        SymbolicExpression result = term();
        this.st.nextToken();

        while (this.st.ttype == '+' || this.st.ttype == '-') {
            int operation = st.ttype;
            st.nextToken();
            if (operation == '+') {
                result = new SymbolicExpression("Addition", result, term());
            } else if (operation == '-'){
                result = new SymbolicExpression("Subtraction", result, term());
            }
        }
        this.st.pushBack();
        return result;
    }

    public SymbolicExpression term() {
        SymbolicExpression result = factor();
        while(this.st.nextToken() == '*' || this.st.nextToken() == '/') {
            int operation = st.ttype;
            if(operation == '*') {
                result = new SymbolicExpression("Multiplication", result, factor());
            }
            else if(operation == '/'){
                result = new SymbolicExpression("Division", result, factor());
            }
            this.st.nextToken();
        }
        this.st.pushBack();
        return result;
    }


    public SymbolicExpression factor() {
        SymbolicExpression result;
        this.st.nextToken();

        if (this.st.ttype == '(') {
            result = expression();

            if (this.st.nextToken() != ')') {
                throw new Exception();
            }
        } else {
            String operationString = this.st.sval;
            double operationInt = this.st.nval;

            if (this.st.ttype == this.st.TT_WORD) {
                if (operationString == "sin" || operationString == "cos" || operationString == "-" || operationString == "log" || operationString == "^") {
                    result = unary();
                }
                else {
                    result = new SymbolicExpression("Variable", operationString);
                }
            }
            else if (this.st.ttype == this.st.TT_NUMBER){
                result = new SymbolicExpression("Constant", operationInt);
            }
        }
        return result;
    }

    public SymbolicExpression unary() {

        if (this.st.nextToken().TT_WORD) {
            String parameter = this.st.sval;
        } else {
            Double parameter = this.st.nval;
        }

        this.st.pushBack;

        String unaryOperation = this.st.sval;
        if (unaryOperation = "sin") {
            return new SymbolicExpression result = ("Sin", parameter)
        } else if (unaryOperation = "cos") {
            return new SymbolicExpression result = ("cos", parameter)
        } else if (unaryOperation = "log") {
            return new SymbolicExpression result = ("log", parameter)
        } else if (unaryOperation = "^") {
            return new SymbolicExpression result = ("^", parameter)
        } else if (unaryOperation = "-") {
            return new SymbolicExpression result = ("-", parameter)
        }
    }
}

import org.ioopm.calculator.ast.*;

public class Test {

    public static void testPrinting(String expected, SymbolicExpression e) {
        if (expected.equals("" + e)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }

    public static void main(String[] args) {
        /*~ Test 1 ~*/
        Constant c1 = new Constant(5);
        Constant c2 = new Constant(2);
        Variable v1 = new Variable("x");
        Variable v2 = new Variable("y");
        Addition a1 = new Addition(c1, v1);
        Multiplication m = new Multiplication(a1, c2);

        testPrinting("(5 + x) * 2", m);

        /*~ Test 2 ~*/
        Addition a2 = new Addition(c2, v1);
        Assignment f = new Assignment(a2, v1);

        testPrinting("2 + x = y", f);

        /*~ Test 3 ~*/
        testPrinting("5", c1);
        testPrinting("5 + x", a1);
    }
}

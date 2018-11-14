import org.ioopm.calculator.ast.*;

public class Test {

    public static void testPrinting(String expected, SymbolicExpression e) {
        if (expected.equals("" + e)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }

    public static void testEvaluating(SymbolicExpression expected, SymbolicExpression e) {
        SymbolicExpression r = e.eval();
        if (r.equals(expected)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + r + "'");
        }
    }

    public static void main(String[] args) {
        /*~ Test 1 Printing ~*/
        Constant c1 = new Constant(5);
        Constant c2 = new Constant(2);
        Variable v1 = new Variable("x");
        Variable v2 = new Variable("y");
        Addition a1 = new Addition(c1, v1);
        Multiplication m = new Multiplication(a1, c2);

        testPrinting("(5.0 + x) * 2.0", m);

        /*~ Test 2 Printing ~*/
        Addition a2 = new Addition(c2, v1);
        Assignment f = new Assignment(a2, v2);

        testPrinting("2.0 + x = y", f); // TODO: Result should be 2.0 + x

        /*~ Test 3 Printing ~*/
        testPrinting("5.0", c1);

        /*~ Test 4 Printing ~*/
        testPrinting("5.0 + x", a1);

        /*~ Test 5 Printing ~*/
        Variable v3 = new Variable("z");
        Variable v4 = new Variable("a");
        Variable v5 = new Variable("t");
        Constant c3 = new Constant(4);

        Sin s = new Sin(v3);
        Multiplication m2 = new Multiplication(c3, v4);
        Addition a4 = new Addition(c3, v5);

        Addition a3 = new Addition(s, m2);
        Multiplication m3 = new Multiplication(c1, a4);

        Subtraction s1 = new Subtraction(a3, m3);

        Assignment g = new Assignment(s1, v1);

        Assignment j = new Assignment(g, v2);

        testPrinting("sin z + 4.0 * a - 5.0 * (4.0 + t) = x = y", j);

        /*~ Test 1 Evaluating ~*/
        SymbolicExpression z1 = new Addition(new Constant(5), new Constant(37));
        SymbolicExpression z2 = new Constant(42);
        testEvaluating(z2, z1);

        /*~ Test 2 Evaluating ~*/
        SymbolicExpression z3 = new Subtraction(new Constant(6), new Variable("x"));
        SymbolicExpression z4 = new Subtraction(new Constant(6), new Variable("x"));
        testEvaluating(z4, z3);

        /*~ Test 3 Evaluating ~*/
        SymbolicExpression z5 = new Multiplication(new Sin(new Constant(30)), new Constant(2));
        SymbolicExpression z6 = new Constant(0.9999999999999999);
        testEvaluating(z6, z5);

        /*~ Test 4 Evaluating ~*/
        SymbolicExpression z7 = new Multiplication(new Sin(new Constant(30)), new Constant(2));
        SymbolicExpression a10 = new Assignment(z5, new Variable("x"));
        SymbolicExpression z8 = new Constant(0.9999999999999999);
        testEvaluating(z8, a10);

    }
}

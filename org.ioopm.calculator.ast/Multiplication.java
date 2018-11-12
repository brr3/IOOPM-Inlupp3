package org.ioopm.calculator.ast;

public class Multiplication extends Binary {
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    public String getName() {
        return "*";
    }

}

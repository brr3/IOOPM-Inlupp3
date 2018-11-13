package org.ioopm.calculator.ast;

public class Addition extends Binary {
    private int priority = 50;

    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    public String getName() {
        return "+";
    }

}

package org.ioopm.calculator.ast;

public class Subtraction extends Binary {
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    public String getName() {
        return "-";
    }

}

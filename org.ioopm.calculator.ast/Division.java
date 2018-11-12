package org.ioopm.calculator.ast;

public class Division extends Binary {
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    public String getName() {
        return "/";
    }

}

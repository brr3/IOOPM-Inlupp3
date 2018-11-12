package org.ioopm.calculator.ast;

public class Assignment extends Binary {
    private SymbolicExpression lhs = null;
    private Variable rhs = null;

    public Assignment(SymbolicExpression lhs, Variable rhs) {
        super(lhs, rhs);
    }

    public String getName() {
        throw new RuntimeException("getname() called on expression with no operator");
    }

}

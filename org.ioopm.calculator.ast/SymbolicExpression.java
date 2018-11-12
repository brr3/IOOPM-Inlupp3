package org.ioopm.calculator.ast;

public abstract class SymbolicExpression {


    public boolean isConstant() {
        return false;
    }

    public String getName() {
        throw new RuntimeException("getname() called on expression with no operator");
    }
}

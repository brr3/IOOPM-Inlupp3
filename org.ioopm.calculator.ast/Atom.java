package org.ioopm.calculator.ast;

public abstract class Atom extends SymbolicExpression {

    public String getName() {
        throw new RuntimeException("getname() called on expression with no operator");
    }


}

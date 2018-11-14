package org.ioopm.calculator.ast;

public abstract class Command extends SymbolicExpression {

    public SymbolicExpression eval() {
        throw new RuntimeException("eval() called on command");
    }
    
}

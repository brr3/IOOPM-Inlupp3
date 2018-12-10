package org.ioopm.calculator.ast;

import java.util.HashMap;

public abstract class SymbolicExpression {

    public static class Environment extends HashMap<Variable, SymbolicExpression> {}

    public boolean isConstant() {
        return false;
    }

    public boolean isNamedConstant() {
        return false;
    }

    public boolean isCommand() {
        return false;
    }

    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }

    public int getPriority() {
        return 100;
    }

    public double getValue() {
        throw new RuntimeException("getValue() called on an expression which is not a constant");
    }

    public abstract SymbolicExpression eval(Environment vars);
}

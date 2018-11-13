package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
  private SymbolicExpression lhs = null;

    public String toString() {
        return this.getName() + " " + this.lhs.toString();
    }

}

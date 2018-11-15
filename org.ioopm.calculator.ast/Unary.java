package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
  protected SymbolicExpression arg = null;

    public Unary(SymbolicExpression arg) {
        this.arg = arg;
    }

    public String toString() {
        return this.getName() + " " + this.arg.toString();
    }

    public boolean equals(Object other) {
        if (other instanceof Unary) {
            return this.equals((Unary) other);
        } else {
            return false;
        }
    }

    public boolean equals(Unary other) {
        boolean sameOperator = this.getName().equals(other.getName());
        boolean sameArgument = this.arg.getName().equals(other.arg.getName());
        return sameOperator && sameArgument;
    }

}

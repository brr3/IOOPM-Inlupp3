package org.ioopm.calculator.ast;

public abstract class Unary extends SymbolicExpression {
  private SymbolicExpression lhs = null;

    public Unary(SymbolicExpression lhs) {
        this.lhs = lhs;
    }

    public String toString() {
        return this.getName() + " " + this.lhs.toString();
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
        boolean sameArgument = this.lhs.getName().equals(other.lhs.getName());
        return sameOperator && sameArgument;
    }

}

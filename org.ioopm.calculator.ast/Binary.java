package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
  private SymbolicExpression lhs = null;
  private SymbolicExpression rhs = null;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }

    public String toString() {
        boolean lhsP = this.lhs.getPriority() < this.getPriority();
        boolean rhsP = this.rhs.getPriority() < this.getPriority();
        if (lhsP && rhsP) {
            return "(" + this.lhs.toString() + ") " + this.getName() + " (" + this.rhs.toString() + ")";
          } else if (lhsP) {
            return "(" + this.lhs.toString() + ") " + this.getName() + " " + this.rhs.toString();
          } else if (rhsP) {
            return this.lhs.toString() + " " + this.getName() + " (" + this.rhs.toString() + ")";
          } else {
            return this.lhs.toString() + " " + this.getName() + " " + this.rhs.toString();
          }
      }
  }

package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
  private SymbolicExpression lhs = null;
  private SymbolicExpression rhs = null;

    public Binary (SymbolicExpression lhs, SymbolicExpression rhs) {
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

      public boolean equals(Object other) {
          if (other instanceof Binary) {
              return this.equals((Binary) other);
          } else {
              return false;
          }
      }

      public boolean equals(Binary other) {
          boolean sameOperator = this.getName().equals(other.getName());
          boolean lhsExists = this.lhs.toString().equals(other.lhs.toString()) || this.lhs.toString().equals(other.rhs.toString());
          boolean rhsExists = this.rhs.toString().equals(other.lhs.toString()) || this.rhs.toString().equals(other.rhs.toString());
          return sameOperator && lhsExists && rhsExists;
      }

      public SymbolicExpression getLhs() {
          return this.lhs;
      }

      public SymbolicExpression getRhs() {
          return this.rhs;
      }

  }

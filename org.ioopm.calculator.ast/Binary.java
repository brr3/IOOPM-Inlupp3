package org.ioopm.calculator.ast;

public abstract class Binary extends SymbolicExpression {
  private SymbolicExpression lhs = null;
  private SymbolicExpression rhs = null;

    public Binary(SymbolicExpression lhs, SymbolicExpression rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }

    public String toString() {
        if (this.lhs.getPriority() < this.getPriority()) {
            return "(" + this.lhs.toString() + ") " + this.getName() + " " + this.rhs.toString();
          } else {
            return this.lhs.toString() + " " + this.getName() + " " + this.rhs.toString();
          }
      }
  }

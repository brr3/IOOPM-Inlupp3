package org.ioopm.calculator.ast;

public class Cos extends Unary {

    public Cos(SymbolicExpression lhs) {
      super(lhs);
    }

    public String getName() {
        return "cos";
    }

}

package org.ioopm.calculator.ast;

public class Cos extends Unary {

    public Cos(SymbolicExpression arg) {
      super(arg);
    }

    public String getName() {
        return "cos";
    }

    public SymbolicExpression eval() {
        SymbolicExpression arg = this.arg.eval();
        if (arg.isConstant()) {
          return new Constant(Math.cos(arg.getValue()));
        } else {
          return new Cos(arg);
        }
    }

}

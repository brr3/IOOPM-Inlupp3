package org.ioopm.calculator.ast;

public class Cos extends Unary {

    public Cos(SymbolicExpression arg) {
      super(arg);
    }

    @Override
    public String getName() {
        return "cos";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.arg.eval(vars);
        if (arg.isConstant()) {
          return new Constant(Math.cos(arg.getValue()));
        } else {
          return new Cos(arg);
        }
    }

}

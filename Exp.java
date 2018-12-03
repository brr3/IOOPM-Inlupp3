package org.ioopm.calculator.ast;

public class Exp extends Unary {

    public Exp(SymbolicExpression arg) {
        super(arg);
    }

    @Override
    public String getName() {
        return "e ^";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.arg.eval(vars);
        if (arg.isConstant()) {
          return new Constant(Math.exp(arg.getValue()));
        } else {
          return new Exp(arg);
        }
    }

}

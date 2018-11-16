package org.ioopm.calculator.ast;

public class Exp extends Unary {

    public Exp(SymbolicExpression arg) {
        super(arg);
    }

    public String getName() {
        return "^";
    }

    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.arg.eval(vars);
        if (arg.isConstant()) {
          return new Constant(Math.exp(arg.getValue()));
        } else {
          return new Exp(arg);
        }
    }

}

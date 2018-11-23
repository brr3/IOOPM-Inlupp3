package org.ioopm.calculator.ast;

public class Negation extends Unary {

    public Negation(SymbolicExpression lhs) {
        super(lhs);
    }

    @Override
    public String getName() {
        return "-";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.arg.eval(vars);
        if (arg.isConstant()) {
          return new Constant(-arg.getValue());
        } else {
          return new Negation(arg);
        }
    }

}

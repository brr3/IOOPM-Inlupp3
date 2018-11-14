package org.ioopm.calculator.ast;

public class Negation extends Unary {

    public Negation(SymbolicExpression lhs) {
        super(lhs);
    }

    public String getName() {
        return "-";
    }

    public SymbolicExpression eval() {
        SymbolicExpression arg = this.getArg().eval();
        if (arg.isConstant()) {
          return new Constant(-arg.getValue());
        } else {
          return new Negation(arg);
        }
    }

}

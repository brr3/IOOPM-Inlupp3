package org.ioopm.calculator.ast;

public class Sin extends Unary {

    public Sin(SymbolicExpression arg) {
        super(arg);
    }

    public String getName() {
        return "sin";
    }

    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.arg.eval(vars);
        if (arg.isConstant()) {
            return new Constant(Math.sin(Math.toRadians(arg.getValue())));
        } else {
            return new Sin(arg);
        }
    }

}
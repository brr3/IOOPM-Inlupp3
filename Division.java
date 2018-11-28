package org.ioopm.calculator.ast;

public class Division extends Binary {

    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "/";
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression lhs = this.lhs.eval(vars);
        SymbolicExpression rhs = this.rhs.eval(vars);
        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() / rhs.getValue());
        } else if (lhs.isConstant()) {
            return new Division(new Constant(lhs.getValue()), new Variable("(" + rhs.toString() + ")"));
        } else {
            return new Division(new Variable("(" + lhs.toString() + ")"), new Constant(rhs.getValue()));
        }
    }

}

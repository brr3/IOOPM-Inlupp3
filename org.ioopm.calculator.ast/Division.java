package org.ioopm.calculator.ast;

public class Division extends Binary {

    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    public String getName() {
        return "/";
    }

    public SymbolicExpression eval() {
        SymbolicExpression lhs = this.getLhs().eval();
        SymbolicExpression rhs = this.getRhs().eval();
        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() / rhs.getValue());
        } else if (lhs.isConstant()) {
            return new Division(new Constant(lhs.getValue()), new Variable(rhs.toString()));
        } else {
            return new Division(new Variable(lhs.toString()), new Constant(rhs.getValue()));
        }
    }

}

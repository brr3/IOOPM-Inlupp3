package org.ioopm.calculator.ast;

public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "+";
    }

    @Override
    public int getPriority() {
        return 50;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression lhs = this.lhs.eval(vars);
        SymbolicExpression rhs = this.rhs.eval(vars);
        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() + rhs.getValue());
        } else if (lhs.isConstant()) {
            return new Addition(new Constant(lhs.getValue()), new Variable(rhs.toString()));
        } else if (rhs.isConstant()) {
            return new Addition(new Variable(lhs.toString()), new Constant(rhs.getValue()));
        } else {
            return new Addition(new Variable(lhs.toString()), new Variable(rhs.toString()));
        }
    }

}

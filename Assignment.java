package org.ioopm.calculator.ast;

import org.ioopm.calculator.parser.IllegalExpressionException;

public class Assignment extends Binary {

    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "=";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public SymbolicExpression eval(Environment vars) throws IllegalExpressionException {
        if (this.rhs.isNamedConstant()) {
            throw new IllegalExpressionException("Cannot redefine named constant '" + this.rhs + "'");
        } else {
            SymbolicExpression lhs = this.lhs.eval(vars);
            vars.put(new Variable(this.rhs.toString()), lhs);
            if (lhs.isConstant()) {
                return new Constant(lhs.getValue());
            } else {
                return new Assignment(lhs, this.rhs);
            }
        }
    }

}

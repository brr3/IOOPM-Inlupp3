package org.ioopm.calculator.ast;

public class Assignment extends Binary {
    private Variable rhs;

    public Assignment(SymbolicExpression lhs, Variable rhs) {
        super(lhs, (SymbolicExpression) rhs);
    }

    public String getName() {
        return "=";
    }

    public int getPriority() {
        return 0;
    }

    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression lhs = this.lhs.eval(vars);
        vars.put(new Variable(this.rhs.toString()), lhs);
        if (lhs.isConstant()) {
            return new Constant(lhs.getValue());
        } else {
            return new Assignment(lhs, this.rhs);
        }
    }

}

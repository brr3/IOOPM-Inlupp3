package org.ioopm.calculator.ast;

public class Variable extends Atom {
    private String identifier;

    public Variable(String identifier){
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return this.identifier;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Variable) {
            return this.equals((Variable) other);
        } else {
            return false;
        }
    }

    public boolean equals(Variable other) {
        return this.identifier.equals(other.identifier);
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        if (vars.containsKey(new Variable(this.identifier))) {
            System.out.println("variable found");
            if (vars.get(new Variable(this.identifier)).isConstant()) {
                    return new Constant(vars.get(new Variable(this.identifier)).getValue());
            } else {
                return new Variable(this.identifier);
            }
        } else {
            System.out.println("fan också");
            return new Variable(this.identifier);
        }
    }
}

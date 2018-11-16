package org.ioopm.calculator.ast;

public class Variable extends Atom {
    private String identifier;

    public Variable(String identifier){
        this.identifier = identifier;
    }

    public String toString() {
        return this.identifier;
    }

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

    public SymbolicExpression eval(Environment vars) {
        if (vars.containsKey(new Variable(this.identifier))) {
            if (vars.get(new Variable(this.identifier)).isConstant()) {
                    return new Constant(vars.get(new Variable(this.identifier)).getValue());
                } else {
                    return new Variable(this.identifier);
                }
            } else {
                return new Variable(this.identifier);
            }
        }
    }

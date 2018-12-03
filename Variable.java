package org.ioopm.calculator.ast;
import java.lang.String;

public class Variable extends Atom {
    private String identifier;

    public Variable(String identifier){
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode();
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
        Variable v = new Variable(this.identifier);
        if (vars.containsKey(v)) {
            return vars.get(v).eval(vars);
        } else {
            return v;
        }
    }
}

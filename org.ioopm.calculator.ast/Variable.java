package org.ioopm.calculator.ast;

public class Variable extends Atom {
    private String identifier;

    public Variable(String identifier){
        this.identifier = identifier;
    }

    public String getName() {
        throw new RuntimeException("getname() called on expression with no operator");
    }

}

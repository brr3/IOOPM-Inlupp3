package org.ioopm.calculator.ast;

public class Negation extends Atom {


    public String getName() {
        throw new RuntimeException("getname() called on expression with no operator");
    }

}

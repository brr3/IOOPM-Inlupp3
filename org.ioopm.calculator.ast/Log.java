package org.ioopm.calculator.ast;

public class Log extends Unary {

    public Log(SymbolicExpression arg) {
      super(arg);
    }

    public String getName() {
        return "log";
    }

    public SymbolicExpression eval() {
        SymbolicExpression arg = this.arg.eval();
        if (arg.isConstant()) {
          return new Constant(Math.log(arg.getValue()));
        } else {
          return new Log(arg);
        }
    }

}

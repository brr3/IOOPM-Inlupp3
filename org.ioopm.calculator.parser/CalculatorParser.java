package org.ioopm.calculator.parser;

import org.ioopm.calculator.ast.SymbolicExpression;
import java.io.StreamTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalculatorParser {
  private BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  private final StreamTokenizer st = new StreamTokenizer(r);

  public CalculatorParser() {
    /// We want to treat - and end of line as an ordinary tokens
    this.st.ordinaryChar('-'); /// parse object-oriented as "object" - "oriented" :)
    this.st.eolIsSignificant(true);
  }

  public SymbolicExpression expression() {
   SymbolicExpression result = term();
   while (st.ttype == '+' || st.ttype == '-') {
      int operation = st.ttype;
      st.nextToken();
      if (operation == '+') {
          result = new SymbolicExpression("Addition", result, term()); // TODO: Update when AST is done
      } else {
          result = new SymbolicExpression("Subtraction", result, term()); // TODO: Update when AST is done
      }
   }
   return result;
 }
}

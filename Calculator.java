package org.ioopm.calculator;

import org.ioopm.calculator.parser.*;
import org.ioopm.calculator.ast.*;
import java.util.Scanner;
import java.io.IOException;

public class Calculator {
    public static void main(String[] args) {
        final CalculatorParser p = new CalculatorParser();
        final SymbolicExpression.Environment vars = new SymbolicExpression.Environment();

        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("Welcome to the parser!");

        int expressionsEntered = 0;
        int successfulEvals = 0;
        int fullEvals = 0;

        while(true) {
            System.out.println("---------------------------");
            System.out.println("Please enter an expression:");

            try {
                String input = sc.nextLine();
                ++expressionsEntered;
                SymbolicExpression result = p.parse(input);

                if(result.isCommand()) {
                    if (result.getName().equals("quit")) {
                        System.out.println("Statistics:\nExpressions entered: " + expressionsEntered + "\nSuccessful evaluations: " + successfulEvals + "\nFull evaluations: " + fullEvals);
                        break;
                    } else if (result.getName().equals("vars")) {
                        vars.forEach((k,v) -> System.out.println("key : " + k + "\tvalue : " + v));
                    } else {
                        vars.clear();
                        System.out.println("Assignments successfully cleared!");
                    }
                } else {
                    SymbolicExpression evaluatedResult = result.eval(vars);
                    vars.put(new Variable("ans"), evaluatedResult);
                    if (evaluatedResult.isConstant()) {
                        ++fullEvals;
                        ++successfulEvals;
                    } else {
                        ++successfulEvals;
                    }
                    System.out.print("parsed expression: " + result + "\n");
                    System.out.print("evaluated result: " + evaluatedResult + "\n");
                }

            } catch (SyntaxErrorException e) {
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
                continue;
            } catch(IllegalExpressionException e) {
                System.out.print("Error: ");
                System.out.println(e.getMessage());
                continue;
            } catch(IOException e) {
                System.err.println("IO Exception!");
                continue;
            }
        }
        sc.close();
    }
}

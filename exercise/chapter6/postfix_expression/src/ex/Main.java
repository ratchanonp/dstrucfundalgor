package ex;

import datastr.ArrayStack;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expression;
        ArrayStack postfix = new ArrayStack();


        System.out.println("Input Expression (separate by whitespace) : ");
        expression = scanner.nextLine().strip().split(" ");

        for (String op : expression) {
            if (isOperator(op)) {
                int operand_2;
                int operand_1;

                try {
                    operand_2 = Integer.parseInt(postfix.pop().toString());
                    operand_1 = Integer.parseInt(postfix.pop().toString());

                    switch (op) {
                        case "+" -> {
                            postfix.push(operand_1 + operand_2);
                        }
                        case "-" -> {
                            postfix.push(operand_1 - operand_2);
                        }
                        case "*" -> {
                            postfix.push(operand_1 * operand_2);
                        }
                        case "/" -> {
                            postfix.push(operand_1 / operand_2);
                        }
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Not Enough operand to process operation");
                }
            } else {
                // System.out.println("Push : " + op);
                postfix.push(Integer.parseInt(op));
            }
        }

        System.out.println("Result : " + postfix.pop());
    }

    private static boolean isOperator(String input) {
        String operator = "+-*/";
        return operator.contains(input);
    }
}

import java.util.*;
import java.util.Scanner;

public class MathExpressionInterpreter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an number expression: ");
        String input = scanner.nextLine();
        int result = evaluate(input);
        System.out.println("Your result number is: " + result);
    }
    
    private static int evaluate(String input) {
        List<String> postfix = infixToPostfix(input);
        Stack<Integer> exp = new Stack<>();
        for (String token : postfix) {
            if (isNumber(token)) {
                System.out.println("here2");
                exp.push(Integer.parseInt(token));
            } else if (token.equals("+")) {
                int a = exp.pop();
                int b = exp.pop();
                exp.push(a + b);
            } else if (token.equals("-")) {
                int a = exp.pop();
                int b = exp.pop();
                exp.push(b - a);
            } else if (token.equals("*")) {
                int a = exp.pop();
                int b = exp.pop();
                exp.push(a * b);
            } else if (token.equals("/")) {
                int a = exp.pop();
                int b = exp.pop();
                exp.push(b / a);
            }
        }
        return exp.pop();
    }
    
    private static List<String> infixToPostfix(String input) {
        List<String> postfix = new ArrayList<>();
        Stack<String> exp = new Stack<>();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            if (isNumber(token)) {
                postfix.add(token);
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                while (!exp.isEmpty() && !exp.peek().equals("(") && precedence(token) <= precedence(exp.peek())) {
                    postfix.add(exp.pop());
                }
                exp.push(token);
            } else if (token.equals("(")) {
                exp.push(token);
            } else if (token.equals(")")) {
                while (!exp.isEmpty() && !exp.peek().equals("(")) {
                    postfix.add(exp.pop());
                }
                if (!exp.isEmpty() && exp.peek().equals("(")) {
                    exp.pop();
                }
            }
        }
        while (!exp.isEmpty()) {
            postfix.add(exp.pop());
        }
        return postfix;
    }
    
    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
    
    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

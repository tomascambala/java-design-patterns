import java.util.*;
import java.util.Scanner;

public class TextProcessInterpreter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an number: ");
        String input = scanner.nextLine();
        int result = evaluate(input);
        System.out.println("Your result number is: " + result);
    }
    
    private static int evaluate(String input) {
        List<String> postfix = infixToPostfix(input);
        Stack<Integer> stack = new Stack<>();
        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else if (token.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                System.out.println("Input is not valid");
            }
        }
        return stack.pop();
    }
    
    private static List<String> infixToPostfix(String input) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            if (isNumber(token)) {
                postfix.add(token);
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                while (!stack.isEmpty() && !stack.peek().equals("(") && precedence(token) <= precedence(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
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

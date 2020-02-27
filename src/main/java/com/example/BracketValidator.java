package com.example;

import java.util.Stack;

public class BracketValidator {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Please provide open (1 parameter) & close brackets (2 parameter), & text to be search in (3 parameter)");
            System.exit(0);
        }

        String openBracket = args[0];
        if (openBracket.length() > 1) {
            System.err.println("Open bracket could not be more then 1 symbol");
            System.exit(0);
        }

        String closeBracket = args[1];
        if (closeBracket.length() > 1) {
            System.err.println("Close bracket could not be more then 1 symbol");
            System.exit(0);
        }

        String text = args[2];
        if (text.isEmpty()) {
            System.err.println("Text is empty");
            System.exit(0);
        }

        int counter = validate(openBracket.charAt(0), closeBracket.charAt(0), text);
        if (counter > 0) {
            System.err.println("There is more open brackets");
        } else if (counter < 0) {
            System.err.println("There is more close brackets");
        } else {
            System.out.println("All brackets have a pairs");
        }
    }

    private static int validate(char open, char close, String text) {
        Stack<Character> brackets = new Stack<>();
        int closeBracket = 0;
        for (char ch : text.toCharArray()) {
            if (ch == open) {
                brackets.push(ch);
            } else if (ch == close) {
                if (brackets.empty()) {
                    closeBracket--;
                    continue;
                }
                brackets.pop();
            }
        }
        if (brackets.size() > 0) {
            return 1;
        } else {
            return closeBracket;
        }
    }

}

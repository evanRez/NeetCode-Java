package com.mycompany.app.neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class StackSolutions {
    public static boolean isValid(String s) {
        var endToStart = new HashMap<>();
        endToStart.put('}', '{');
        endToStart.put(']', '[');
        endToStart.put(')', '(');

        var stackStruct = new Stack<Character>();
        
        for (var i = 0; i < s.length(); i++) {
            var expected = (char)endToStart.getOrDefault(s.charAt(i), '*');
            if (!stackStruct.isEmpty() && stackStruct.peek() == expected) {
                stackStruct.pop();
            } else {
                stackStruct.push(s.charAt(i));
            }
        }
        return stackStruct.isEmpty();
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push((int) ((double) b / a));
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    public static List<String> generateParenthesis(int n) {
        var res = new ArrayList<String>();
        var stack = new Stack<Character>();

        parenBacktrack(n, 0, 0, stack, res);

        return res;
    }
    
    private static void parenBacktrack(int n, int openN, int closedN, Stack<Character> stack, ArrayList<String> res) {
        if (openN == closedN && openN == n) {
            var parenString = new StringBuilder();
            for (char c : stack) {
                parenString.append(c);
            }
            res.add(parenString.toString());
        }

        if (openN < n) {
            stack.add('(');
            parenBacktrack(n, openN +1, closedN, stack, res);
            stack.pop();
        }

        if (closedN < openN) {
            stack.add(')');
            parenBacktrack(n, openN, closedN +1, stack, res);
            stack.pop();
        }
    }
}

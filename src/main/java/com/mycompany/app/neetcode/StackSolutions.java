package com.mycompany.app.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static int[] dailyTemperatures(int [] temperatures) {
        var res = new int[temperatures.length];
        var stack = new Stack<int[]>();
        for (var i = 0; i < temperatures.length; i++) {
          
            var t = temperatures[i];

            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = (int)(i - pair[1]);
            }

            stack.push(new int[]{t, i});
        }
        return res;
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        var pairs = new double[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Double.compare(b[0], a[0])); //desc order
        
        int fleetCount = 0;
        double[] timeToReach = new double[n];
        for (int i = 0; i < n; i++) {
            timeToReach[i] = (target - pairs[i][0]) / pairs[i][1]; //linear formula: how many 'turns' it will take to get to finish line
            if (i >= 1 && timeToReach[i] <= timeToReach[i - 1]) { // i - 1 means car ahead of it by position since arr is desc
                timeToReach[i] = timeToReach[i -1]; //car can only be as fast as the one ahead of it
            } else {
                fleetCount++; //if we don't catch up to car ahead, it's it's own 'fleet'
            }
        } 
        return fleetCount;
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        var maxStack = new Stack<int[]>();

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!maxStack.isEmpty() && maxStack.peek()[1] > heights[i]) {
                int[] top = maxStack.pop();
                int idx = top[0];
                int h = top[1];
                int w = i - idx;
                maxArea = Math.max(maxArea, h * w);
                start = idx;
            }
            maxStack.push(new int[]{start, heights[i]});
        }

        for (int[] pair: maxStack) {
            int idx = pair[0];
            int h = pair[1];
            int w = heights.length - idx;
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;
    }
}

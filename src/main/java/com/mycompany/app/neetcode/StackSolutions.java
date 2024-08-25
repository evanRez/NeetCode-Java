package com.mycompany.app.neetcode;

import java.util.HashMap;
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
}

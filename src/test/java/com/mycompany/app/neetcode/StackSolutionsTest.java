package com.mycompany.app.neetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class StackSolutionsTest {
    @Test
    public void testIsValid() {
        assertTrue(StackSolutions.isValid("[]"));
        assertTrue(StackSolutions.isValid("([{}])"));
        assertFalse(StackSolutions.isValid("[(])"));
    }
    @Test
    public void testEvalRPN() {
        assertEquals(5, StackSolutions.evalRPN(new String [] {"1","2","+","3","*","4","-"}));
        assertEquals(6, StackSolutions.evalRPN(new String [] {"4","13","5","/","+"}));
    }

    @Test
    public void testGenerateParenthesis() {
        assertEquals(new ArrayList<String>(Arrays.asList("((()))","(()())","(())()","()(())","()()()")), StackSolutions.generateParenthesis(3));
    }

    @Test
    public void testDailyTemperatures() {
        assertArrayEquals(new int [] {1,4,1,2,1,0,0}, StackSolutions.dailyTemperatures(new int[] {30,38,30,36,35,40,28}));
    }

    @Test 
    public void testCarFleet() {
        assertEquals(1, StackSolutions.carFleet(10, new int[] {1,4}, new int[] {3,2}));
    }

    @Test
    public void testLargestRectangleArea() {
        assertEquals(8, StackSolutions.largestRectangleArea(new int[] {7,1,7,2,2,4}));
    }
}

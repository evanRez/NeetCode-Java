package com.mycompany.app.neetcode;

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
}

package com.mycompany.app.neetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StackSolutionsTest {
    @Test
    public void testIsValid() {
        assertTrue(StackSolutions.isValid("[]"));
        assertTrue(StackSolutions.isValid("([{}])"));
        assertFalse(StackSolutions.isValid("[(])"));
    }
}

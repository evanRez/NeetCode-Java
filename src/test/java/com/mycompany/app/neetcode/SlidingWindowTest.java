package com.mycompany.app.neetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SlidingWindowTest {
    @Test 
    public void testMaxProfit() {
        assertEquals(6, SlidingWindow.maxProfit(new int[] {10,1,5,6,7,1}));
        
    }
}

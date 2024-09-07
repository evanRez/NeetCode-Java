package com.mycompany.app.neetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SlidingWindowTest {
    @Test 
    public void testMaxProfit() {
        assertEquals(6, SlidingWindow.maxProfit(new int[] {10,1,5,6,7,1}));
    }

    @Test
    public void testLengthOfLongestSubstring() {
        assertEquals(3, SlidingWindow.lengthOfLongestSubstring("zxyzxyz"));
    }

    @Test
    public void testCharacterReplacement(){
        assertEquals(5, SlidingWindow.characterReplacement("AAABABB", 1));
    }

    @Test
    public void testCheckInclusion() {
        assertTrue(SlidingWindow.checkInclusion("abc", "lecabee"));
    }
}

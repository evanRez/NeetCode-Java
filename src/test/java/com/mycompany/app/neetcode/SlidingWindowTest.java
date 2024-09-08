package com.mycompany.app.neetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        assertTrue(SlidingWindow.checkInclusion("adc", "dcda"));
        assertFalse(SlidingWindow.checkInclusion("hello", "ooolleoooleh"));
    }

    @Test
    public void testMinWindow() {
        assertEquals("YXAZ", SlidingWindow.minWindow("OUZODYXAZV", "XYZ"));
        assertEquals("xyz", SlidingWindow.minWindow("xyz", "xyz"));
        assertEquals("", SlidingWindow.minWindow("x", "xy"));
        assertEquals("BANC", SlidingWindow.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void testMaxSlidingWindow() {
        assertArrayEquals(new int[] {2,2,4,4,6}, SlidingWindow.maxSlidingWindow(new int[] {1,2,1,0,2,4,6}, 3));
    }
}

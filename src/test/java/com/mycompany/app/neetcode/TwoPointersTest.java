package com.mycompany.app.neetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TwoPointersTest {

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[] {1,2}, TwoPointers.twoSum(new int[]{1,2,3,4}, 3));
        assertArrayEquals(new int[] {1,3}, TwoPointers.twoSum(new int[]{2,3,4}, 6));
        assertArrayEquals(new int[]{2,7}, TwoPointers.twoSum(new int[]{-5,-3,0,2,4,6,8}, 5));
    }

    @Test
    public void testThreeSum() {
        List<Integer> firstTestFirstArr = Arrays.asList(-1,-1,2);
        List<Integer> firstTestSecondArray = Arrays.asList(-1, 0, 1);
        List<List<Integer>> firstTestResult = new ArrayList<>();
        firstTestResult.add(firstTestFirstArr);
        firstTestResult.add(firstTestSecondArray);
        
        assertIterableEquals(firstTestResult, TwoPointers.threeSum(new int[]{-1,0,1,2,-1,0,4}));
    }

    @Test
    public void testMaxArea() {
        assertEquals(36, TwoPointers.maxArea(new int[] {1,7,2,5,4,7,3,6}));
        assertEquals(4, TwoPointers.maxArea(new int[] {2,2,2}));
    }

    @Test
    public void testTrap() {
        assertEquals(9, TwoPointers.trap(new int[]{0,2,0,3,1,0,1,3,2,1}));
        assertEquals(6, TwoPointers.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}

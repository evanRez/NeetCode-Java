package com.mycompany.app.neetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    @Test
    public void testSearch() {
        assertEquals(3, BinarySearch.search(new int[] {-1, 0, 2, 4, 6, 8}, 4));
    }

    @Test
    public void testSearchMatrix() {
        assertTrue(BinarySearch.searchMatrix(
            new int[][] {
                new int[] {1,3,5,7}, 
                new int[] {10,11,16,20}, 
                new int[] {23, 30, 34, 60}}, 
            3));
    }

    @Test
    public void testMinEatingSpeed(){
        assertEquals(2, BinarySearch.minEatingSpeed(new int[] {1,4,3,2}, 9));
        assertEquals(4, BinarySearch.minEatingSpeed(new int[] {3,6,7,11}, 8));
    }

    @Test 
    public void testFindMin() {
        //assertEquals(1, BinarySearch.findMin(new int[] {3,4,5,6,1,2}));
        assertEquals(1, BinarySearch.findMin(new int[]{2,1}));
    }

    @Test
    public void testSearchSorted() {
        assertEquals(4, BinarySearch.searchSorted(new int[] {3,4,5,6,1,2}, 1));
        assertEquals(-1, BinarySearch.searchSorted(new int[] {3,5,6,0,1,2}, 4));
        assertEquals(1, BinarySearch.searchSorted(new int[]{1,3}, 3));
    }

    @Test
    public void testTimeMap() {
        var bs = new BinarySearch();
        var timeMap = bs.new TimeMap();
        timeMap.set("test", "one", 10);
        timeMap.set("test", "two", 20);
        timeMap.set("test", "three", 30);
        assertEquals("one", timeMap.get("test", 15));
        assertEquals("two", timeMap.get("test", 25));
        assertEquals("three", timeMap.get("test", 35));
    }

    @Test
    public void testFindMedianSortedArrays() {
        //assertEquals(2, BinarySearch.findMedianSortedArrays(new int[] {1,2}, new int[] {3}));
        assertEquals(2.5, BinarySearch.findMedianSortedArrays(new int[] {1,3}, new int[] {2,4}));
    }
}

package com.mycompany.app.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        var low = 0;
        var high = nums.length - 1;
        
        while (low <= high ) {
            var mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid] ) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        var len = matrix[0].length -1; //3
        var low = 0;
        var high = matrix.length -1; //2
        var arrIdx = -1;

        while (low <= high) {
            var mid = low + ((high - low) / 2); //1 //0
            if (target > matrix[mid][len]) { //3 > matrix[1][3] (20) no //3 > matrix[0][3] 7 no
                low = mid + 1;
            }
            else if (target < matrix[mid][0]) { //3 < 10 - yes// 3 < 1 no
                high = mid - 1; //0 
            }
            else {
                arrIdx = mid; //0
                break;
            }
        }

        if (arrIdx < 0) return false;
        
        low = 0;
        high = len; //3
        
        while (low <= high) {
            var mid = low + ((high - low) / 2); //1
            if (target > matrix[arrIdx][mid]) { // 3 > matrix[0][1] (3) no
                low = mid + 1;
            } else if (target < matrix[arrIdx][mid]) { // 3 < matrix[0][1] (3) no
                high = mid - 1;
            } else {
                return true; //returning because we found the value
            }
        }

        return false;
    }

    public static int minEatingSpeed(int[] piles, int h) {

        var r = Arrays.stream(piles).max().getAsInt();
        var result = r;
        var l = 1;

        while (l <= r) {
            var hours = 0;
            var k = l + ((r - l) /2);

            for (var pile : piles) {
                hours += Math.ceil((double)pile / k);
            }

            if (hours <= h) {
                result = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return result;

    }

    public static int findMin(int[] nums) { //2,1
        var l = 0;
        var r = nums.length -1; //1
      
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            var m = l + ((r - l) /2); //0

            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return 0;
    }

    public static int searchSorted(int[] nums, int target) { //1,3 : 3
        var res = -1;
        var l = 0;
        var r = nums.length -1;

        while (l <= r) {
            var m = l + ((r - l) /2); //0

            if (nums[m] == target) { //6 == 4 no ; 1 == 4 no
                res = m;
                return res;
            }
            //check if our chunk is sorted
            if (nums[l] <= nums[m]) {
                //see if target falls on right side
                if (target > nums[m] || target < nums[l]) {
                    l = m+ 1;
                } else { //must be on left side then
                    r = m-1;
                }
            } else {// can't assume it's sorted
                //see if target falls on the left side
                if (target < nums[m] || target > nums[r]) { 
                    r = m-1; //
                } else { //otherwise check right side
                    l = m+1;
                }
            }
        }
        return res;
    }
    

    public class TimeMap
    {
        private HashMap<String, ArrayList<TimeTuple<Integer, String>>> hash;
        public TimeMap() {
            hash = new HashMap<String, ArrayList<TimeTuple<Integer, String>>>();
        }

        public void set(String key, String value, int timestamp) {
            hash.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeTuple<Integer,String>(timestamp, value));
        }

        public String get(String key, int timestamp) {
           var values = hash.getOrDefault(key, new ArrayList<>());
           var result = "";
           int l = 0, r = values.size() - 1;

           while (l <= r) {
                var m = l + ((r - l) / 2);
                if (timestamp >= values.get(m).getKey()) {
                    result = values.get(m).getValue();
                    l = m + 1;
                } else {
                    r = m - 1;
                }
           }
           return result;
        }
    }

    private class TimeTuple<K, V>
    {
        private final K _key;
        private final V _value;
        public TimeTuple(K key, V value){
            _key = key;
            _value = value;
        }
        public K getKey() {
            return _key;
        }
        public V getValue() {
            return _value;
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var hash = new HashSet<Integer>();
       
        double result = -1;

        for (var item : nums1) {
            hash.add(item);
        }
        for (var item : nums2) {
            hash.add(item);
        }

        var mid = hash.size() / 2;

        var intArr = new ArrayList<Integer>();
    
        for (var item : hash) {
            intArr.add(item);
        }

        Collections.sort(intArr); 

        if (hash.size() % 2 == 0) {
            result = (double)(intArr.get(mid) + intArr.get(mid - 1)) /2;
        } else {
            result = intArr.get(mid);
        }
        return result;
    }
}

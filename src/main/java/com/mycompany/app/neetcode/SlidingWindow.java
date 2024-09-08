package com.mycompany.app.neetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class SlidingWindow {
    public static int maxProfit(int[] prices) {
        var max = 0;
        var left = 0;
        var right = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                max = Math.max(max, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return max;
    }    

    public static int lengthOfLongestSubstring(String s) {
        var hash = new HashSet<Character>();
        var maxSize = 0;
        var left = 0;

        for (int i = 0; i < s.length(); i++) {
            while (hash.contains(s.charAt(i))) {
                hash.remove(s.charAt(left));
                left++;
            }
            hash.add(s.charAt(i));
            maxSize = Math.max(maxSize, i - left + 1);
        }
        return maxSize;
    }

    public static int characterReplacement(String s, int k) {
        var hash = new HashMap<Character, Integer>();
        var maxWindow = 0;
        var maxCount = 0;
        var l = 0;

        for (var r = 0; r < s.length(); r++) {
           var currentLetter = hash.putIfAbsent(s.charAt(r), 1);
           if (currentLetter != null) {
                currentLetter++;
                hash.replace(s.charAt(r), currentLetter);
           }
           maxCount = Math.max(hash.get(s.charAt(r)), maxCount);

           if (r - l + 1 - maxCount > k) {
                hash.replace(s.charAt(l), hash.get(s.charAt(l)) - 1);
                l++;
           } 

           maxWindow = Math.max(maxWindow, r - l + 1);
        }
        
        return maxWindow;
    }

    public static boolean checkInclusion(String s1, String s2) {
        //Fail edge case immediately
        if (s1.length() > s2.length()) return false;

        //Create hashSets for both s1 and the current window
        var targetMap = new HashMap<Character, Integer>();
        var windowMap = new HashMap<Character, Integer>();

        //initialize the targetSet, can have multiple of same character
        for (char c : s1.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        //Initialize left and right pointers and result var
        var l = 0;
        var r = 0;

        //Set up the sliding window
        while (r < l + s1.length()) {
            windowMap.put(s2.charAt(r), windowMap.getOrDefault(s2.charAt(r), 0) +1);
            r++;
        }
         //Case when permutation exists return true
        if (targetMap.equals(windowMap)) {
            return true;
        }

        while (r < s2.length()) {
            //update the windowMap right side
            var rightChar = s2.charAt(r);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0)+1);

            //update windowMap left side
            var leftChar = s2.charAt(l);
            if (windowMap.get(leftChar) == 1) {
                windowMap.remove(leftChar);
            } else {
                windowMap.put(leftChar, windowMap.get(leftChar) -1);
            }

            //Case when permutation exists return true
            if (targetMap.equals(windowMap)) {
                return true;
            }

            //Move the window
            r++;
            l++;
        }
        return false;
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
    
        // HashMaps to store frequency of characters in target string
        var tHash = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            tHash.put(c, tHash.getOrDefault(c, 0) + 1);
        }
    
        // Variables to track the window
        var compareHash = new HashMap<Character, Integer>();
        int l = 0, leftIdx = 0, rightIdx = s.length();
        int minWindowSize = Integer.MAX_VALUE;
        int matched = 0;  // Number of characters fully matched
        boolean isValid = false;
    
        // Sliding window
        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            if (tHash.containsKey(rightChar)) {
                compareHash.put(rightChar, compareHash.getOrDefault(rightChar, 0) + 1);
    
                // Check if we have matched the required frequency of this character
                if (compareHash.get(rightChar).intValue() == tHash.get(rightChar).intValue()) {
                    matched++;
                }
            }
    
            // Shrink the window once all characters are matched
            while (matched == tHash.size()) {
                isValid = true;
                int windowSize = r - l + 1;
                if (windowSize < minWindowSize) {
                    minWindowSize = windowSize;
                    leftIdx = l;
                    rightIdx = r;
                }
    
                // Shrink window from the left
                char leftChar = s.charAt(l);
                if (tHash.containsKey(leftChar)) {
                    compareHash.put(leftChar, compareHash.get(leftChar) - 1);
                    if (compareHash.get(leftChar) < tHash.get(leftChar)) {
                        matched--;
                    }
                }
                l++;  // Move left pointer
            }
        }
    
        return isValid ? s.substring(leftIdx, rightIdx + 1) : "";
    }
    

    public static int[] maxSlidingWindow(int[] nums, int k) {
       
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];  // Result array to hold the maximum for each window
        Deque<Integer> deque = new LinkedList<>();  // Deque to store indices of elements

        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from the back of the deque if they are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // Once the first k elements are processed, start adding the maximums to the result array
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}

package com.mycompany.app.neetcode;

import java.util.HashMap;
import java.util.HashSet;

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
        var hash = new HashMap<Character, Integer>();
        for (char item : s1.toCharArray()) {
            hash.put(item, 0);
        }
        var total = 0;
        var result = false;

        for (var i = 0; i < s2.length(); i++) {
            if (!hash.containsKey(s2.charAt(i))) {
                hash.replaceAll((k,v) -> 0);
                total = 0;
            }
            hash.putIfAbsent(s2.charAt(i), 1);

            for (int val : hash.values()) {
                total = total + val;
            }
            if (total == s1.length()) {
                result = true;
                break;
            } 
        }
        return result;
    }
}

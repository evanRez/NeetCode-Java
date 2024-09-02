package com.mycompany.app.neetcode;

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
}

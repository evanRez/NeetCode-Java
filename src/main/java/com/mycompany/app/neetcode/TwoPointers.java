package com.mycompany.app.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int curSum = numbers[l] + numbers[r];

            if (curSum > target) {
                r--;
            } else if (curSum < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }

        return new int[0];
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //first sort the array
        Arrays.sort(nums);
        //initialize the return array
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            //stop early when val already over 0
            if (nums[i] > 0) break;
            //Make sure we skip the value if we've already used it
            if (i > 0 && nums[i] == nums[i-1]) continue;

            //let's use combine our first value with the algo for 2sumII
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int curSum = nums[i] + nums[l] + nums[r];
                if (curSum > 0) {
                    r--;
                } else if (curSum < 0) {
                    l++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //not clear on logic. Outer while loop handles it
                    l++;
                    r--;
                    while (nums[l] == nums[l-1] && l < r) {
                        l++;
                    }
                }
            }
        }
        return result;
    }

    public static int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int curArea = width * height;
            maxArea = Math.max(curArea, maxArea);
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l]; int rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}

package leetCode.dailyQuestion.MinSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int tmp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            tmp += num;
            sum -= num;
            res.add(num);
            if (tmp > sum) {
                break;
            }
        }
        return res;
    }
}
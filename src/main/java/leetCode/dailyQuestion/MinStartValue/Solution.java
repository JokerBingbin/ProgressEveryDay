package leetCode.dailyQuestion.MinStartValue;

public class Solution {

    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (min > sum) {
                min = sum;
            }
        }
        if (min < 0) {
            return 1 - min;
        } else {
            return 1;
        }
    }

}

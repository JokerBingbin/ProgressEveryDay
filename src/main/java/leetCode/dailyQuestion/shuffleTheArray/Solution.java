package leetCode.dailyQuestion.shuffleTheArray;

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n*2];
        int i = 0, j = n;
        int index = 0;
        for (;i < n; i++, j++) {
            res[index++] = nums[i];
            res[index++] = nums[j];
        }
        return res;
    }
}

package leetCode.dailyQuestion.maxProduct;

public class Solution {

    public int maxProduct(int[] nums) {
        int a = nums[0], b = nums [1];
        if (a < b) {
            a = nums[1];
            b = nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= a) {
                b = a;
                a = nums[i];
            }else if (nums[i] >= b) {
                b = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{10,2,5,2}));
    }
}



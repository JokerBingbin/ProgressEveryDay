package leetCode.dailyQuestion.ReplaceChalk;


/**
* 题目：
 * 一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为 n - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
 *
 * 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，他会消耗 chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
 *
 * 请你返回需要 补充 粉笔的学生 编号
*/
public class Solution {

    /**
     * 暴力法 一直遍历
     */
    public int chalkReplacerWithViolence(int[] chalk, int k) {
        int i = 0;
        while(chalk[i] <= k) {
            k -= chalk[i];
            i++;
            if (i == chalk.length) {
                i = 0;
            }
        }
        return i;
    }

    /**
     * 优化，记录所有学生需要的粉笔数量sum,遍历一次后 让k对sum取余, 那么接下来至多只需要一次遍历就能找到
     */
    public int chalkReplacerWithOptimization(int[] chalk, int k) {
        int sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            if(chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
            sum += chalk[i];
        }
        k = k % sum;
        for (int i = 0; i < chalk.length; i++) {
            if(chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }

    /**
     * 二分查找。沿用上一个优化的思路，用一个数组保存前缀和，利用二分查找找到。
     */
    public int chalkReplacerWithBinarySearch(int[] chalk, int k) {
        int[] pre = new int[chalk.length];
        for (int i = 0;i < chalk.length; i++) {
            if( i == 0) {
                pre[i] = chalk[i];
            } else {
                pre[i] = pre[i - 1] + chalk[i];
            }
            if(chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        k %= pre[pre.length - 1];
        if(k == 0){
            return 0;
        }
        return BinarySearch(pre, k);
    }

    /**
     * 这里的二分查找是为了找到第一个大于target的数
     */
    private int BinarySearch(int[] arr,int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;          //有效防止mid的值溢出
            if (arr[mid] == target) {
                return mid + 1;                           //这里不用担心溢出问题，因为target < arr[arr.length - 1]
            }
            if (arr[mid] < target && arr[mid + 1] >= target) {
                return mid + 1;
            }
            if (arr[mid] > target && (mid == 0 || arr[mid - 1] <= target)) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else if(arr[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}

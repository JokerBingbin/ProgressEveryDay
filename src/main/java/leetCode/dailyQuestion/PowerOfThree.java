package leetCode.dailyQuestion;

/**
 * 3的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 */
public class PowerOfThree {

    /**
     * 3的幂是很特殊的数字。为什么特殊？
     * 一个数只要是3的幂，那么他的所有因数都是3的幂。
     * 利用这一特性，因为题目给的n最大是2^31 - 1
     * 在这范围内3的最大幂就是1162261467
     * 所以只需要判断n是否是1162261467的因数即可。
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

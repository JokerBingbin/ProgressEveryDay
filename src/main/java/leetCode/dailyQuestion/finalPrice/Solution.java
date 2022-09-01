package leetCode.dailyQuestion.finalPrice;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {

    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
             while (!stack.isEmpty() && stack.peek() > prices[i]) {
                 stack.pop();
             }
             res[i] = stack.isEmpty()? prices[i] : prices[i] - stack.peek();
             stack.push(prices[i]);
        }
        return res;
    }

}

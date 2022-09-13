package leetCode.dailyQuestion.maximumSwap;

public class Solution {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();

        return Integer.parseInt(new String(find(chars, 0)));
    }

    private char[] find(char[] chars, int index) {
        if (index == chars.length) {
            return chars;
        }
        char max = chars[index];
        int tempIndex = index;
        for (int i = index + 1; i < chars.length; i++) {
            if (chars[i] >= max && chars[index] != chars[i]) {
                max = chars[i];
                tempIndex = i;
            }
        }
        if (tempIndex == index) {
            return find(chars, index + 1);
        } else {
            chars[tempIndex] = chars[index];
            chars[index] = max;
            return chars;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(98368));
    }
}

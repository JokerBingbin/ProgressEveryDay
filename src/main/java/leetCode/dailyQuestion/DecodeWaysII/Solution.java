package leetCode.dailyQuestion.DecodeWaysII;

public class Solution {

    private final int MOD = 1000000007;

    public int numDecodings(String s) {
        // a = f[i - 2]  b = f[i - 1]  c = f[i]
        long a = 0, b = 1, c = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            c = b * checkI(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * checkII(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public int checkI(Character c) {
        if (c == '0') {
            return 0;
        }
        return c == '*' ? 9 : 1;
    }

    public int checkII(Character c1, Character c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        }
        if (c1 == '*') {
            return c2 <= '6' ? 2 : 1;
        }
        if (c2 == '*') {
            if (c1 == '1') {
                return 9;
            }
            if (c1 == '2') {
                return 6;
            }
            return 0;
        }
        return ( c1 != '0' && (c1 - '0') * 10 + (c2 - '0') <= 26) ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "1003";
        Solution decodeWaysII = new Solution();
        System.out.println(decodeWaysII.numDecodings(s));
    }
}

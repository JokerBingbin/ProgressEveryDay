package leetCode.dailyQuestion.SolveEquation;

public class Solution {

    public String solveEquation(String equation) {
        int flag1 = 1;
        int a = 0, b = 0;
        int i = 0, n = equation.length();
        while (i < n) {
            if (equation.charAt(i) == '=') {
                flag1 = -flag1;
                i ++;
                continue;
            }
            int flag2 = flag1;

            if (equation.charAt(i) == '+') {
                flag2 = flag1;
                i++;
            } else if (equation.charAt(i) == '-') {
                flag2 = -flag1;
                i++;
            }
            int x = 0;
            boolean valid = false;
            while (i<n && Character.isDigit(equation.charAt(i))) {
                x = 10*x + (equation.charAt(i) - '0');
                i ++;
                valid = true;
            }
            x = flag2 * x;
            if (i < n && equation.charAt(i) == 'x') {
                a += valid? x : flag2;
                i ++;
            } else {
                b += x;
            }
        }
        if (a == 0) {
            return b == 0? "Infinite solutions" : "No Solution";
        }
        if (b % a != 0) {
            return "No Solution";
        }
        return "x=" + (-b/a);
    }

    public static void main(String[] args) {
        String s = "2x+3x-6x=x+2";
        System.out.println(new Solution().solveEquation(s));
    }
}


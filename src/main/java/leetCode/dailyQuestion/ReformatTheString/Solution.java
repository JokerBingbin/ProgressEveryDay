package leetCode.dailyQuestion.ReformatTheString;

public class Solution {
    public String reformat(String s) {
        int digitNUm = 0;
        int left = 0, right = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digitNUm ++;
            }
        }
        int workNum = s.length() - digitNUm;
        if (Math.abs(workNum-digitNUm) > 1) {
            return "";
        }
        int i = 0, j = 1;
        boolean flag = digitNUm > workNum;
        char[] res = s.toCharArray();
        for(;i < s.length(); i+=2) {
            if (Character.isDigit(res[i]) != flag) {
                while (Character.isDigit(res[j]) != flag) {
                    j += 2;
                }
                swap(res, i, j);
            }
        }
        return new String(res);
    }

    public void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}

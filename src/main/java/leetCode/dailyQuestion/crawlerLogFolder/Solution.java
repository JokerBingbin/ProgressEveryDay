package leetCode.dailyQuestion.crawlerLogFolder;

public class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                res = res == 0? 0: res-1;
            } else if (log.equals("./")) {

            } else {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","../","d21/","./"};
        System.out.println(new Solution().minOperations(logs));
    }
}

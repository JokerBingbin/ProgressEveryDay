package leetCode.dailyQuestion.reorderSpaces;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reorderSpaces(String text) {
        int textLength = text.length();
        String[] words = text.trim().split("\\s+");
        int spaceNum = textLength;
        for (String word : words) {
            spaceNum -= word.length();
        }
        StringBuilder res = new StringBuilder();
        int wordsSize = words.length;
        if (wordsSize == 1) {
            res.append(words[0]);
            for (int i = 0; i < spaceNum; i++) {
                res.append(' ');
            }
            return res.toString();
        }
        int average = spaceNum / (wordsSize - 1);
        int remaining = spaceNum % (wordsSize - 1);
        for (int i = 0; i < wordsSize; i++) {
            res.append(words[i]);
            if (i != wordsSize - 1) {
                for (int j = 0;j < average; j ++) {
                    res.append(' ');
                }
            }
        }
        for (int i = 0; i < remaining; i++) {
            res.append(' ');
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces("  this   is  a sentence "));
    }
}

package leetCode.dailyQuestion;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 */
public class LongestWordInDictionaryThroughDeleting {

    /**
     * 双指针法。通过双指针判断一个字符串是不是s的子序列
     * 而题目要求答案不止一个的时候，返回长度最长且字典序最小的，那么我们在长度相等时就要判断一下字典序的问题
     */
    public String findLongestWordWithDoublePoint(String s, List<String> dictionary) {
        String res = "";
        for (String str: dictionary) {
            int i = 0, j = 0;
            while(i < s.length() && j < str.length()) {
                if(s.charAt(i) == str.charAt(j)) {
                    i ++;
                    j ++;
                } else {
                    i++;
                }
            }
            if(j == str.length()) {
                if(str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }
        return res;
    }

    /**
     * 在上面的解法中，我们可以先把字典排序。
     * 按照长度降序，字典序升序的顺序排序，这样匹配到的第一个字符串就是结果
     */
    public String findLongestWordWithOrder(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            } else {
                return o1.compareTo(o2);
            }
        });
        for (String str: dictionary) {
            int i = 0, j = 0;
            while(i < s.length() && j < str.length()) {
                if(s.charAt(i) == str.charAt(j)) {
                    i ++;
                    j ++;
                } else {
                    i++;
                }
            }
            if(j == str.length()) {
                return str;
            }
        }
        return "";
    }




}

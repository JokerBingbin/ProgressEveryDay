package leetCode.dailyQuestion.subdomainVisits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 811. 子域名访问计数
 * 网站域名 "discuss.leetcode.com" 由多个子域名组成。顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。
 *
 * 计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。
 *
 * 例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
 * 给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。可以按 任意顺序 返回答案。
 *
 *  https://leetcode.cn/problems/subdomain-visit-count/
 */
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : cpdomains) {
            int num = Integer.parseInt(s.split(" ")[0]);
            String url = s.split(" ")[1];
            String[] domains = getDomains(url);
            for (String domain : domains) {
                int n = map.getOrDefault(domain, 0);
                map.put(domain, n + num);
            }
        }

        List<String> res = new ArrayList<>();
        for (String domain : map.keySet()) {
            res.add(map.get(domain) + " " + domain);
        }
        return res;
    }

    private String[] getDomains(String url) {
        String[] res = url.split("\\.");
        if (res.length == 3) {
            res[0] = res[0] + "." + res[1] + "." + res[2];
            res[1] = res[1] + "." + res[2];
        }
        if (res.length == 2) {
            res[0] = res[0] + "." + res[1];
        }
        return res;
    }
}

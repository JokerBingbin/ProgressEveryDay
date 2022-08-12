package leetCode.dailyQuestion.GroupThePeople;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (size == 1) {
                ArrayList<Integer> group = new ArrayList<>();
                group.add(i);
                res.add(group);
                continue;
            }
            if (map.containsKey(size)) {
                List<Integer> group = map.get(size);
                group.add(i);
                if (group.size() == size) {
                    map.remove(size, group);
                    res.add(group);
                }
            } else {
                List<Integer> group = new ArrayList<>();
                group.add(i);
                map.put(size, group);
            }
        }
        return res;
    }
}

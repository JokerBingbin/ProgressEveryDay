package leetCode.dailyQuestion.OrderedStream;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    private final String[] arr;
    private int pre;

    public OrderedStream(int n) {
        arr = new String[n + 1];
        pre = 1;
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> res = new ArrayList<>();
        while (pre < arr.length && arr[pre] != null) {
            res.add(arr[pre]);
            pre++;
        }
        return res;
    }
}

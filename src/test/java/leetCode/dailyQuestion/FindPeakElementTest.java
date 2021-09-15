package leetCode.dailyQuestion;

import org.junit.Assert;
import org.junit.Test;

public class FindPeakElementTest {

    @Test
    public void testFindPeakElementTest() {
        int[] nums = {1};
        Assert.assertEquals(0, FindPeakElement.findPeakElement(nums));
    }

}

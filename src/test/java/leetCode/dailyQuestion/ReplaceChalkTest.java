package leetCode.dailyQuestion;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReplaceChalkTest {

    int[] mChalk = new int[]{5, 1, 5};
    int k = 22;
    ReplaceChalk solution = new ReplaceChalk();



    @Test
    public void testChalkReplacerWithViolence() {
        Assert.assertEquals(0, solution.chalkReplacerWithViolence(mChalk, k));
    }

    @Test
    public void testChalkReplacerWithOptimization() {
        Assert.assertEquals(0, solution.chalkReplacerWithOptimization(mChalk, k));
    }

    @Test
    public void testChalkReplacerWithBinarySearch() {
        Assert.assertEquals(0, solution.chalkReplacerWithBinarySearch(mChalk, k));
    }

}

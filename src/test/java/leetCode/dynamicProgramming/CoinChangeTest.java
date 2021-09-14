package leetCode.dynamicProgramming;

import org.junit.Test;

public class CoinChangeTest {


    @Test
    public void coinChangeTest() {
        int[] coins = {1, 2 ,5};
        int amount = 11;
        System.out.println(CoinChange.coinChange(coins, amount));
    }

}

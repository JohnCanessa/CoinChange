import java.util.Arrays;
import java.util.Scanner;

/**
 * 322. Coin Change 
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {


    /**
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that amount. 
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     * You may assume that you have an infinite number of each kind of coin.
     * 
     * Dynamic programming question.
     * Bottom up approach.
     * 
     * Runtime: 11 ms, faster than 88.15% of Java online submissions.
     * Memory Usage: 38.2 MB, less than 6.61% of Java online submissions,
     */
    static int coinChange(int[] coins, int amount) {
        
        // **** sanity check(s) ****
        if (amount == 0)
            return 0;

        // **** sort coins in ascending order ****
        Arrays.sort(coins);

        // **** initialization ****
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        // ???? ????
        System.out.println("<<< dp: " + Arrays.toString(dp));

        // **** loop for all amounts until we reach the desired one ****
        for (int a = 0; a <= amount; a++) {

            // **** iterate through all the coins ****
            for (int c = 0; c < coins.length; c++) {

                // **** ****
                if (coins[c] <= a) {

                    // ???? ????
                    System.out.println("<<< min(" + dp[a] + "," + (1 + dp[a - coins[c]]) + ")");

                    // **** min of ****
                    int m = Math.min(dp[a], 1 + dp[a - coins[c]]);

                    // ???? ????
                    System.out.println("<<< a: " + a + " c: " + c + " m: " + m);

                    // **** ****
                    dp[a] = m;
                } else {

                    // ???? ????
                    // System.out.println("<<< coins[" + c + "]: " + coins[c] + " > a: " + a);

                    // **** get to the next larger denomination coin ****
                    // break;
                }
            }

        }

        // ???? ????
        System.out.println("<<< dp: " + Arrays.toString(dp));

        // **** return result ****
        return dp[amount] > amount ? -1 : dp[amount];
    }


    /**
     * Test scaffolding
     */
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read the coin denominations ****
        String[] denominations = sc.nextLine().trim().split(",");

        // **** read the amount ****
        int amount = Integer.parseInt(sc.nextLine().trim());

        // **** close scanner ****
        sc.close();

        // *** convert denomination string to integer ****
        int coins[] = new int[denominations.length];
        for (int i = 0; i < coins.length; i++)
            coins[i] = Integer.parseInt(denominations[i]);

        // **** display the parameters for the function ****
        System.out.println("main <<<  coins: " + Arrays.toString(coins));
        System.out.println("main <<< amount: " + amount);

        // **** process the data and display results ****
        System.out.println("main <<<  coinChange: " + coinChange(coins, amount));
    }
}
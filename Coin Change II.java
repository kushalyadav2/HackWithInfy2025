/*Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1

----------------------------------------------*/

using Recursion only
-----------------

class Solution {
    public int change(int amount, int[] coins) {
        return solve(0, amount, coins);
    }

    public int solve(int i, int amount , int[] coins){
        if(amount ==0) return 1;
        if(i == coins.length) return 0;

        int ans=0;
        if(amount >= coins[i])
            ans += solve(i, amount-coins[i], coins);
        ans += solve(i+1, amount, coins);
        

        return ans;
    }
}

Using Recursion + Memoization
--------------------------------
class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[301][5001];
        for(int d[] : dp){
            Arrays.fill(d, -1);
        }
        return solve(0, amount, coins, dp);
    }

    public int solve(int i, int amount , int[] coins, int[][] dp){
        if(amount ==0) return 1;
        if(i == coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];

        
        if(amount < coins[i])
            return dp[i][amount] = solve(i+1, amount, coins, dp);

        int take = solve(i, amount-coins[i], coins, dp);
        int nontake = solve(i+1, amount, coins, dp);

        return dp[i][amount] = take+nontake;
    }
}

Using Recursion + Tabulation
--------------------------------

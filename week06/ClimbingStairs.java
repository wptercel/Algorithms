/**
* 思路：动规计算状态转移方程f(i) = f(i - 1) + f(i - 2)
* 空间复杂度：可优化为O(1)
* 时间复杂度：O(n)
*/
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        return dp[n % 3];
    }
}

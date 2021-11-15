/**
* 思路：动规状态转移方程f(layer, index) = min(f(layer - 1, index - 1), f(layer - 1, index)) + triangle(layer, index)
* 空间复杂度：O(n)
* 时间复杂度：O(n)
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int layers = triangle.size();
        int leaves = triangle.get(layers - 1).size();
        
        int[][] dp = new int[2][leaves + 2];
        dp[0][0] = Integer.MAX_VALUE;
        dp[0][1] = triangle.get(0).get(0);
        dp[0][2] = Integer.MAX_VALUE;
        
        for(int i = 1; i < layers; i++) {
            dp[i % 2][0] = Integer.MAX_VALUE;
            dp[i % 2][i + 2] = Integer.MAX_VALUE;
            for(int j = 1; j <= i + 1; j++) {
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]) + triangle.get(i).get(j - 1);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= leaves; i++) {
            result = Math.min(result, dp[(layers - 1) % 2][i]);
        }
        return result;
    }
}

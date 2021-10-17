class Solution {
    /**
    * 思路：构造前缀数组，在前缀数组上便利子数组找到和为target的。
    * 空间复杂度：m*n
    * 时间复杂度: 需要遍历两遍数组来找到子数组的左上和右下坐标 O((m*n)^2)
    */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preSumMatrix = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                preSumMatrix[i][j] = preSumMatrix[i][j - 1] + preSumMatrix[i - 1][j] - preSumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        
        int result = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 0; k < i; k++) {
                    for(int l = 0; l < j; l++) {
                        int sum = preSumMatrix[i][j] - preSumMatrix[k][j] - preSumMatrix[i][l] + preSumMatrix[k][l];
                        result += sum == target ? 1 : 0;
                    }
                }
            }
        }
        return result;
    }
}

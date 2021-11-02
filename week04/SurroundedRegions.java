  /**
    思路：找到并记录和边缘联通的'O'，用'X'填充所有其他位置。
    空间复杂度：O(mn)
    时间复杂度：O(图中的平均联通块数*每块的平均面积)最坏是O(mn)。最后填充每格需要O(mn)。所以时间复杂度是O(mn)。 
 */
class Solution {
    private int[] dy = new int[] {0, 1, 0, -1};
    private int[] dx = new int[] {1, 0, -1, 0};
    
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Set<Integer> oSet = new HashSet<>(); //记录所有不会被填充的坐标。将二维坐标转化为一维存储，省去写hashCode和equal函数
        for(int i = 0; i < n - 1; i++) { // upper bound
            if(oSet.contains(i)) continue;
            dfs(oSet, board, 0, i);
        }
        for(int i = 0; i < m - 1; i++) { // right bound
            if(oSet.contains(n * i + n - 1)) continue;
            dfs(oSet, board, i, n - 1);
        }
        for(int i = n - 1; i > 0; i--) { // lower bound
            if(oSet.contains((m - 1) * n + i)) continue;
            dfs(oSet, board, m - 1, i);
        }
        for(int i = m - 1; i > 0; i--) { // left bound
            if(oSet.contains(i * n)) continue;
            dfs(oSet, board, i, 0);
        }

        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(!oSet.contains(i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(Set<Integer> oSet, char[][] board, int y, int x) {
        int m = board.length;
        int n = board[0].length;
        if(y < 0 || x < 0 || y >= m || x >= n || board[y][x] == 'X' || oSet.contains(y * n + x)) {
            return;
        }

        oSet.add(y * n + x);
        for(int i = 0; i < 4; i++) {
            dfs(oSet, board, y + dy[i], x + dx[i]);
        }
    }
}

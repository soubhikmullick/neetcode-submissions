class Solution {
    int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                result = Math.max(result, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        return result;
    }

    public int dfs(int[][] matrix, int row, int col, int prevValue) {
        if(row<0 || row>= matrix.length || col<0 || col>=matrix[0].length ||
        matrix[row][col]<=prevValue) {
            return 0;
        }
        int res = 1;
        if(dp[row][col]!=-1) return dp[row][col];
        for(int[] d : dirs) {
            res = Math.max(res, 1+dfs(matrix, row+d[0], col+d[1], matrix[row][col]));
        }
        return dp[row][col] = res;
    }
}

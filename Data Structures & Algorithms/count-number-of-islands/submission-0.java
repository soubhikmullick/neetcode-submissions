class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        Set<String> visited = new HashSet<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1' && !visited.contains(Character.toString(i)+Character.toString(j))){
                    dfs(grid, i, j, res, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col, int res, Set<String> visited) {
        if(row>=grid.length || col>=grid[0].length || row<0 || col<0 || grid[row][col] == '0'
        || visited.contains(Character.toString(row)+Character.toString(col))) {
            return;
        }
        visited.add(Character.toString(row)+Character.toString(col));
        dfs(grid, row, col+1, res, visited);
        dfs(grid, row+1, col, res, visited);
        dfs(grid, row, col-1, res, visited);
        dfs(grid, row-1, col, res, visited);
    }
}

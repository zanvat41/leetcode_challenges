class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    total = Math.max(total, dfs(grid, i, j));
                }
            }
        }

        return total;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;
        return 1
                + dfs(grid, x + 1, y)
                + dfs(grid, x - 1, y)
                + dfs(grid, x, y + 1)
                + dfs(grid, x, y - 1);
    }
}

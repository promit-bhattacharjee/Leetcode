package LeetCode;

public class NumberOfIsland {
    class Solution {
        private boolean[][] vis;

        public void DFS(char[][] grid, int row, int col) {
            // stop if out of bounds, water, or already visited
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
                    || grid[row][col] == '0' || vis[row][col])
                return;

            vis[row][col] = true;

            // visit neighbors
            DFS(grid, row + 1, col);
            DFS(grid, row - 1, col);
            DFS(grid, row, col + 1);
            DFS(grid, row, col - 1);
        }

        public int numIslands(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            vis = new boolean[row][col];
            int totalIsland = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1' && !vis[i][j]) {
                        DFS(grid, i, j);
                        totalIsland++;
                    }
                }
            }
            return totalIsland;
        }
    }

    public static void main(String[] args) {
        NumberOfIsland out = new NumberOfIsland();
        NumberOfIsland.Solution sn = out.new Solution();

        char[][] arr = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        System.out.println(sn.numIslands(arr)); // ✅ Output: 1
    }
}

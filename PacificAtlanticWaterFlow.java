package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PacificAtlanticWaterFlow {
    class Solution {

        public void DFS(int row, int col, int heights[][], HashSet<List> vis, int prevHeight) {
            // boundary and condition check
            if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) {
                return;
            }
            if (heights[row][col] < prevHeight) {
                return;
            }
            if (vis.contains(Arrays.asList(row, col))) {
                return;
            }

            vis.add(Arrays.asList(row, col));

            DFS(row + 1, col, heights, vis, heights[row][col]);
            DFS(row - 1, col, heights, vis, heights[row][col]);
            DFS(row, col + 1, heights, vis, heights[row][col]);
            DFS(row, col - 1, heights, vis, heights[row][col]);
        }

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int row = heights.length;
            int col = heights[0].length;

            HashSet<List> pac = new HashSet<>();
            HashSet<List> alt = new HashSet<>();

            // Pacific (left + top)
            for (int i = 0; i < row; i++) {
                DFS(i, 0, heights, pac, heights[i][0]);
                DFS(i, col - 1, heights, alt, heights[i][col - 1]);
            }
            for (int j = 0; j < col; j++) {
                DFS(0, j, heights, pac, heights[0][j]);
                DFS(row - 1, j, heights, alt, heights[row - 1][j]);
            }

            // intersection
            pac.retainAll(alt);

            // convert to list<List<Integer>>
            List<List<Integer>> ans = new ArrayList<>();
            for (List cell : pac) {
                List<Integer> temp = new ArrayList<>();
                temp.add((Integer) cell.get(0));
                temp.add((Integer) cell.get(1));
                ans.add(temp);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow out = new PacificAtlanticWaterFlow();
        PacificAtlanticWaterFlow.Solution sn = out.new Solution();
        int[][] heights = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        System.out.println(sn.pacificAtlantic(heights));
    }
}

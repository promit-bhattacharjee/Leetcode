package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UniquePaths {
    class Solution {
        public int DFS(int nodes[][], int row, int col) {
            if (row == nodes.length || col == nodes[row].length) return 0;
            else if (row == nodes.length-1 && col == nodes[0].length-1) return 1;
            if(nodes[row][col]!=-1) return nodes[row][col];
            nodes[row][col]= DFS(nodes, row, col + 1)+ DFS(nodes, row + 1, col);    
            return nodes[row][col];
        }

        public int uniquePaths(int m, int n) {
            int nodes[][] = new int[m][n];
            nodes[m - 1][n - 1] = 1;
            for(int[] i:nodes){
                Arrays.fill(i,-1);
            }
            return DFS(nodes, 0, 0);
        }
    }

    public static void main(String[] args) {
        UniquePaths outer = new UniquePaths();
        UniquePaths.Solution sol = outer.new Solution();
        int m = 3;
        int n = 2;
        sol.uniquePaths(m, n);

    }
}

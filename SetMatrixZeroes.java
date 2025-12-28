package LeetCode;

import java.util.HashSet;

public class SetMatrixZeroes {
    class Solution {
        // void setValues()
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            HashSet<Integer> visRow = new HashSet();
            HashSet<Integer> visCol = new HashSet();
            // boolean visCol[]= new boolean[col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        visRow.add(i);
                        visCol.add(j);
                    }
                }
            }
            if (!visRow.isEmpty()) {
                for (int idx : visRow) {
                    for (int i = 0; i < col; i++) {
                        matrix[idx][i]=0;
                    }
                }
                for (int idx : visCol) {
                    for (int i = 0; i < row; i++) {
                        matrix[i][idx]=0;
                    }
                }
            }
        }
    }

}
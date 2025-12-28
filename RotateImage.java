package LeetCode;

public class RotateImage {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int row = 0; row < n; row++) {
                for (int col = row + 1; col < n; col++) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }

            for (int row = 0; row < n; row++) {
                int startCol = 0;
                int endCol = n - 1;
                while (startCol < endCol) {
                    int temp = matrix[row][startCol];
                    matrix[row][startCol] = matrix[row][endCol];
                    matrix[row][endCol] = temp;
                    startCol++;
                    endCol--;
                }
            }

        }
    }

    public static void main(String[] args) {
        RotateImage out = new RotateImage();
        RotateImage.Solution sn = out.new Solution();
        int nums[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        sn.rotate(nums);
    }
}

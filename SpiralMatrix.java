package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> li = new ArrayList<>();
            int rowLength = matrix.length;
            int colLenght = matrix[0].length;
            int left = 0;
            int right = colLenght - 1;
            int top = 0;
            int bottom = rowLength - 1;

            while (top <= bottom && left <= right) {
                // left->Right
                for (int i = left; i <= right; i++) {
                    li.add(matrix[top][i]);
                }
                top++;
                // top->bottom
                for (int i = top; i <= bottom; i++) {
                    li.add(matrix[i][right]);
                }
                right--;
                if (top <= bottom) continue;
                // Right->Left
                for (int i = right; i >= left; i--) {
                    li.add(matrix[bottom][i]);
                }
                bottom--;
                if (left <= right) continue;
                // Bottom->top
                 for (int i = bottom; i >= top; i--) {
                        li.add(matrix[i][left]);
                    }
                    left++;
                

            }
            return li;
        }
    }
}

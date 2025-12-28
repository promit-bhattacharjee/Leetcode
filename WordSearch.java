package LeetCode;

public class WordSearch {
    class Solution {
        public boolean DFS(char[][] board, String word, int row, int col,int index) {
            if (index==word.length()) {
                return true;
            }
            if (row >= board.length || col >= board[0].length || row < 0 || col < 0) {
                return false;
            }
            if (word.charAt(index) == board[row][col]) {
                char c = board[row][col];
                board[row][col] = '#';
                boolean found = DFS(board, word, row - 1, col,index+1) ||
                        DFS(board, word, row, col + 1,index+1) ||
                        DFS(board, word, row + 1, col,index+1) ||
                        DFS(board, word, row, col - 1,index+1);
                board[row][col] = c;
                return found;
            }
            return false;
        }

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j] && DFS(board, word, i, j,0)) {
                       return true ;
                    }
                }
            }
            return false;
        }
    }

    // 👉 Only the main function here
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        Solution sol = ws.new Solution();

        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };

        // String word1 = "ABCCED"; // should return true
        String word2 = "SEE"; // should return true
        String word3 = "ABCB"; // should return false

        // System.out.println("Searching for " + word1 + " → " + sol.exist(board,
        // word1));
        System.out.println("Searching for " + word2 + " → " + sol.exist(board,
        word2));
        System.out.println("Searching for " + word3 + " → " + sol.exist(board, word3));
    }
}

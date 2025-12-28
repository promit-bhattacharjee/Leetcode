package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    class Solution {
        public class Trie {
            Trie children[];
            boolean eow;

            Trie() {
                this.children = new Trie[26];
                eow = false;
            }
        }

        Trie root = new Trie();

        public void DFS(char[][] board, Trie current, int row, int col, String ans, Set<String> result) {
            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
                return;

            if (board[row][col] == '#' || current.children[board[row][col] - 'a'] == null)
                return;

            char temp = board[row][col];
            Trie newChild = current.children[temp - 'a'];
            ans += temp;

            if (newChild.eow) {
                result.add(ans);
            }

            board[row][col] = '#';

            DFS(board, newChild, row + 1, col, ans, result);
            DFS(board, newChild, row - 1, col, ans, result);
            DFS(board, newChild, row, col + 1, ans, result);
            DFS(board, newChild, row, col - 1, ans, result);

            board[row][col] = temp; // backtrack
        }

        public void insert(String word) {
            Trie current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new Trie();
                }
                current = current.children[index];
            }
            current.eow = true;
        }

        public List<String> findWords(char[][] board, String[] words) {
            for (String s : words) {
                insert(s);
            }

            Set<String> result = new HashSet<>();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    DFS(board, root, i, j, "", result);
                }
            }

            return new ArrayList<>(result);
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'o', 'a', 'b', 'n' },
                { 'o', 't', 'a', 'e' },
                { 'a', 'h', 'k', 'r' },
                { 'a', 'f', 'l', 'v' }
        };
        String[] words = { "oa", "oaa" };

        WordSearchII out = new WordSearchII();
        WordSearchII.Solution sol = out.new Solution();

        List<String> foundWords = sol.findWords(board, words);
        System.out.println("Found words: " + foundWords);
    }
}

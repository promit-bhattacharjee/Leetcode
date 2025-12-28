package LeetCode;

public class DesignAddandSearchWordsDataStructure {

    class WordDictionary {
        class Trie {
            Trie children[];
            boolean eow;

            Trie() {
                this.children = new Trie[26];
                eow = false;
            }
        }

        Trie root;

        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            Trie current = root;
            for (char c : word.toCharArray()) {
                int i = (int) c - 'a';
                if (current.children[i] == null) {
                    current.children[i] = new Trie();
                }
                current = current.children[i];
            }
            current.eow = true;
        }

        public boolean search(String word) {
            Trie current = root;
            return DFSSearch(0, word, current);

        }

        public boolean DFSSearch(int index, String word, Trie curRoot) {
            if (curRoot == null) {
                return false;
            } else if (index == word.length())
                return curRoot.eow;
            char curWord = word.charAt(index);
            if (curWord == '.') {
                for (int i = 0; i < 26; i++) {
                    if (curRoot.children[i] != null &&
                            DFSSearch(index + 1, word, curRoot.children[i])) return true;
                    
                }
            } else if (curRoot.children[curWord - 'a'] != null) {
               return DFSSearch(index + 1, word, curRoot.children[curWord - 'a']);
            }
            return false;
        }

    }
}

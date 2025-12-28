package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            Node garph = new Node();
            if (node == null) {
                return null;
            }
            boolean vis[] = new boolean[100];
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            // garph.val = node.val;
            // garph.neighbors = node.neighbors;
            while (!q.isEmpty()) {
                Node curr = q.remove();
                vis[curr.val] = true;
                for (Node e : curr.neighbors) {
                    if (!vis[e.val]) {
                        q.add(e);
                        
                    }
                }
            }
            return garph;

        }
    }
}

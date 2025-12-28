package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {

    class Solution {
        public class ListNode implements Comparable<ListNode> {
            int val;
            ListNode next;

            ListNode() {}

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }

            @Override
            public int compareTo(ListNode other) {
                return Integer.compare(this.val, other.val);
            }

            // @Override
            // public String toString() {
            //     return String.valueOf(val);
            // }
        }

        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> pq = new PriorityQueue<>();

            for (ListNode li : lists) {
                ListNode curNode = li;
                while (curNode != null) {
                    pq.add(curNode);
                    curNode = curNode.next;
                }
            }

            // Build merged list
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;

            while (!pq.isEmpty()) {
                current.next = pq.poll();
                current = current.next;
            }
            current.next = null;  // end of list

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        MergekSortedLists mg = new MergekSortedLists();
        MergekSortedLists.Solution sol = mg.new Solution();

        MergekSortedLists.Solution.ListNode l1 = sol.new ListNode(1, sol.new ListNode(4, sol.new ListNode(5)));
        MergekSortedLists.Solution.ListNode l2 = sol.new ListNode(1, sol.new ListNode(3, sol.new ListNode(4)));
        MergekSortedLists.Solution.ListNode l3 = sol.new ListNode(2, sol.new ListNode(6));

        MergekSortedLists.Solution.ListNode[] lists = { l1, l2, l3 };

        MergekSortedLists.Solution.ListNode result = sol.mergeKLists(lists);

        // Print merged list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

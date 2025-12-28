package LeetCode;

import java.util.List;

import LinkList.findNthNodeFromLast.ListNode;

public class reorderlist {

    class Solution {
        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        public ListNode findMiddle(ListNode node) {
            ListNode fast = new ListNode();
            ListNode slow = new ListNode();
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode reverse(ListNode node) {
            if (node == null || node.next == null) {
                return node;
            }
            ListNode current = node;
            ListNode prev = null;
            while (current != null) {
                ListNode next = current.next;// store
                current.next = prev;
                prev = current;
                current = next;
            }
            node.next = null;
            return prev;
        }

        public void reorderList(ListNode head) {
            ListNode middle = findMiddle(head).next;
            ListNode firstHalf = head;
            ListNode secondHalf = reverse(middle);
            while (secondHalf != null) {
                ListNode temp1 = head.next;
                ListNode temp2 = secondHalf.next;

                firstHalf.next=secondHalf;
                secondHalf.next=temp1;

                firstHalf=temp1;
                secondHalf=temp2;

            }

        }
    }
}

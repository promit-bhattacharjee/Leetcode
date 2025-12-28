package LeetCode;

public class MergeTwoSortedLists {
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

    class Solution {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            ListNode pointer = new ListNode(-1);
            ListNode result = pointer;
            while (list1 != null && list2 != null) {
                if (list1.val >= list2.val) {
                    result.next = list2;
                    list2 = list2.next;
                } else {
                    result.next = list1;
                    list1 = list1.next;
                }
                result = result.next;
            }
            if (list2 != null) {
                result.next = list2;
            } else if (list1 != null) {
                result.next = list1;
            }
            return pointer.next;

        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists out = new MergeTwoSortedLists();
        MergeTwoSortedLists.Solution sn = out.new Solution();

        // ✅ Build list1: 1 -> 2 -> 4
        ListNode list1 = out.new ListNode(1);
        list1.next = out.new ListNode(2);
        list1.next.next = out.new ListNode(4);

        // ✅ Build list2: 1 -> 3 -> 4
        ListNode list2 = out.new ListNode(1);
        list2.next = out.new ListNode(3);
        list2.next.next = out.new ListNode(4);

        // Merge
        ListNode head = sn.mergeTwoLists(list1, list2);

        // Print merged list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

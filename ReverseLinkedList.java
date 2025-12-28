package LeetCode;

public class ReverseLinkedList {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
        public ListNode reverseList(ListNode head) {
      ListNode root= head;
      if (root==null) {
        return null;
      }
      else if (root.next==null ) {
        return root;
      }
      ListNode prevNode = root;
      ListNode curNode=root.next;
      prevNode.next=null;
   
      while (curNode!=null) {
           ListNode tempNode=curNode.next;
            curNode.next=null;
            curNode.next=prevNode;
            prevNode=curNode;
            curNode=tempNode;
      }
      return prevNode;
    }
}
}

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry=0
        head=ListNode(0)
        cur=head
        while l1 or  l2 or carry:
            val=0
            if l1:
                val=l1.val
                l1=l1.next
            if l2:
                val+=l2.val
                l2=l2.next

            val=val+carry

            carry=val//10   
            val=val%10
            cur.next=ListNode(val)
            cur=cur.next
        return head.next
            
         
            

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


        
class Solution(object):
    def rearrage(self,root,k):
        cur=root
        prev=None
        while cur and k>0:

            next_node=cur.next

            cur.next=prev

            prev=cur
            cur=next_node
            k-=1
        return prev,cur

            
            
            
    def reverseKGroup(self, head, k):
        x=head
        size=0
        # count the size of the list
        while x:
            size+=1
            x=x.next

        dummy=ListNode(0)
        tail=dummy
        while size-k>=0 and head:
            current_reversed,next_group_head=self.rearrage(head,k=k)

            tail.next=current_reversed

            tail=head

            head=next_group_head
            
            size-=k
        tail.next=head
        return dummy.next
    
def main():
    data = [1, 2, 3, 4, 5]
    dummy = ListNode(0)
    current = dummy
    for value in data:
        current.next = ListNode(value)
        current = current.next
    head = dummy.next
    sn=Solution()
    res=sn.reverseKGroup(head,2)
    while res:
        print(res.val, end=" -> " if res.next else "")
        res = res.next
    print()


if __name__ == "__main__":
    main()


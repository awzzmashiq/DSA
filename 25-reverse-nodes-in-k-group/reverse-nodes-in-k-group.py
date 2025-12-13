# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy=ListNode(0,head)
        groupprev=dummy

        while True:
            kth=self.getK(groupprev,k)
            if not kth:
                break
            
            groupnext=kth.next
            prev=kth.next
            curr=groupprev.next

            while curr != groupnext:
                tmp=curr.next
                curr.next=prev
                prev=curr
                curr=tmp
            
            temp=groupprev.next
            groupprev.next=kth
            groupprev=temp
        
        return dummy.next

    def getK(self,curr:ListNode,k:int):
        while k>0 and curr:
            curr=curr.next
            k=k-1
        return curr
        
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head):
        prev = None
        curr = head
        while curr:
            next_temp = curr.next  # Temporarily store the next node
            curr.next = prev  # Reverse current node's pointer
            prev = curr  # Move pointers one step forward
            curr = next_temp
        return prev
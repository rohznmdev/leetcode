import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        
        k = len(nums) - k

        for i in range(k):
            heapq.heappop(nums)

        return heapq.heappop(nums)
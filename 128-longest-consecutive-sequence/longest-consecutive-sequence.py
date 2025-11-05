class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        f=set(nums)
        longest=0
        for num in f:
            if num-1 not in f:
                length=1
                while num+length in f:
                    length+=1
                longest=max(length,longest)
        return longest
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        sm=nums[l]

        while l<=r:
            if nums[l]<nums[r]:
                sm=min(sm,nums[l])
                break
            mid=(l+r)//2
            sm=min(nums[mid],sm)
            
            if nums[mid]<nums[l]:
                r=mid-1
            else:
                l=mid+1
        return sm
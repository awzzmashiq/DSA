class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l,r=0,len(numbers)-1

        while(l<r):
            sum=numbers[r]+numbers[l]
            if sum>target:
                r=r-1
            elif sum<target:
                l=l+1
            else:
                return [l+1,r+1]
        return []
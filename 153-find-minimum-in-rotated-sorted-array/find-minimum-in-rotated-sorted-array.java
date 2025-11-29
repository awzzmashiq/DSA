class Solution {
    public int findMin(int[] nums) {
        int min=nums[0];
        int l=0,r=nums.length-1;

        while(l<=r){
            if(nums[l]<nums[r]){
                min=Math.min(min,nums[l]);
                break;
            }

            int mid=(l+r)/2;
            min=Math.min(min,nums[mid]);
            //System.out.println(nums[mid]+","+min);

            if(nums[mid]>=nums[l]){
                l=mid+1;
                System.out.println("hi");
            }
            else{
                r=mid-1;
            }
        }
        return min;
    }
}
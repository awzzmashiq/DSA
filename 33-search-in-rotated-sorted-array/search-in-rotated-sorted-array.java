class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        //int mid=0;

        while(l<=r){
            int mid=(l+r)/2;
           // System.out.println(mid);

            if(nums[mid]==target){
                return mid;
            }

            if(nums[l]<=nums[mid]){
                if(target>nums[mid] || nums[l]>target){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            else{
               // System.out.println("mid");
                if(target<nums[mid] || nums[r]<target){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
        }
        return -1;
        
    }
}
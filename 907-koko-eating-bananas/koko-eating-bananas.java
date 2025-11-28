class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Arrays.stream(piles).max().getAsInt();
        int res=max;
        int low=1;
        int high=max;

        while(low<=high){
            int k=(low+high)/2;
           //System.out.println(k);
            int totaltime=0;
            for(int p : piles){
                totaltime+=Math.ceil((double)p/k);
                //System.out.println(totaltime+"k="+k);
            }
            //System.out.println(totaltime);
            if(totaltime<=h){
                res=k;
                high=k-1;
            }
            else{
                low=k+1;
            }
        }
        return res;
        
    }
}
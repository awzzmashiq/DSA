class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int l=0,r=1;
        int profit=0;
        while(l<r && r<prices.length){
            if(prices[l]>prices[r]){
                l=r;
                r++;
                continue;
            }
            profit=prices[r]-prices[l];
            res=Math.max(res,profit);
            r++;
        }
        return res;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {

        int maxArea=0;
        Stack<int[]> stack=new Stack<>();

        for(int i=0;i<heights.length;i++){
            int start=i;
            int h=heights[i];
            while(!stack.isEmpty() && stack.peek()[0]>h){
                int[] top=stack.pop();
                int index=top[1];
                int height=top[0];
                maxArea=Math.max(maxArea,height*(i-index));
                //System.out.println(maxArea);
                start=index;
            }
            stack.push(new int[]{h,start});
        }
        
        for(int[] pair : stack){
            int height=pair[0];
            int index=pair[1];
            maxArea=Math.max(maxArea,height*(heights.length-index));
        }
        return maxArea;
        
    }
}
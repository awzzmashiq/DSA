class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows=matrix.length;
        int cols=matrix[0].length;

        int top=0,bot=rows-1;
        int row=0;

        while(top<=bot){
            row=(top+bot)/2;
            if(target>matrix[row][cols-1]){
                top=row+1;
            }
            else if(target<matrix[row][0]){
                bot=row-1;
            }
            else{
                break;
            }
        }

        if(top>bot){
            return false;
        }

        int low=0;
        int high=matrix[0].length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(target>matrix[row][mid]){
                low=mid+1;
            }
            else if(target<matrix[row][mid]){
                high=mid-1;
            }
            else{
                return true;
            }
        }
        return false;
        
    }
}
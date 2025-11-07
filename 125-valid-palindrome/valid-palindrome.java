class Solution {
    public boolean isPalindrome(String s) {

        int i=0,j=s.length()-1;

        while(i<j){

            if(!isNumorDigit(s.charAt(i)))
            {
                i++;
                continue;
            }
            else if(!isNumorDigit(s.charAt(j)))
            {
                j--;
                continue;
            }
            else
            {
                char c1=Character.toLowerCase(s.charAt(i));
                char c2=Character.toLowerCase(s.charAt(j));
                if(c1!=c2){
                 return false;
                 }
            }

          i++;
          j--;
        }

        return true;
    }

    public boolean isNumorDigit(char c){

        if(c>='a' && c<='z' || c>='A' && c<='Z' || c>='0' && c<='9'){
            return true;
        }
        else{
            return false;
        }
    }
}
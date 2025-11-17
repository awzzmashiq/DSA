class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty())
         return"";

         HashMap<Character,Integer> countT= new HashMap<>();
         HashMap<Character,Integer> countS= new HashMap<>();

         for(char c : t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1);
         }

         int l=0,reslen=Integer.MAX_VALUE;
         int have=0,need=countT.size();

         int[] res=new int[2];

         for(int r=0;r<s.length();r++)
         {
            char c=s.charAt(r);
            countS.put(c,countS.getOrDefault(c,0)+1);

            if(countT.containsKey(c) && countS.get(c).equals(countT.get(c))){
                have++;
            }

            while(have==need){
                if((r-l+1)<reslen){
                    reslen=r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
                char leftchar=s.charAt(l);
                countS.put(leftchar,countS.get(leftchar)-1);
                if(countT.containsKey(leftchar) && countS.get(leftchar) < countT.get(leftchar)){
                    have--;
                }
                l++;
            }
         }
         return reslen==Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()){
            return false;
        }

        int[] s1cnt=new int[26];
        int[] s2cnt=new int[26];
        int matches=0;

        for(int i=0;i<s1.length();i++){
            s1cnt[s1.charAt(i)-'a']++;
            s2cnt[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if(s1cnt[i]==s2cnt[i])
             matches++;
        }
        
        int l=0;
        for(int r=s1.length();r<s2.length();r++){
            if(matches==26){
                return true;
            }
            int index=s2.charAt(r)-'a';
            s2cnt[index]++;

            if(s1cnt[index]==s2cnt[index])
             matches++;
            else if(s1cnt[index]+1==s2cnt[index])
             matches--;

            index=s2.charAt(l)-'a';
            s2cnt[index]--;

            if(s1cnt[index]==s2cnt[index])
             matches++;
            else if(s1cnt[index]-1==s2cnt[index])
             matches--;

            l++;

        }

        return matches==26;
    }
}
/**  LongestPalindromeSubsequence

    https://leetcode.com/problems/longest-palindromic-subsequence/description/

**/


class LongestPalindromeSubsequence{

    public int longestPalindromeSubseq(String s) {
     
        int[][] a = new int[s.length()+1][s.length()+1];
        int k = 1, x = a.length -2 ,j=0;
        for(int i = 1;i<=s.length();i++)
            a[i][i] = 1;
        while(x>0){
            
            for(int i = 1; i<=x; i++){
                j = i+k;
               // System.out.println(i+" " + j);
                if(s.charAt(i-1) == s.charAt(j-1)){
                    a[i][j] = a[i+1][j-1] + 2;
                }else{
                    a[i][j] = Math.max(a[i+1][j],a[i][j-1]);
                }
            }
            x--;
            k++;
            
        }
        return a[1][s.length()];
    }
}
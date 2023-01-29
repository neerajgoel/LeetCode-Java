/*
 -- In-place algorithm
 Runtime Complexity - O(n*n)
 Runtime - 244 ms
 Memory - 45.1 MB
*/
public class _5_Longest_Palindromic_Substring_01 {

    public String longestPalindrome(String s) {
        if( s.length() == 0){
            return "";
        }
        if( s.length() == 1 ){
            return s;
        }
        boolean ar[][] = new boolean[s.length()][s.length()];
        for(int i=0 ; i<s.length() ; i++){
            ar[i][i] = true;
        }
        int j = 1;
        int maxLength = 1;
        int iRes, jRes;
        iRes = 0;
        jRes = 1;
        int jInit = 1;
        for(int k=s.length()-1 ; k>=1 ; k--){
            for(int i=0 ; i<k ; i++){
                j = i + jInit;
                if( Math.abs(i-j) == 1 ){
                    ar[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    ar[i][j] = s.charAt(i) == s.charAt(j) && ar[i+1][j-1];
                }
                if( ar[i][j] && (Math.abs(i-j) + 1) > maxLength){
                    iRes = i;
                    jRes = j + 1;
                    maxLength = Math.abs(i-j) + 1;
                }
            }
            jInit++;
        }
        return s.substring(iRes, jRes);
    }

}

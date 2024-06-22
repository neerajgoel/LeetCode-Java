/*
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Beats - 100%

 Memory - 40.49 MB
 Beats - 36.04%
*/

class Solution {
    
    public int kthFactor(int n, int k) {
        int count = 0;
        for(int i=1 ; i<=n ; i++){
            if( n % i == 0 ){
                count++;
                if( count == k ){
                    return i;
                }
            }
        }
        return -1;
    }

}

/*
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 42.6 MB
*/
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int mid = mat.length/2 ;
        for(int i=0 ; i<mat.length ; i++){
            sum += mat[i][i];
            if( mat.length % 2 != 0 && i == mid ){
                continue;
            }
            sum += mat[i][mat.length - i - 1];
        }
        return sum;
    }
}

package com.questions;

public class _221_Maximal_Square_01 {

    public int maximalSquare(char[][] mat) {
        if( mat.length <= 0 )
            return -1;
        if( mat.length <= 1 ){
            for(int j=0 ; j<mat[0].length ; j++){
                if( mat[0][j] == '1' )
                    return 1;
            }
            return 0;
        }
        // Atleast 2 rows present
        int res[] = new int[mat[0].length];
        int prev = -1, tmp;
        int result = Integer.MIN_VALUE;
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                if( j == 0 || i == 0 ){
                    prev = res[j];
                    res[j] = mat[i][j] == '1' ? 1 : 0;
                }
                else{
                    tmp = res[j];
                    if( mat[i][j] == '1' ){
                        int temp = Math.min( res[j-1], res[j] );
                        temp = Math.min( temp, prev);
                        res[j] = temp + 1;
                    }
                    else{
                        res[j] = 0;
                    }
                    prev = tmp;
                }
                if( result < res[j] )
                    result = res[j];
            }
        }
        result = result * result;
        return result;
    }

    public static void main(String[] args) {

    }
}

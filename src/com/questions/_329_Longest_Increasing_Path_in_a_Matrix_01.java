import java.util.Arrays;

/*
 -- In-place algorithm
 Runtime Complexity - O(mn)
 Runtime - 24 ms
 Memory - 54.8 MB
*/

public class _329_Longest_Increasing_Path_in_a_Matrix_01 {
    private int calc(int[][] mat, int res[][], int r, int c){
        if( res[r][c] != -1 ){
            return res[r][c];
        }

        int maxResult = 1;
        int tmp;
        // check for up direction
        if( r > 0 && r < mat.length && mat[r][c] > mat[r-1][c]){
            tmp = 1 + calc(mat, res, r-1, c);
            if( maxResult < tmp ){
                maxResult = tmp;
            }
        }
        // check for down direction
        if( r >= 0 && r < mat.length - 1 && mat[r][c] > mat[r+1][c]){
            tmp = 1 + calc(mat, res, r+1, c);
            if( maxResult < tmp ){
                maxResult = tmp;
            }
        }
        // check for left direction
        if( c > 0 && c < mat[0].length && mat[r][c] > mat[r][c-1] ){
            tmp = 1 + calc(mat, res, r, c-1);
            if( maxResult < tmp ){
                maxResult = tmp;
            }
        }
        // check for right direction
        if( c >= 0 && c < mat[0].length - 1 && mat[r][c] > mat[r][c+1] ){
            tmp = 1 + calc(mat, res, r, c+1);
            if( maxResult < tmp ){
                maxResult = tmp;
            }
        }
        res[r][c] = maxResult;
        return maxResult;
    }

    public int longestIncreasingPath(int[][] mat) {
        int res[][] = new int[ mat.length ][ mat[0].length ];
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                res[i][j] = -1;
            }
        }

        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                if( res[i][j] == -1 ){
                    calc(mat, res, i, j);
                }
            }
        }

        int result = 0;
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                if( result < res[i][j] ){
                    result = res[i][j];
                }
            }
            System.out.println();
        }

        return result;
    }

}

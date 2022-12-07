/*
 Runtime Complexity - O(n)
 Runtime - 2 ms
 Memory - 73.9 MB
*/
class Solution {
    public int maxSubArray(int[] nums) {
        boolean allNeg = true;
        int result = Integer.MIN_VALUE;
        for(int i : nums){
            if( result < i ){
                result = i;
            }
            if( i >= 0 ){
                allNeg = false;
                break;
            }
        }
        if( allNeg ){
            return result;
        }
        result = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i : nums){
            tmp += i;
            if( result < tmp ){
                result = tmp;
            }
            if( tmp < 0 ){
                tmp = 0;
            }
        }
        return result;
    }
}

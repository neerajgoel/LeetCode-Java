class Solution {

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int l = 1;
        int r = 1;
        int m;
        for(int i=0 ; i<nums.length ; i++){
            l *= nums[i];
            r *= nums[nums.length - i - 1];
            m = Math.max(l, r);
            if( res < m ){
                res = m;
            }
            if( l == 0)
                l = 1;
            if( r == 0 )
                r = 1;
        }
        return res;
    }
}

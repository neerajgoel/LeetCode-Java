/*
 Runtime Complexity - O(n)
 Runtime - 1 ms
 Memory - 46.1 MB
*/

class Solution {
    public int majorityElement(int[] nums) {
        int majIndex = 0;
        int count = 1;
        for(int i=1 ; i<nums.length ; i++){
            if( nums[majIndex] == nums[i] ){
                count++;
            }
            else{
                count--;
            }
            if( count <= 0 ){
                majIndex = i;
                count = 1;
            }
        }
        return nums[majIndex];
    }
}

/*
 Runtime Complexity - O(n)
 Runtime - 32 ms
 Memory - 50.4 MB
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n;
        for(int i=0 ; i<nums.length ; i++ ){
            n = nums[i];
            if( !map.containsKey(n) ){
                map.put(n, new ArrayList<>());
            }
            map.get(n).add(i) ;
        }
        int temp;
        for(int i=0 ; i<nums.length ; i++ ){
            n = nums[i];
            temp = target - n;
            if( n == temp && map.containsKey(n) && map.get(n).size() >= 2 ){
                return new int[]{ map.get(n).get(0), map.get(n).get(1) };
            }
            else if( n != temp && map.containsKey(temp) ){
                return new int[]{ i, map.get(temp).get(0) };
            }
        }
        return new int[]{};
    }
}

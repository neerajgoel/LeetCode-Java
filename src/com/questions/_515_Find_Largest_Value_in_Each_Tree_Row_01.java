/*
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 45.49 MB
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    static void findLargestValue(TreeNode node, ArrayList<Integer> result, int level){
        if( node != null ){
            // visit
            if( result.isEmpty() || result.size() <= level){
                result.add(node.val);
            }
            else{
                int currentValue = result.get(level);
                if( currentValue < node.val ){
                    result.set(level, node.val);
                }
            }
            // left
            findLargestValue(node.left, result, level + 1);
            // right
            findLargestValue(node.right, result, level + 1);
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        findLargestValue(root, result, 0);
        return result;
    }
}

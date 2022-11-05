/*
 Runtime Complexity - O(n)
 Runtime - 1 ms
 Memory - 43.3 MB
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ){
            return result; 
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        boolean leftToRight = true;
        List<Integer> currentRow = new ArrayList<>();
        while( !que.isEmpty() ){
            TreeNode node = que.poll();
            if( node == null ){
                // last level completed
                // insert it in result
                if( !leftToRight ){
                    Collections.reverse(currentRow);
                }
                result.add( currentRow );
                currentRow = new ArrayList<>();
                leftToRight = !leftToRight;
                if( que.isEmpty() ){
                    break;
                }
                que.add(null);
                continue;
            }
            currentRow.add( node.val );
            if( node.left != null ){
                que.add( node.left );
            }
            if( node.right != null ){
                que.add( node.right );
            }
        }
        return result;
    }
}

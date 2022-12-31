/*
 Runtime Complexity - O(n)
 Runtime - 0 ms
 Memory - 40.1 MB
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

    class Pair{
        int depth;
        int parent;
        Pair(int d, int p){
            this.depth = d;
            this.parent = p;
        }
    }

    private Pair find(TreeNode root, int val, TreeNode parent, int currentDepth){
        if( root == null ){
            return null;
        }
        if( root.val == val ){
            return new Pair(currentDepth, parent == null ? -1 : parent.val );
        }
        Pair res = find(root.left, val, root, currentDepth + 1);
        if( res == null ){
            res = find(root.right, val, root, currentDepth + 1);
        }
        return res;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Pair xpair = find(root, x, null, 0);
        Pair ypair = find(root, y, null, 0);
        if( xpair == null || ypair == null )
            return false;
        return xpair.depth == ypair.depth && xpair.parent != ypair.parent;
    }
}

/*
  Complexity - O( n )
  -- can be done O(k)
 Runtime - 0 ms
 Memory - 41.8 MB
*/
public class _230_Kth_Smallest_Element_in_a_BST_01 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    class Result{
        int count = 0;
        int val;
        void set(int v, int k){
            if( count + 1 > k ){
                return;
            }
            count++;
            this.val = v;
        }
    }

    private void find(TreeNode node, int k, Result result){
        if( node == null ){
            return;
        }
        find(node.left, k, result);
        result.set(node.val, k);
        find(node.right, k, result);
    }

    public int kthSmallest(TreeNode root, int k) {
        Result result = new Result();
        find(root, k, result);
        return result.val;
    }

}

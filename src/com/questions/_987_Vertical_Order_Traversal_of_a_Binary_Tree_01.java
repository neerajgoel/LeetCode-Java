import java.util.*;

/*
    14/32 test cases passed

    Test case failed
    root = [3,1,4,0,2,2]
    My O/P = [[0],[1],[2,2,3],[4]]
    Expected = [[0],[1],[3,2,2],[4]]

    According to question, values at same column should be sorted. So, I don't understand why this is the expected output.
 */
public class _987_Vertical_Order_Traversal_of_a_Binary_Tree_01 {

    
      private static class TreeNode {
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


    private void traverse(TreeNode node, int col, SortedMap<Integer, List<Integer>> map){
        if( node != null ){
            traverse(node.left, col - 1, map);
            if( !map.containsKey(col) ){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            traverse(node.right, col + 1, map);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        SortedMap<Integer, List<Integer>> map = new TreeMap<>();
        traverse(root, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for( int key : map.keySet() ){
            List<Integer> intrlList = new ArrayList<>();
            for(int val : map.get(key)){
                intrlList.add(val);
            }
            Collections.sort(intrlList);
            result.add(intrlList);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("jk");
    }
}

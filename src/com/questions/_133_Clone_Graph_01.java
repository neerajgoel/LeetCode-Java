import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 Runtime Complexity - O(n)
 Runtime - 27 ms
 Memory - 43.2 MB
*/
public class _133_Clone_Graph_01 {

// Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    class Solution {

        private Node process(Node node, HashMap<Integer, Node> map){
            if( node == null ){
                return null;
            }
            Node newNode = new Node(node.val);
            map.put(node.val, newNode);
            for(Node childNode : node.neighbors){
                if( map.containsKey( childNode.val ) ){
                    newNode.neighbors.add( map.get(childNode.val) );
                }
                else{
                    Node childClone = process( childNode, map );
                    newNode.neighbors.add( childClone );
                }
            }
            return newNode;
        }

        public Node cloneGraph(Node node) {
            return process(node, new HashMap<>());
        }
    }
}

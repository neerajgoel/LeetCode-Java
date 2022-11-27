/*
 Runtime Complexity - get - O(1)
                      put - O(1)
 Runtime - 97 ms
 Memory - 129.6 MB
*/

class LRUCache {

    HashMap<Integer, LLNode> map;
    LL list;
    int size;

    class LLNode{
        int data;
        int key;
        LLNode prev, next;
        LLNode(){
            prev = next = null;
        }
        LLNode(int key, int data){
            this();
            this.key = key;
            this.data = data;
        }
        void reset(){
            prev = next = null;
        }
    }

    class LL{
        LLNode head;
        LLNode tail;
        LL(){
            head = tail = null;
        }
        void insertAtHead(LLNode node){
            if( head == null ){
                head = tail = node;
            }
            else{
                node.next = head;
                head.prev = node;
                head = node;
            }
        }
        void remove(LLNode node){
            if( node == head ){
                if( head == tail ){
                    // only 1 node
                    head = tail = null;
                    return;
                }
                // more than 1 node
                head = head.next;
                head.prev = null;
            }
            else if( node == tail){
                // more than 1 node
                tail = tail.prev;
                tail.next = null;
            }
            else{
                // more than 2 nodes and node is between head & tail
                LLNode _prev = node.prev;
                LLNode _next = node.next;
                _prev.next = _next;
                _next.prev = _prev;
            }
        }
        LLNode removeTail(){
            if( head == null ){
                return null;
            }
            LLNode temp;
            if( head == tail ){
                temp = head;
                head = tail = null;
            }
            else{
                temp = tail;
                tail = tail.prev;
                tail.next = null;
            }
            return temp;
        }
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new LL();
        size = capacity;
    }
    
    public int get(int key) {
        if( !map.containsKey(key) ){
            return -1;
        }
        // find ref in map, remove from list and insert it in head
        LLNode node = map.get(key);
        list.remove(node);
        node.reset();
        list.insertAtHead(node);
        return node.data;
    }
    
    public void put(int key, int value) {
        if( map.size() >= size && !map.containsKey(key) ){
            // remove LRU
            LLNode node = list.removeTail();
            // remove from map
            map.remove(node.key);
        }
        if( map.containsKey(key) ){
            LLNode node = map.get(key);
            node.data = value;
            get(key);
        }
        else{
            LLNode node = new LLNode(key, value);
            list.insertAtHead(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

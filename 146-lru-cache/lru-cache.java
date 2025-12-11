class LRUCache {
    public class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }

    HashMap<Integer,Node> map;
    int cap;
    Node right;
    Node left;

    public LRUCache(int capacity) {
        this.cap=capacity;
        this.map=new HashMap<>();
        this.right=new Node(0,0);
        this.left=new Node(0,0);
        this.right.prev=this.left;
        this.left.next=this.right;
        
    }

    public void remove(Node node){
        if(node==null)
        return;
        Node prev = node.prev;
        Node nxt = node.next;
        if(prev!=null)
        prev.next = nxt;
        if(nxt!=null)
        nxt.prev = prev;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.next=this.right;
        node.prev=prev;
        this.right.prev=node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;

        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
        }

        Node node=new Node(key,value);
        map.put(key,node);
        insert(node);

        if(map.size()>cap){
            Node lru=this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
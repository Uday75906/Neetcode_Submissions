class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer,Node> map;
    int count;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
       map = new HashMap<>(); 
       count = 0;
       this.capacity = capacity;
       tail = new Node(0,0);
       head = new Node(0,0);
       head.next = tail;
       tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insertAtFront(node);

        return node.value;
    }
    
    public void put(int key, int value) {
       
        if(map.containsKey(key)){
            remove(map.get(key));
            
        }
        else if(map.size()==capacity){
            remove(tail.prev);
        }

        insertAtFront(new Node(key,value));
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtFront(Node node){
        map.put(node.key,node);
        Node temp = head.next;
        node.next = temp;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }
}

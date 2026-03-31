class LFUCache {
    class Node{
        int key, value, freq = 1;
        Node prev, next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    class DoublyLinkedList{
        int size = 0;
        Node head, tail;
        DoublyLinkedList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addHead(Node node){
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            temp.prev = node;
            head.next = node;
            size++;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        public Node removeTail(){
            if(size==0) return null;
            Node res = tail.prev;
            remove(res);
            cache.remove(res.key);
            return res;
        }
    }

    private int capacity, minfreq;
    Map<Integer, Node> cache;
    Map<Integer, DoublyLinkedList> freqmap;

    public LFUCache(int capacity) {
       this.capacity = capacity;
       minfreq = 0;
       cache = new HashMap<>();
       freqmap = new HashMap<>();
    }
    
    public int get(int key) {
      if(!cache.containsKey(key)) return -1;
      Node node = cache.get(key);
      updateNode(node);

      return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            updateNode(node);
        }
        else{
            if(cache.size()==capacity){
                DoublyLinkedList minList = freqmap.get(minfreq);
                Node n = minList.removeTail();
                cache.remove(n.key);
            }
        }
        Node newnode = new Node(key,value);
        minfreq = 1;
        cache.put(key,newnode);
        freqmap.computeIfAbsent(1, k -> new DoublyLinkedList()).addHead(newnode);
    }
    public void updateNode(Node node){
        int oldfreq = node.freq;
        DoublyLinkedList oldList = freqmap.get(oldfreq);
        oldList.remove(node);
        
        if(minfreq==oldfreq && oldList.size==0){
            minfreq++;
        }
        
        node.freq++;
        freqmap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addHead(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
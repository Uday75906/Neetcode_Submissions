class PrefixTree {
    private trieNode root;
    class trieNode{
        trieNode[] arr;
        boolean isEnd;
        trieNode(){
            arr = new trieNode[26];
            isEnd = false;
        }
    }

    public PrefixTree() {
         root = new trieNode();
    }

    public void insert(String word) {
        trieNode curr = root;
        for(char i: word.toCharArray()){
            int index = i-'a';
            if(curr.arr[index]==null){
                curr.arr[index] = new trieNode();
            }
            curr = curr.arr[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
       trieNode curr = root;
       for(char c: word.toCharArray()){
        int index = c-'a';
        if(curr.arr[index]==null) return false;
        curr = curr.arr[index];
       }
       return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
       trieNode curr = root;
       for(char c: prefix.toCharArray()){
        int index = c-'a';
        if(curr.arr[index]==null) return false;
        curr = curr.arr[index];
       }
       return true;
    }
}

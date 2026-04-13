class WordDictionary {
    private trieNode root;
    class trieNode{
        trieNode[] arr;
        boolean isEnd;
        trieNode(){
            this.arr = new trieNode[26];
            this.isEnd = false;
        }
    }

    public WordDictionary() {
        root = new trieNode();
    }

    public void addWord(String word) {
       trieNode curr = root;
       for(char c:word.toCharArray()){
        int  index = c-'a';
        if(curr.arr[index]==null){
            curr.arr[index] = new trieNode();
        }
        curr = curr.arr[index];
       }
       curr.isEnd = true;
    }

    public boolean search(String word) {
       return helper(word, 0, root);
    }
    public boolean helper(String word, int index, trieNode curr){
        if(index==word.length()) return curr.isEnd;

        char c = word.charAt(index);
        if(c=='.'){
            for(trieNode child: curr.arr){
                if(child!=null && helper(word, index+1, child)){
                    return true;
                }
            }
            return false;
        }
        else{
            int idx = c-'a';
            trieNode child = curr.arr[idx];
            if(child==null) return false;
            return helper(word, index+1, child);
        }
    }
}

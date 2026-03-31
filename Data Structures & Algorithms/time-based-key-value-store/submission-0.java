class TimeMap {
    Map<String, List<Data>> map;
   class Data{
    int time;
    String value;
    Data(int time, String value){
        this.time = time;
        this.value = value;
    }
   }
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Data> list = map.get(key);
        int left = 0;
        int right = list.size()-1;
        String res = "";
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid).time<=timestamp){
                res = list.get(mid).value;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
   return res;
    }
}

class Twitter {
    Map<Integer, List<Integer>> follow;
    Map<Integer, List<int[]>> posts;
    int timestamp;
    public Twitter() {
      follow = new HashMap<>();
      posts = new HashMap<>();
      timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        follow.putIfAbsent(userId, new ArrayList<>());
        posts.putIfAbsent(userId, new ArrayList<>());
        if(!follow.get(userId).contains(userId)){
            follow.get(userId).add(userId);
        }
        posts.get(userId).add(new int[]{timestamp++, tweetId});
        }
    
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> alltweet = new ArrayList<>();
        List<Integer> foll = follow.get(userId);
        if(foll==null) return new ArrayList<>();
        for(int i=0; i<foll.size(); i++){
            int followeeId = foll.get(i);
            List<int[]> post = posts.get(followeeId);
            if(post!=null){
                alltweet.addAll(post);
            }
        }

        Collections.sort(alltweet, (a,b) -> b[0]-a[0]);

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<alltweet.size(); i++){
            res.add(alltweet.get(i)[1]);
            if(res.size()==10) break;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follow.putIfAbsent(followerId, new ArrayList<>());
        if(!follow.get(followerId).contains(followeeId)){
            follow.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId || !follow.containsKey(followerId)) return;
        if(follow.get(followerId).contains(followeeId)){
            follow.get(followerId).remove((Integer)followeeId);
        }
    }
  
}

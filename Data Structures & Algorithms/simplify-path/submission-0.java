class Solution {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> res = new Stack<>();
        
        for (String r : s) {
            if (r.equals("") || r.equals(".")) {
                continue;
            }
            if (r.equals("..")) {
                if (!res.isEmpty()) {
                    res.pop();
                }
            } else {
                res.push(r);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String folder : res) {
            result.append("/").append(folder);
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }
}
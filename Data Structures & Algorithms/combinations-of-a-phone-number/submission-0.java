class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {
    "",     // 0
    "",     // 1
    "abc",  // 2
    "def",  // 3
    "ghi",  // 4
    "jkl",  // 5
    "mno",  // 6
    "pqrs", // 7
    "tuv",  // 8
    "wxyz"  // 9
};
      List<String> res= new ArrayList<>();
      if(digits.length()==0) return res;
      
      backtrack(res,"", digits, map, 0);
      return res;

    }

    public void backtrack(List<String> res, String current, String digits, String[] map, int index){
        if(current.length()==digits.length()){
            res.add(current);
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(index));
        for(int i=0; i<map[digit].length(); i++){
            String s = map[digit];
            current = current+s.charAt(i);

            backtrack(res, current, digits, map, index+1);

            current = current.substring(0,current.length()-1);
        }
    }
}

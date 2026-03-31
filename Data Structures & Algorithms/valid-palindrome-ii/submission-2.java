class Solution {
    public boolean validPalindrome(String s) {
       int i = 0;
       int j = s.length()-1;
       int count = 1;
       while(i<j){
        char left = s.charAt(i);
        char right = s.charAt(j);
            if(!Character.isLetterOrDigit(left)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(right)){
                j--; 
                continue;
            }
            if(Character.toLowerCase(left)!=Character.toLowerCase(right)){
                return ispalindrome(s,i+1,j) || ispalindrome(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
       } 
       public boolean ispalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
       }
    }
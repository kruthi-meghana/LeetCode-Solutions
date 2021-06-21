/*
Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, 

so that the concatenation of the two words words[i] + words[j] is a palindrome.


Examples:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]

Input: words = ["a",""]
Output: [[0,1],[1,0]]

@author: Kruthi Meghana Anumandla
*/


class Solution {
    
    private boolean isRestStrPalindrome(String s) {
        for (int i = 0; i < s.length()/2; ++ i)
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new LinkedList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++)map.put(words[i], i);
        
        for(int i = 0; i< words.length; i++) {
            int pointer1 = 0, pointer2 = 0;
            while(pointer1 <= pointer2) {
                
                String subStr = words[i].substring(pointer1,pointer2);
                String otherSubStr = words[i].substring(pointer1==0?pointer2:0, pointer1==0?words[i].length():pointer1);
                Integer ind = map.get(new StringBuilder(subStr).reverse().toString());
                
                if(ind != null && ind != i && isRestStrPalindrome(otherSubStr))
                    result.add(Arrays.asList(pointer1==0? new Integer[]{i, ind}: new Integer[]{ind, i}));
                
                if(pointer2 < words[i].length()) ++pointer2;
                else ++pointer1;
            }
        }
        return result;
    }
}

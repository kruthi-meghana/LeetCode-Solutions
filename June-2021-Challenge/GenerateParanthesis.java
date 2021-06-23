/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Examples:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Input: n = 1
Output: ["()"]

@author: Kruthi Meghana Anumandla
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        generateCombinations(result, "", 0, 0, n);
        
        return result;
    }
    
    public void generateCombinations(List<String> result, String str, int open, int close, int max) {
        if(str.length() == max*2) {
            result.add(str);
            return;
        }
        
        if(open < max)
            generateCombinations(result, str+'(', open+1, close, max);
        if(close < open)
            generateCombinations(result, str+')', open, close+1, max);
    }
}

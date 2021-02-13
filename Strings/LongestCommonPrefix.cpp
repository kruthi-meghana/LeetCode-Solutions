/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

@Author: Kruthi Meghana
*/

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int numOfWords = strs.size();
        
        if(numOfWords == 0)
            return "";
        string prefix = "";
        for(int i = 0; i < strs[0].size(); i++) {
            int j = 1;
            for(; j < numOfWords; j++) {
                if(strs[0][i] != strs[j][i])
                    return prefix;
                if(strs[j][i] == '\0')
                    return strs[j];
            }
            if(j == numOfWords)
                prefix += strs[0][i];            
        }
        
        return prefix;  
    }
};

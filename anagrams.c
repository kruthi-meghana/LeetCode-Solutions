/**
 *Question: Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 *Example 1:
 *
 *Input: s = "anagram", t = "nagaram"
 *Output: true
 *
 * @author: Kruthi Meghana
 */


bool isAnagram(char * s, char * t){
    
    int alpha[26] = {0};
    int index = 0;
    
    while(s[index] != '\0' || t[index] != '\0') {
        if((s[index] == '\0' && t[index] != '\0') || (s[index] != '\0' && t[index] == '\0'))
            return false;
        alpha[s[index] - 97]++;
        alpha[t[index] - 97]--;
        index++;
    }
    for(int i = 0; i < 26; i++) {
        if(alpha[i] != 0)
            return false;
    }
    return true;
}

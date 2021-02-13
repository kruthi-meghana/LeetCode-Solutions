/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
*/

int firstUniqChar(char * s){
    int dummy[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int index = 0;
    
    while(s[index] != '\0') {
        dummy[s[index++]-97]++; 
    }
    index = 0;
    while(s[index] != '\0') {
        if(dummy[s[index]-97] == 1)
            return index;
        index++;
    }
    return -1;
}

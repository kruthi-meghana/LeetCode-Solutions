/**
 *Question: Return the index of the first occurrence of needle in haystack, or -1 if needle is not  *part of haystack.
 *
 *
 *Example 1:
 *
 *Input: haystack = "hello", needle = "ll"
 *Output: 2
 *
 * @author: Kruthi Meghana
 */


int strStr(char * haystack, char * needle){
    
    if(needle[0] == '\0')
        return 0;
    
    int index = 0, index1 = 0, stock = -1;
    
    while(haystack[index] != '\0' && needle[index1] != '\0') {
        if(haystack[index] == needle[index1]){
            stock = stock == -1?  index: stock;
            index1++;
        } else{
            index1 = 0;
            index = stock == -1?  index: stock;
            stock = -1;
        }
        index++;
        if(needle[index1] == '\0')
            return stock;
    }
    return -1;
}
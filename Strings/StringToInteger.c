/**
 *Question: Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).4
 
The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.

Note: Remember C does implicit casting.
 *
 * @author: Kruthi Meghana
 */
int myAtoi(char * s){
    int index = 0;
    long long num = 0;
    int sign = 0;
    bool isNeg = false;
    
    while(s[index] != '\0' && s[index] == ' ') {
        index++;
    }
    while(s[index] != '\0') {
        if(s[index] == '-')
            isNeg = true;
        if(s[index] == '-' || s[index] == '+')
            sign += 1;
        else
            break;
        index++;
    }
    while (s[index] != '\0' && sign < 2) {
        
        int digit = s[index] - '0';
        
        if(digit < 10 && digit >= 0) {
            if (num > 214748364 || (num == 214748364 && digit >= 8)) {
                num = isNeg? 2147483648 : 2147483647;
                break;
            }
            num = num*10 + digit;
        } else {
            break;
        }
        index++;
    }
    
    if(isNeg)
        num = num*-1;
    return num;
}

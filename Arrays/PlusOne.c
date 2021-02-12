/**
 * Question: Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 *The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 *You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 *
 *Example 1:
 *
 *Input: digits = [1,2,3]
 *Output: [1,2,4]
 *Explanation: The array represents the integer 123.
 *
 *@ author: Kruthi Meghana
*/

int* plusOne(int* digits, int digitsSize, int* returnSize){
    
    int reminder = 1;
    
    for (int i = digitsSize-1; i >= 0; i--) {
        
        if (reminder == 1) {
            if(digits[i] + 1 > 9) {
               digits[i] = (digits[i] + 1) % 10;
                reminder = 1;
            } else {
                digits[i] = digits[i] + reminder;
                reminder = 0;
            }
        } else {
            break;
        }
    }
    if(reminder) {
        *returnSize = digitsSize+1;
        int* returnArray = (int*)malloc(sizeof(int)*(*returnSize));
        returnArray[0] = 1;
        for(int i = 0; i < digitsSize; i++) {
            returnArray[i+1] = digits[i];
        }
        return returnArray;
        
    } else {
        *returnSize = digitsSize;
        return digits;
    }
}

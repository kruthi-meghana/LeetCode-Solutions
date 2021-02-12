/**
 *Question: Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 *Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 *
 *
 *
 *Example 1:
 *
 *Input: nums = [2,2,1]
 *Output: 1
 */


int singleNumber(int* nums, int numsSize){
    
    int result = nums[0];
    
    for(int i = 1; i < numsSize; i++) {
        result = result ^ nums[i];
    }
    
    return result;
} 

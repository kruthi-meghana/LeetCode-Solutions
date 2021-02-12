/**
 * Question: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 *Example:
 *
 *Input: [0,1,0,3,12]
 *Output: [1,3,12,0,0]
 */
 
 void moveZeroes(int* nums, int numsSize){
    
    int i = 0, j;
    
    for (;i < numsSize; i++) {
        if(nums[i] == 0)
            break;
    }
    j = (i+1);
    
    for(;i < numsSize && j < numsSize;){
        if(nums[i] == 0) {
            if(nums[j] != 0){
                nums[i++] = nums[j];
                nums[j++] = 0;
            } else {
                j++;
            }
        } else {
            i++;
        }
    }

}

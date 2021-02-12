/**
 *Question: Given a sorted array nums, remove the duplicates in-place such that each element appears  *only once and returns the new length.
 *
 *Do not allocate extra space for another array, you must do this by modifying the input array in- *place with O(1) extra memory.
 *
 *Clarification:
 *
 *Confused why the returned value is an integer but your answer is an array?
 *
 *Note that the input array is passed in by reference, which means a modification to the input array  *will be known to the caller as well.
 *
 * @author: Kruthi Meghana
 */




int removeDuplicates(int* nums, int numsSize){
    int swapPtr = -1;
    int count = 0;
    
    for (int i = 0; i < numsSize - 1; i++) {
        if (swapPtr < 0) {
            if(nums[i] == nums[i+1]) {
                swapPtr = i;
            } 
            count += 1;
        } else if(nums[swapPtr] != nums[i]) {
            nums[++swapPtr] = nums[i];
            count += 1;
        } 
    } 
    if(swapPtr >= 0) {
        if(nums[swapPtr] != nums[numsSize-1] && nums[swapPtr+1] != nums[numsSize-1]) {
            nums[++swapPtr] = nums[numsSize - 1];
            count += 1;
        }
        return count;
    }
    return numsSize;
}
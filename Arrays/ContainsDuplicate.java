/**
 * Question: Given an array of integers, find if the array contains any duplicates.
 *
 *Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 *Example 1:
 *
 *Input: [1,2,3,1]
 *Output: true
 *
 *@ author: Kruthi Meghana
*/

import java.io.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> input = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!input.add(nums[i])) 
                return true;
        }
        return false;
        
    }
}

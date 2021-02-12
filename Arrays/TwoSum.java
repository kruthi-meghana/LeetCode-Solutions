/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

 @Author: Kruthi Meghana
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            System.out.println("num "+hashMap.get(num));
            if(hashMap.containsKey(num)) {
                return new int[] {hashMap.get(num), i};
            }
            hashMap.put(nums[i], i);            
        }
        return new int[] {0};
    }
}

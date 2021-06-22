/*
You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. 

You want to use all the matchsticks to make one square. You should not break any stick, 

but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

Examples:

Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.

@author: Kruthi Meghana Anumandla
*/

class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int side = 0, count = 0;
        for(int i : matchsticks) side = side + i;
        
        if(side % 4 != 0 || matchsticks.length < 4)
            return false;
        side = side/4;
        Arrays.sort(matchsticks);
        int j = 0;
        
        return sideCalculate(matchsticks, side, 0, 0, 0, 0, matchsticks.length-1);
    }
    
    public boolean sideCalculate(int[] matchsticks, int side, int sum1, int sum2, int sum3, int sum4, int index) {
        if(Math.max(sum1, Math.max(sum2, Math.max(sum3, sum4))) > side) return false;
        if(index == -1) {
            
            if(sum1 == side && sum2 == side && sum3 == side && sum4 == side) return true;
            return false;
        }
       
        return sideCalculate(matchsticks, side, sum1, sum2, sum3, sum4+matchsticks[index], index-1) || sideCalculate(matchsticks, side, sum1+matchsticks[index], sum2, sum3, sum4, index-1) || sideCalculate(matchsticks, side, sum1, sum2+matchsticks[index], sum3, sum4, index-1) ||sideCalculate(matchsticks, side, sum1, sum2, sum3+matchsticks[index], sum4, index-1);
    }
}

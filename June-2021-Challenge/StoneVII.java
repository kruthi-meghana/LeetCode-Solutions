/*
Alice and Bob take turns playing a game, with Alice starting first.

There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or 

the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row. 

The winner is the one with the higher score when there are no stones left to remove.

Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. 

Alice's goal is to maximize the difference in the score.

Given an array of integers stones where stones[i] represents the value of the ith stone from the left, 

return the difference in Alice and Bob's score if they both play optimally.

Examples:

Input: stones = [5,3,1,4,2]
Output: 6
Explanation: 
- Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].
- Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].
- Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].
- Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
- Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
The score difference is 18 - 12 = 6.

Input: stones = [7,90,5,1,100,10,10,2]
Output: 122

@author: Kruthi Meghana Anumandla
*/

class Solution {
    public int stoneGameVII(int[] S) {
        int N = S.length;
        int[] dp = new int[N];
        for (int i = N - 2; i >= 0; i--) {
            int total = S[i];
            for (int j = i + 1; j < N; j++) {
                total += S[j];
                dp[j] = Math.max(total - S[i] - dp[j], total - S[j] - dp[j-1]);
                //System.out.println("index:"+j+", dp-value:"+dp[j]);
            }
            
        }
        return dp[N-1];
    }
}

/*
Given the root of a binary tree, return the maximum average value of a subtree of that tree. Answers within 10-5 of the actual answer will be accepted.

A subtree of a tree is any node of that tree plus all its descendants.

The average value of a tree is the sum of its values, divided by the number of nodes.
Examples:

Input: root = [5,6,1]
Output: 6.00000
Explanation: 
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.

Input: root = [0,null,1]
Output: 1.00000
@author: Kruthi Meghana Anumandla
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    double mx_average = Integer.MIN_VALUE;
    class State {
        int sum;
        int nodeCount;
        
        public State(int sum, int nodeCount) {
            this.sum = sum;
            this.nodeCount = nodeCount;
        }
    }
    public double maximumAverageSubtree(TreeNode root) {
        traverseThroughBT(root);
        return mx_average;
    }
    public State traverseThroughBT(TreeNode root) {
        if(root == null) return new State(0,0);
       
        
        State leftSub = traverseThroughBT(root.left);
        State rightSub = traverseThroughBT(root.right);
    
        int nodeCount = leftSub.nodeCount + rightSub.nodeCount + 1;
        int sum = root.val + leftSub.sum + rightSub.sum;
        
        double avg = ((double)sum) /(nodeCount);
        
        mx_average = mx_average < avg? avg : mx_average;
        return new State(sum, nodeCount);
    }
}

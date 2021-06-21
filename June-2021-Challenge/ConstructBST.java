
/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and 
inorder is the inorder traversal of the same tree, construct and return the binary tree.Example:

Examples:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Input: preorder = [-1], inorder = [-1]
Output: [-1]


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
    int preorderIndex;
    Map<Integer, Integer> inorderHashmap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex=0;
        inorderHashmap = new HashMap<>();
        for(int i=0; i<inorder.length;i++) {
            inorderHashmap.put(inorder[i], i);
        }
        
        return treeConstruct(preorder, 0, preorder.length-1);
    }
    
    public TreeNode treeConstruct(int[] preorder,int leftInd, int rightInd) {
        if(leftInd > rightInd) return null;
        int nextRootValue = preorder[preorderIndex++];
        TreeNode nextRoot = new TreeNode(nextRootValue);
        
        nextRoot.left = treeConstruct(preorder, leftInd, inorderHashmap.get(nextRootValue)-1);
        nextRoot.right = treeConstruct(preorder, inorderHashmap.get(nextRootValue)+1, rightInd);
        
        return nextRoot;
    }
}

/**
 *Question: Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that  *every key of the original BST is changed to the original key plus sum of all keys greater than the  *original key in BST.
 *
 *As a reminder, a binary search tree is a tree that satisfies these constraints:

 *The left subtree of a node contains only nodes with keys less than the node's key.
 *The right subtree of a node contains only nodes with keys greater than the node's key.
 *Both the left and right subtrees must also be binary search trees.
 *
 * @author: Kruthi Meghana
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

struct TreeNode* convert(struct TreeNode* node, int* sum) {
    
    if(node != NULL) {
        node -> right = convert(node -> right, sum);
        *sum += node -> val;
        node -> val = *sum;
        node -> left = convert(node -> left, sum);
    }   
    return node;
}


struct TreeNode* convertBST(struct TreeNode* root){
    int sum = 0;
    
    return convert(root, &sum);  
}
/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
package tree;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode root){
        if(root == null)
            return -1;
        else if(root.left == null && root.right == null)
            return 0;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

//Definition for binary tree
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

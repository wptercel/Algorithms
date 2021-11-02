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
/**
思路：BST中比节点值大的书都在右边（右子树+父节点的右子树+...）。可以通过类似中序遍历的方法，从右子树遍历到左子树，同时用一个共享变量记录节点值累加的值，再用此值来更新所有节点。
空间复杂度：O(n)。n是节点数
时间复杂度：遍历每个节点。O(n)
*/
class Solution {
    private int currentAddUp = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        convertBST(root.right);
        this.currentAddUp += root.val;
        root.val = currentAddUp;
        convertBST(root.left);
        return root;
    }
}

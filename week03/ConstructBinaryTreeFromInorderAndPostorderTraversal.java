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
    思路：构建树需要找到root和左右子树。用postorder可以得到root，再在inorder中找到root的位置就能得到左右子树。
    空间复杂度：O(1)
    时间复杂度：设左子树的平均长度为k，数组长度为n。平均O(nk)，只有左子树时最坏O(n^2)
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildTree(int[] inorder, int inFrom, int inTo, int[]postorder, int postFrom, int postTo) {
        if(inFrom == inTo) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postTo - 1]);
        int rootIndex = indexOfRoot(inorder, inFrom, inTo, postorder[postTo - 1]);
        int leftLength = rootIndex - inFrom;
        int rightLength = inTo - rootIndex - 1;
        root.left = buildTree(inorder, inFrom, rootIndex, postorder, postFrom, postFrom + leftLength);
        root.right = buildTree(inorder, rootIndex + 1, inTo, postorder, postTo - rightLength - 1, postTo - 1);
        return root;
    }

    private int indexOfRoot(int[] inorder, int from, int to, int rootVal) {
        for(int i = from; i < to; i++) {
            if(inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }
}

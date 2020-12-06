/**
剑指 Offer 55 - II. 平衡二叉树
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

 

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。

 

限制：

1 <= 树的结点个数 <= 10000
注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int num = maxDepth(root.left) - maxDepth(root.right);
        int x = Math.abs(num);
        if(x <= 1){
            if(root.left != null && root.right != null){
                return isBalanced(root.left) && isBalanced(root.right);
            }else if(root.left == null){
                return isBalanced(root.right);
            }else if(root.right == null){
                return isBalanced(root.left);
            }else return true;
        }
        return false;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null){
            return maxDepth(root.right) + 1;
        }else if(root.right == null){
            return maxDepth(root.left) + 1;
        }else{
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }
    }
}
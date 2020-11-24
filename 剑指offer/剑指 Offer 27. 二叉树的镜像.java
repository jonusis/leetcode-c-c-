/**
剑指 Offer 27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 

示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
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
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode res = new TreeNode();
        beNode(res,root);
        return res;
    }
    int beNode(TreeNode res,TreeNode root){
        if(root == null) return 0;
        res.val = root.val;
        if(root.left != null){
            TreeNode right = new TreeNode();
            res.right = right;
            beNode(res.right,root.left);
        }
        if(root.right != null){
            TreeNode left = new TreeNode();
            res.left = left;
            beNode(res.left,root.right);
        }
        return 1;
    }
}
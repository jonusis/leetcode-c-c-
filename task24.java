/**
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7

返回它的最大深度 3 。

同上 递归解决 
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
    public int maxDepth(TreeNode root) {
        TreeNode P = root;
        if(root == null) return 0;
        return dep(root);
    }
    int dep(TreeNode p){
        if(p.left != null && p.right != null){
            return Math.max(dep(p.left),dep(p.right)) + 1;
        }else if(p.left == null && p.right != null){
            return dep(p.right) + 1;
        }else if(p.left != null && p.right == null){
            return dep(p.left) + 1;
        }else return 1;
    }
}
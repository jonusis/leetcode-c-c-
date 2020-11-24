/**
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

 

示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true


示例 2：

输入：root = [1,2,2,null,3,null,3]
输出：false

 

限制：

0 <= 节点个数 <= 1000

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode p = root.left;
        TreeNode q = root.right;
        return inValue(p,q);
    }
    boolean inValue(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }
        if(p.val != q.val) return false;
        return inValue(p.left,q.right) && inValue(p.right,q.left);
    }
}
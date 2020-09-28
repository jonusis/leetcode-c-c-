/**
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：


一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。


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

个人解法 ：先进行层次遍历，每次求解其左右子树的高度差，如果每次都小于等于1，返回true
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
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode p = q.poll();
            int a = dep(p.left);
            int b = dep(p.right);
            if(p.left != null) q.offer(p.left);
            if(p.right != null) q.offer(p.right);
            if(Math.abs(a - b) <= 1) continue;
            else return false;
        }
        return true;
    }
    int dep(TreeNode root){
        if(root == null) return 0;
        if(root.left != null && root.right != null) return Math.max(dep(root.left),dep(root.right)) + 1;
        else if(root.left == null && root.right == null) return 1;
        else if(root.left == null) return dep(root.right) + 1; 
        else if(root.right == null) return dep(root.left) + 1; 
        return 1;
    }
}

// 超厉害解法 ：从低往上递归 巧妙利用递归本质

class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if(root == null)
            return 0;
        int lh = height(root.left), rh = height(root.right);
        if(lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }
}
/**
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7


返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

很简单 通过队列进行层次遍历
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.offer(root);
        while(!qu.isEmpty()){
            List<Integer> r1 = new LinkedList<Integer>();
            int len = qu.size();
            for(int i = 0;i < len;i++){
                TreeNode j = qu.poll();
                r1.add(j.val);
                TreeNode left = j.left;
                TreeNode right = j.right;
                if(left != null) qu.offer(left);
                if(right != null) qu.offer(right);
            }
            res.add(0,r1);
        }
        return res;
    }
}
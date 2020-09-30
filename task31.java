/**
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1


返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2

广度优先搜索 
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        q1.offer(root);
        q2.offer(root.val);
        while(!q1.isEmpty()){
            for(int i = 0;i < q1.size();i++){
                TreeNode p = q1.poll();
                int x = q2.poll();
                if(sum == x && p.left == null && p.right == null) return true;
                if(p.left != null){
                    q1.offer(p.left);
                    q2.offer(p.left.val + x);
                }
                if(p.right != null){
                    q1.offer(p.right);
                    q2.offer(p.right.val + x);
                }
            }
        }
        return false;
    }
}

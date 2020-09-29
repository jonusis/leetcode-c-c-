/**
 * 给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.

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
import java.util.*;
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int n = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                TreeNode s = q.poll();
                if(s.left != null) q.offer(s.left);
                if(s.right != null) q.offer(s.right);
                if(s.left == null && s.right == null) return n;
            }
            n++;
        }
        return n;
    }
}
/**
 * 
剑指 Offer 32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]
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
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return new int[0];
        int res[] = new int[100001];
        int i = 0;
        q.offer(root);
        while(q.size() > 0){
            TreeNode node = q.poll();
            res[i] = node.val;
            if(node.left != null)   q.offer(node.left);
            if(node.right != null)  q.offer(node.right);
            i++;
        }
        int result[] = new int[i];
        for(int num = 0;num < i;num++){
            result[num] = res[num];
        }
        return result;

    }
}
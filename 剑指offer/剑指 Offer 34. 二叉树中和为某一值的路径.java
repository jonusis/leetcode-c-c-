/**
剑指 Offer 34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

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
    List<List<Integer>> arr = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return arr;
        dfs(root,sum,new ArrayList<Integer>());
        return arr;
    }
    void dfs(TreeNode root,int sum,List<Integer> temp){
        temp.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null){
            if(sum == 0){
                arr.add(new ArrayList(temp));
                temp.remove(temp.size() - 1);
            }else{
                temp.remove(temp.size() - 1);
            }
            return;
        }
        if(root.left != null) dfs(root.left,sum,temp);
        if(root.right != null) dfs(root.right,sum,temp);
        temp.remove(temp.size() - 1);
    }
}
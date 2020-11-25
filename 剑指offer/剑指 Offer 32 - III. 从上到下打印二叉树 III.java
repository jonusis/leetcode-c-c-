/**
 * 
剑指 Offer 32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        int temp = 0;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList <TreeNode>();
        if(root != null) qu.add(root);
        while(!qu.isEmpty()){
            int len = qu.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i < len;i++){
                TreeNode p = qu.poll();
                arr.add(p.val);
                if(p.left != null) qu.offer(p.left);
                if(p.right != null) qu.offer(p.right);
            }
            temp++;
            if(temp % 2 == 0){
                res.add(reverse(arr));
            }else{
                res.add(arr);
            }
        }
        return res;
    }
    List<Integer> reverse(List<Integer> temp){
        int len = temp.size();
        List<Integer> res = new ArrayList<>();
        for(int i = len - 1;i >= 0;i--){
            res.add(temp.get(i));
        }
        return res;
    }
}
/**
剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return build(0,preorder.length - 1,0,inorder.length - 1,preorder,inorder);
        
    }
    public TreeNode build(int a,int b,int c,int d,int[] preorder, int[] inorder){
        TreeNode p = new TreeNode();
        if(b < a || d < c) return null;
        p.val = preorder[a];
        if(b - a == 0) return p;
        int mid = a;
        for(int i = c;i <= d;i++){
            if(inorder[i] == preorder[a]){
                mid = i;
                break;
            } 
        }
        p.left = build(a + 1, a + mid - c,c,mid - 1,preorder,inorder);
        p.right = build(a + mid + 1 - c, b, mid + 1, d,preorder,inorder);
        return p;
    }

}
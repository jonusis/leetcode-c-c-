/**
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
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

 // 个人方法：我感觉是对的。取中间节点作为根节点，循环将中间数据的左边不断插入左节点，右边数据不断插入右节点。
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        int len = nums.length;
        if(len == 0) return null;
        int mid = (0 + len) / 2;
        root.val = nums[mid];
        int i = mid + 1;
        int j = mid - 1;
        TreeNode now = root;
        while(i != len){
            TreeNode p = new TreeNode(nums[i]);
            now.right = p;
            now = now.right;
            i++;
        }
        now = root;
        while(j >= 0){
            TreeNode p = new TreeNode(nums[j]);
            now.left = p;
            now = now.left;
            j--;
        }
        return root;
    }
}

/**
官方解法，递归求解
 */

 class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}

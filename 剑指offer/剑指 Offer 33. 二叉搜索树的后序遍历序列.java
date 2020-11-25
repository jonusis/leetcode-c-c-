/**
剑指 Offer 33. 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return isSortTree(postorder,0,postorder.length - 1);
    }
    boolean isSortTree(int[] postorder,int left,int right){
        int i = 0;
        int pre = left,last = left;
        int len = right - left;
        if(len <= 1 ) return true;
        int rootVal = postorder[right];
        for(i = left;i < right;i++){
            if(rootVal < postorder[i]){
                pre = i;
                break;
            }
        }
        if(i == right) return isSortTree(postorder,left,right - 1);
        for(int j = pre;j < right;j++){
            if(rootVal > postorder[j]){
                return false;
            }
        }
        return isSortTree(postorder,left,pre - 1) && isSortTree(postorder,pre,right - 1);
    }
}
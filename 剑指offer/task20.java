/**
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 

示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。
 */
 
 class Solution {
    public int[] exchange(int[] nums) {
        int p = 0,q = nums.length - 1;
        while(p < q){
            while(nums[p] % 2 == 1 && p < nums.length - 1){
                p++;
            }
            while(nums[q] % 2 == 0 && q > 0){
                q--;
            }
            if(p < q){
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;
            }
        }
        return nums;
    }
}
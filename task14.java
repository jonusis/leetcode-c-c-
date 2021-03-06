/**
 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 */

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int last ;
        for(int i = 0;i < nums.length;i++){
            last = 0;
            for(int j = i;j < nums.length;j++){
                last += nums[j];
                if(sum < last) sum = last;
            }
        }
        return sum;
    }
}

// 官方解法 动态规划

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int pre = 0, maxAns = nums[0];
//         for (int x : nums) {
//             pre = Math.max(pre + x, x);
//             maxAns = Math.max(maxAns, pre);
//         }
//         return maxAns;
//     }
// }

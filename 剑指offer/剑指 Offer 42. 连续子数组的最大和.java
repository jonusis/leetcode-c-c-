/**
 * 剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

 

示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 

提示：

1 <= arr.length <= 10^5
-100 <= arr[i] <= 100
注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int temp[] = new int[nums.length];
        int i = 0,mid = nums[0];
        temp[0] = nums[0];
        for(i = 1;i < nums.length;i++){
            if(temp[i - 1] > 0 && temp[i - 1] + nums[i] > 0){
                temp[i] = temp[i - 1] + nums[i];
            }else{
                temp[i] = nums[i];
            }
        }
        int max = temp[0];
        for(i = 0;i < nums.length;i++){
            if(max < temp[i])  max = temp[i];
        }
        return max;
    }
}
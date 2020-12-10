/**
剑指 Offer 56 - II. 数组中数字出现的次数 II
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

 

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1
 */

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0;i < len;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],true);
            }else{
                map.put(nums[i],false);
            }
        }
        for(int i = 0;i < len;i++){
            if(map.get(nums[i])){
                return nums[i];
            }
        }
        return nums[0];
    }
}
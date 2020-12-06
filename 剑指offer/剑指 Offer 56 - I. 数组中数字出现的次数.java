/**
剑指 Offer 56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

 

示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0;i < len;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],true);
            }else{
                map.put(nums[i],false);
            }
        }
        int res[] = new int[2];
        int num = 0;
        for(int i = 0;i < len;i++){
            if(map.get(nums[i])){
                res[num] = nums[i];
                num++;
            }
            if(num == 2){
                return res;
            }
        }
        return res;
    }
}
/*
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

自己算法
i和j相邻同时向后遍历，如果nums[i] == nums[j] 整体数组往后移
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i , j;
        int len = nums.length;
        if(len == 0 || len == 1) return len;
        int l = nums[len - 1];
        i = 0;
        j = 1;
        if(nums[i] == l) return 1;
        while( nums[j] != l ){
            if(nums[i] == nums[j]) {
                for(int index = i;index < len - 1;index++){
                    nums[index] = nums[index + 1];
                }
                len--;
            }else{
                i++;
                j++;
            }

        }
        return j + 1;
    }
}
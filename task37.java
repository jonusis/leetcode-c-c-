/**
 * 136. 只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
 */ 

class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length;i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i],2);
                continue;
            }
            m.put(nums[i],1);
        }
        Set <Integer> keys = m.keySet(); 
	    for(Integer key:keys) {
		    if(m.get(key) == 1)
            return key; 
	    }
        return nums[0];
    }
}
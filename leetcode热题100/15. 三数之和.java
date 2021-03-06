/**
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if(len <= 2) return list;
        for(int i = 0;i < len - 2;i++){
            int left = i + 1,right = len - 1;
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            while(left < right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else{
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[left]);
                    arr.add(nums[right]);
                    list.add(arr);
                    left++;
                }
            }  
        }
        return list;
    }
}
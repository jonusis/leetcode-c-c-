/**
剑指 Offer 53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。

 

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2

示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
 
限制：
0 <= 数组长度 <= 50000
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        return midSerch(nums,target,0,nums.length - 1);
    }
    int midSerch(int[] nums,int target,int low,int high){
        if(low >= high && nums[low] != target) return 0;
        if(low == high && nums[low] == target) return 1;
        int mid = low + (high - low) / 2;
        if(nums[mid] < target){
            return midSerch(nums,target,mid + 1,high);
        }else if(nums[mid] > target){
            return midSerch(nums,target,low,mid);
        }else{
            int sum = 1;
            int x = mid,y = mid;
            while(x < nums.length - 1){
                x++;
                if(nums[x] != target) break;
                sum++;
            }
            while(y >= 1){
                y--;
                if(nums[y] != target) break;
                sum++;
            }
            return sum;
        }
    }
}
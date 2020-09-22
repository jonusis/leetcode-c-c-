/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。

一个简单的二分查找加插入
自己的方法 二分查找递归
如果 遍历到的mid == low 并且 nums[mid] > target 返回low所在的位置
如果 遍历到的mid == high 并且 nums[mid] < target 返回high所在的位置 + 1
*/


class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(0,nums.length - 1,nums,target);
    }
    int search (int low, int high, int[]nums,int target){
        int mid = (low + high ) / 2;
        if(nums[mid] == target) return mid;
        if(low == high && nums[mid] > target) return mid;
        if(low == high && nums[mid] < target) return mid + 1;
        if(mid == low){
            if(nums[mid] > target){
                return mid;
            }
        }
        if(mid == high){
            if(nums[mid] < target){
                return mid + 1;
            }
        }
        if(nums[mid] < target){
            return search(mid + 1, high,nums,target);
        }else if(nums[mid] > target){
            return search(low ,mid - 1,nums,target);
        }else return -1;
    }
}

// 看了官方题解，感觉自己还是水平有限 二分法还是不够熟练 下面是评论区我认为最好的方法

// class Solution {
//     public:
//         int searchInsert(vector<int>& nums, int target) {
//             int n = nums.size();
//             int l=0,r=n-1;
//             while(l<=r){
//                 int mid=l+(r-l)/2;
//                 if(nums[mid]<target)
//                     l=mid+1;
//                 else r=mid-1;
//             }
//             return l;
//         }
//     };
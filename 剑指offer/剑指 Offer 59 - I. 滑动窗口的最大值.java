/**
剑指 Offer 59 - I. 滑动窗口的最大值
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        Deque<Integer> queue = new LinkedList<>();
        int res[] = new int[nums.length - k + 1];
        for(int i = 0;i < k;i++){
            if(queue.isEmpty()){
                queue.offerFirst(nums[i]);
            }else{
                while(queue.size() != 0 && queue.peek() < nums[i]){
                    queue.removeFirst();
                }
                queue.offerFirst(nums[i]);
            }
        }
        for(int i = 0;i < nums.length + 1 - k;i++){
            int j = i + k;
            if(nums[i] == queue.getLast()){
                queue.removeLast();
                res[i] = nums[i];
            }else{
                res[i] = queue.getLast();
            }
            while(j < nums.length && queue.size() != 0 && queue.getFirst() < nums[j]){
                queue.removeFirst();
            }
            if(j < nums.length)
            queue.offerFirst(nums[j]);
        }
        return res;
    }
}
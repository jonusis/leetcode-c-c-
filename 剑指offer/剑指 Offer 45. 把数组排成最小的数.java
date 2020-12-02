/**
剑指 Offer 45. 把数组排成最小的数
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

 

示例 1:

输入: [10,2]
输出: "102"
示例 2:

输入: [3,30,34,5,9]
输出: "3033459"
 */
class Solution {
    public String minNumber(int[] nums) {
        int len = nums.length;
        for(int i = 0;i < len;i++){
            for(int j = len - 1;j > i;j--){
                String x = String.valueOf(nums[j]);
                String y = String.valueOf(nums[j - 1]);
                if((x + y).compareTo(y + x) < 0){
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        String res = new String();
        for(int i = 0;i < len;i++){
            res += nums[i];
        }
        return res;
    }
}
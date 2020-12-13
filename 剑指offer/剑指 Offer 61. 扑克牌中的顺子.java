/**
剑指 Offer 61. 扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

示例 1:
输入: [1,2,3,4,5]
输出: True
 

示例 2
输入: [0,0,1,2,5]
输出: True
 */
class Solution {
    public boolean isStraight(int[] nums) {
        int wang = 0,now = 0;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                wang++;
            }else{
                if(now == 0){
                    now = nums[i];
                }else{
                    int x = nums[i] - now;
                    if(x == 2) wang--;
                    if(x == 3) wang -= 2;
                    if(wang < 0 || x == 0 || x > 3) return false;
                    now = nums[i];
                }
            }
        }
        return true;
    }
}
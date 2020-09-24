/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

 * 
 * 自己算法 击败100%的用户（时间复杂度）
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int now = len - 1;
        int carry = 1;
        while(carry == 1){
            if(digits[now] < 9){
                carry = 0;
                digits[now]++;
            }
            else if(digits[now] == 9){
                carry = 1;
                digits[now] = 0;
                if(now == 0){
                    int arr[] = new int[len + 1];
                    arr[0] = 1;
                    return arr;
                } 
                now--;
            }
        }
         return digits;
        
    }
}
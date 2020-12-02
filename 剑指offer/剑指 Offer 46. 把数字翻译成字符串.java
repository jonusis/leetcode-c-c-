/**
剑指 Offer 46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

 

示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 

提示：

0 <= num < 231

 */
class Solution {
    public int translateNum(int num) {
        if(num < 10) return 1;
        int arr[] = new int [10];
        int i = 0;
        while(num != 0){
            int tmp = num % 10;
            num /= 10;
            arr[i] = tmp;
            i++;
        }
        for(int x = 0;x < i / 2;x++){
            int temp = arr[x];
            arr[x] = arr[i - 1 -x];
            arr[i - 1 - x] = temp;
        }
        int res[] = new int [i];
        res[0] = 1;
        if(arr[0] * 10 + arr[1] <= 25){
            res[1] = 2;
        }else{
            res[1] = 1;
        }
        for(int j = 2;j < i;j++){
            if(arr[j - 1] * 10 + arr[j] <= 25 && arr[j - 1] * 10 + arr[j] >= 10){
                res[j] = res[j - 2] + res[j - 1];
            }else{
                res[j] = res[j - 1];
            }
        }
        return res[i - 1];
    }
}
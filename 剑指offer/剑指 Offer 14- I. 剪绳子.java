/**
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
 class Solution {
    public int cuttingRope(int n) {
        int x = n / 2,y = n / 3;
        long sum = 1;
        int max = 1;
        if(n <= 4 && n > 2){
            for(int i = 0;i < x;i++){
                sum *= 2;
            }
            if(max <= sum) max = (int)sum;
        }
        if(n > 4){
            sum = 1;
            for(int i = 0;i < y - 1;i++){
                sum *= 3;
                if(sum > 1000000007) sum %= 1000000007;
            }
            if(n % 3 == 1){
                sum = sum * 2 * 2;
                if(sum > 1000000007) sum %= 1000000007;
            }else if(n % 3 == 2){
                sum = sum * 2 * 3;
                if(sum > 1000000007) sum %= 1000000007;
            }else{
                sum = sum * 3;
                if(sum > 1000000007) sum %= 1000000007;
            }
            max = (int)sum;
        }
        return max;
    }
 }
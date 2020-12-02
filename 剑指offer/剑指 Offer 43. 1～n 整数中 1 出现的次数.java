/**
 * x剑指 Offer 43. 1～n 整数中 1 出现的次数
输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

 

示例 1：

输入：n = 12
输出：5
示例 2：

输入：n = 13
输出：6
 */
class Solution {
    public int countDigitOne(int n) {
        long dit = 10;
        int sum = 0;
        long high = n,low = 1,now = 0;
        while(n % (dit / 10) != n){
            now = (n % dit);
            low = now % (dit / 10);
            now = now / (dit / 10);
            high = n / dit;
            if(now == 0){
                sum += high * (dit / 10);
            }else if(now == 1){
                sum += high * (dit / 10) + (low + 1);
            }else{
                sum += (high + 1) * (dit / 10);
            }
            dit *= 10;
        }
        return sum;
    }
}
/**
1 4 5 4
对于个位
0:前导位
1:前导位 + 1
2:
.
.
.

对于十位：
0:前导位 * 10
1404
14 4
1:1414 前导位数 * 10 + （末尾位数+1）
2-9: （前导位数 + 1）* 10
*/
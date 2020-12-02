/**
 * 
剑指 Offer 44. 数字序列中某一位的数字
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

 

示例 1：

输入：n = 3
输出：3
示例 2：

输入：n = 11
输出：0
 */
class Solution {
    public int findNthDigit(int n) {
        long x = 9,sum = 9;
        int pos = 0,dit = 1;
        if(n <= 9) return n;
        while(n > sum){
            pos += x;
            dit += 1;
            x *= 10;
            sum += x * dit;
        }
        int tmp = n - (int)(sum - dit * x);
        pos += (tmp / dit);
        int next = ((tmp - (tmp / dit) * dit) % (dit));
        if(next == 0){
            String s2 = String.valueOf(pos);
            char z = s2.charAt(s2.length() - 1);
            return (int)(z - '0');
        }else{
            String s2 =String.valueOf(pos + 1);
            char z = s2.charAt(next - 1);
            return (int)(z - '0');
        }
    }
}

/**
    0 - 9: 9 * 1
    10 - 99 : 90 * 2
    100 - 999: 900 * 3
    1000 - 9999 : 9000 * 4
    189 -- dit == 2 ,x == 90
    n -= (dit - 1) * (x / 10)
    n == 180 / 2
*/

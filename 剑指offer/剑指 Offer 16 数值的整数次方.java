/**
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
 */
 class Solution {
    public double myPow(double x, int n) {
        double s = n;
        if(n < 0){
            n = n * -1;
            s = s * -1.0;
            x = 1.0 / x;
        }
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n % 2 == 1 || s % 2 == 1){
            return x * myPow(x * x,(int) (s / 2.0));
        }else{
            return myPow(x * x,(int) (s / 2.0));
        }
    }
}
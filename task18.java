/**
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
自己的方法：从 n = 1开始遍历，如果n * n > x,return n - 1;
*/


class Solution {
    public int mySqrt(int x) {
        int n = 1;
        if(x == 0||x == 1) return x;
        while((long)n * n <= x){
            n++;
        }
        return n - 1;
    }
}

//官方题解：在此基础进行二分改进
/**
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
*/
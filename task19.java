/**
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
经典动态规划法
*/

class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[45];
        arr[0] = 1; arr[1] = 2;
        for(int i = 2;i < n;i++){
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[n - 1];
    }
}

// 为了减少存储空间 ，可以用官方给的移动数组法

/**
class Solution {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q; 
            q = r; 
            r = p + q;
        }
        return r;
    }
}

*/
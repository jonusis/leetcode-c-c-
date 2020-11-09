/**
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

 */
 class Solution {
    public int[] printNumbers(int n) {
        int num = 1;
            switch(n){
                case 1:num = 9;break;
                case 2:num = 99;break;
                case 3:num = 999;break;
                case 4:num = 9999;break;
                case 5:num = 99999;break;
                case 6:num = 999999;break;
                case 7:num = 9999999;break;
                case 8:num = 99999999;break;
                case 9:num = 999999999;break;
            }
            int[] arr = null;
            arr = new int[num];
            for(int i = 0;i < num;i++){
                arr[i] = i+1;
            }
            return arr;
    }
}
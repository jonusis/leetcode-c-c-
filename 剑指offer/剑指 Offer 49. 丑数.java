/**
我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

 

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  

1 是丑数。
n 不超过1690。
注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 */
class Solution {
    public int nthUglyNumber(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(2,0);
        map.put(3,0);
        map.put(5,0);
        int arr[] = new int[n];
        arr[0] = 1;
        for(int i = 1;i < n;i++){
            int num1 = arr[map.get(2)] * 2;
            int num2 = arr[map.get(3)] * 3;
            int num3 = arr[map.get(5)] * 5;
            if(num1 == arr[i - 1]){
                map.put(2,map.get(2) + 1);
                i--;
            }else if(num2 == arr[i - 1]){
                map.put(3,map.get(3) + 1);
                i--;
            }else if(num3 == arr[i - 1]){
                map.put(5,map.get(5) + 1);
                i--;
            }else if(num1 <= num2 && num1 <= num3){
                map.put(2,map.get(2) + 1);
                arr[i] = num1;
            }else if(num2 <= num1 && num2 <= num3){
                map.put(3,map.get(3) + 1);
                arr[i] = num2;
            }else if(num3 <= num1 && num3 <= num2){
                map.put(5,map.get(5) + 1);
                arr[i] = num3;
            }
        }
        return arr[n - 1];
    }
}
/**
剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

限制：

1 <= target <= 10^5
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int []> list = new ArrayList<>();
        int index = 1,value = 1,tail = 1;
        while(index <= target / 2){
            if(target > value){
                tail++;
                value+= tail;
            }else if(target < value){
                value -= index;
                index++;
            }else{
                int arr[] = new int [tail - index + 1];
                for(int i = index;i <= tail;i++){
                    arr[i - index] = i;
                }
                list.add(arr);
                value -= index;
                index++;
            }
        }
            return list.toArray(new int[list.size()][]);
    }
}
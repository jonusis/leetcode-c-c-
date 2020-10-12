/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0

 */
class Solution {
    int res;
    public int minArray(int[] numbers) {
        int l = 0,h = numbers.length - 1;
        if(numbers[0] < numbers[h]) return numbers[0];
        return find(l,h,numbers);
    }
    int find(int low,int high,int[] numbers){
        int mid = low + (high - low) / 2;
        if (high == low) return numbers[low];
        if(numbers[mid] < numbers[low]){
            return find(low,mid,numbers);
        }
        else if(numbers[mid] > numbers[low]){
            return find(mid + 1,high,numbers);
        }else{
            return find(low + 1,high,numbers);
        }
    }
}
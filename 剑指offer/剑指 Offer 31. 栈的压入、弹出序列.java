/**
 * 
剑指 Offer 31. 栈的压入、弹出序列
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

示例 1：

输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
示例 2：

输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
 

提示：

0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed 是 popped 的排列。
 */

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len1 = pushed.length,index1 = 0;
        int len2 = popped.length,index2 = 0;
        while(index1 < len1 && index2 < len2){
            int num1 = pushed[index1];
            int num2 = popped[index2];
            if(num1 == num2){
                index1++;
                index2++;
            }else if((stack.isEmpty()) || (num1 != num2 && stack.peek() != num2)){
                stack.push(num1);
                index1++;
            }else if(stack.peek() == num2){
                index2++;
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            while(!stack.isEmpty()){
                int x = stack.pop();
                if(x != popped[index2]){
                    return false;
                }
                index2++;
            }
            return true;
        }
        
    }
}
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：


	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。


注意空字符串可被认为是有效字符串。
（个人题解）
*/

class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        while(i < s.length()){
            char a = s.charAt(i);
            int num = isLeft(a);
            if(num == 1 || num == 2 || num == 3){
                st.push(num);
            }
            if(num == 4 ){
                if(!st.empty() && st.peek() == 1)  st.pop();
                else return false;
            }
            if(num == 5){
                if(!st.empty() && st.peek() == 2)  st.pop();
                else return false;
            }
            if(num == 6){
                if(!st.empty() && st.peek() == 3)  st.pop();
                else return false;
            }
            i++;
        }
        if(st.empty()) return true;
        return false;
    }
    int isLeft(char s){
        int i = 0;
        switch(s){
            case'(': i = 1; break;
            case'{': i = 2; break;
            case'[': i = 3; break;
            case')': i = 4; break;
            case'}': i = 5; break;
            case']': i = 6; break;
        }
        return i;
    }
}
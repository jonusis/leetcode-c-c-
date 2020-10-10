/**
剑指 Offer 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
*/
class Solution {
    public String replaceSpace(String s) {
        String res = new String();
        int len = s.length();
        if(len == 0) return s;
        int i = 0,j = 0;
        while((len - i) != 0){
            if(s.charAt(i) == ' '){
                res = res + s.substring(j,i) + "%20";
                j = i + 1;
            }
            i++;
        }
        res = res + s.substring(j,i);
        return res;
    }
}
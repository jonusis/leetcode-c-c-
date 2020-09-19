/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
自己代码如下
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if(size == 1 && strs[0].length() == 0 || size == 0) return "";
        if(size == 1) return strs[0];
        String str = compare(strs[0],strs[1]);
        if(size == 2) return str;
        for(int i = 1;i < size - 1;i++){
            str = compare(str,strs[i + 1]);
            if(str == "") break;
        }
        return str;
    }
    String compare (String s1,String s2){
        int len;
        int index = 0;
        len = s1.length() > s2.length() ? s2.length() : s1.length();
        for(int i = 0;i < len;i++){
            if(s1.charAt(i) == s2.charAt(i)) 
                index++;
            else break;
        }
        if(index >= 1) return s1.substring(0,index);
        return "";
    }
}
/*
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

个人解法 ： 用substring函数不断截取字符串，直到截取字符串去空格长度为零为止
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int i = 0;
        if(len == 0 || s.trim().length()== 0) return 0;
        while(i != len - 1){
            if(s.charAt(i) == ' ' && s.substring(i).trim().length() != 0){
                s = s.substring(i);
                len = s.length();
                i = 0;
            }
            i++;
        }
        return s.trim().length();
    }
}

// 优秀解法 双指针，从后往前遍历，遇到第一个不是空格的字符为止，获取end，新建start再获取一个是空格的字符为止。

// class Solution {
//     public int lengthOfLastWord(String s) {
//         int end = s.length() - 1;
//         while(end >= 0 && s.charAt(end) == ' ') end--;
//         if(end < 0) return 0;
//         int start = end;
//         while(start >= 0 && s.charAt(start) != ' ') start--;
//         return end - start;
//     }
// }

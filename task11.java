/*
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

个人使用算法 蛮力法 ，就从头到尾遍历，非常蠢的做法
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1 < len2) return -1;
        if(len2 == 0) return 0;
        for(int index = 0;index < len1;index++){
            int i = 0;
            int c = 0;
            int now = index;
            while( index < len1 && haystack.charAt(index) == needle.charAt(i)){
                if(i == len2 - 1){
                    c = 1;
                    break;
                } 
                i++;
                index++;
            }
            index = now;
            if(c == 1) return now;
        }
        return -1;
    }
}

// 官方题解 ”老实说这题出得意义不是很大，如果能随意用内置函数，那对于这道题来说说很不好的事情“ 最好解法 kmp算法

// class Solution {
//     public int strStr(String haystack, String needle) {
//       int L = needle.length(), n = haystack.length();
  
//       for (int start = 0; start < n - L + 1; ++start) {
//         if (haystack.substring(start, start + L).equals(needle)) {
//           return start;
//         }
//       }
//       return -1;
//     }
//   }
  
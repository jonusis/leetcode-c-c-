/**
 * 
 * 125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

 */ 

class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return true;
        String res = tobes(s);
        int size = res.length();

        for(int i = 0;i < (size/2); i++){
            if(res.charAt(i) != res.charAt(size - i - 1) )
                return false;
        }
        return true;
    }
    String tobes(String s){
        String str = new String();
        int i,j;
        char b[]=s.toCharArray();//转换成字符数组
        for(i=0,j=0;i<b.length;i++){
            if(b[i]>='a' && b[i]<='z' || b[i] >= '0' && b[i] <= '9'){
                str += b[i];
            }else if (b[i]>='A'&& b[i]<='Z'){
              str = str + (char) (b[i] - 'A' + 'a');
            }
        }
        return str;
    }
}
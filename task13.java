/**
 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

注意：整数序列中的每一项将表示为一个字符串。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
第一项是数字 1

描述前一项，这个数是 1 即 “一个 1 ”，记作 11

描述前一项，这个数是 11 即 “两个 1 ” ，记作 21

描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211

描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221

 */

class Solution {
    public String countAndSay(int n) {
        String s = new String("1211");
        String str = new String();
        if(n == 1) return "1";
        if(n == 2) return "11";
        if(n == 3) return "21";
        if(n == 4) return "1211";
        for(int i = 5;i <= n;i++){
            int num = 0,number = 0;
            int len = s.length() - 1;
            while(num <= len){
                String x = String.valueOf(s.charAt(num));
                if(num < len && x.equals(String.valueOf(s.charAt(num + 1)))){
                    number++;
                }else if(num < len && !x.equals(String.valueOf(s.charAt(num + 1)))){
                    number ++;
                    str += number + x;
                    number = 0;
                }else if(num == len){
                    number ++;
                    str += number + x;
                }
                num++;
            }
            s = str;
            str = "";
        }
        return s;
    }
}
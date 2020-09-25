/**
 * 
 给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

自己的方法：先补〇，按位相加，求得每一位carry，再进位，如果最后一位进位为1，res= 1 + res;
 */

class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        boolean isf = len1 > len2 ? true : false;
        String res = new String();
        int carry = 0;
        int i = 1,x;
        if(isf){
            x = len1 - len2;
            while(x != 0){
                b = 0 + b;
                x--;
            }
        }else{
            x = len2 - len1;
            while(x != 0){
                a = 0 + a;
                x--;
            }
        }
        int z = a.length();
        while(i <= z){
            int num1 = a.charAt(z - i) - 48;
            int num2 = b.charAt(z - i) - 48;
            if(num1 == num2 && num1 == 0){
                res = (int)(0 + carry) + res;
                carry = 0;
            }else if(num1 == num2 && num1 == 1){
                res = (int)(0 + carry) + res;
                carry = 1; 
            }else{
                int just = 1 + carry;
                if(just == 2){
                    res= 0 + res;
                    carry = 1;
                }else{
                    res = 1 + res;
                    carry = 0;
                }
            }
            
            i++;
        }
        if( carry == 1){
                res = 1 + res;
        }
        return res;
    }
}
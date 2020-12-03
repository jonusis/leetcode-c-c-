/**
 *剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = "" 
返回 " "
 

限制：

0 <= s 的长度 <= 50000
 */
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char arr[] = s.toCharArray();
        for(int i = 0;i < arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i]) + 1);
            }
        }
        for(int i = 0;i < arr.length;i++){
            if(map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return ' ';
    }
}
/**
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        char arr[] = digits.toCharArray();
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");  
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(arr,0,map,new String());
        return res;
    }
    void dfs(char arr[],int index,HashMap<Character,String> map,String tmp){
        if(index >= arr.length){
            return;
        }
        char x = arr[index];
        String s = map.get(x);
        char imp[] = s.toCharArray();
        for(int i = 0;i < imp.length;i++){
            tmp += imp[i];
            if(index == arr.length - 1){
                res.add(new String(tmp));
            }else{
                dfs(arr,index + 1,map,tmp);
            }
            tmp = tmp.substring(0,tmp.length() - 1);
        }
    }    
}
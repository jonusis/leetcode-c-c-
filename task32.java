/**
118. 杨辉三角
难度
简单

反馈
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
简单思路：与官方一致
 */

 class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numRows == 0) return list;
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        list.add(l1);
        if(numRows == 1) return list;
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        l2.add(1);
        list.add(l2);
        if(numRows == 2) return list;
        int n = 3;
        while(n <= numRows){
            List<Integer> l = new ArrayList<Integer>();
            l.add(1);
            for(int i = 1;i < n - 1;i++){
                l.add(list.get(n - 2).get(i) + list.get(n - 2).get(i - 1));
            }
            l.add(1);
            list.add(l);
            n++;
        }
        return list;
    }
}
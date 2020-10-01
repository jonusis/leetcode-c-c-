/**
119. 杨辉三角 II
难度
简单
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 3
输出: [1,3,3,1]
思路：将数据存入两个list，记录当前list和上一个list 循环遍历
 */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> last = new ArrayList<Integer>();
        if(rowIndex == 0){
            list.add(1);
            return list;
        } 
        if(rowIndex == 1){
            list.add(1);
            list.add(1);
            return list;
        }
        last.add(1);
        last.add(1);
        int num = 3;
        for(int i = 1;i < rowIndex;i++){
            List<Integer> l = new ArrayList<Integer>();
            l.add(1);
            for(int j = 1;j < num - 1;j++){
                l.add(last.get(j) + last.get(j - 1));
            }
            l.add(1);
            last.clear();
            last.addAll(l);
            num++;
            if(i == rowIndex - 1) return l;
        }
        return last;
    }
}

// 优化解法，其实就是二项式定理 通过 cni 求得结果

public List<Integer> getRow(int rowIndex) {
    List<Integer> ans = new ArrayList<>();
    int N = rowIndex;
    long pre = 1;
    ans.add(1);
    for (int k = 1; k <= N; k++) {
        long cur = pre * (N - k + 1) / k;
        ans.add((int) cur);
        pre = cur;
    }
    return ans;
}

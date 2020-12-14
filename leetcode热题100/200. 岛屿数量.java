/**
 * 200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

 

示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
 

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
 */
class Solution {
    boolean trad[][];
     int temp[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int height = grid.length;
        if(height == 0 || grid[0].length == 0) return 0;
        int width = grid[0].length;
        int num = 0;
        trad = new boolean[height][width];
        for(int i = 0;i < height;i++){
            for(int j = 0;j < width;j++){
                if(grid[i][j] == '1' && trad[i][j] == false){
                    dfs(grid,i,j);
                    num++;
                }
            }
        }
        return num;   
    }
    void dfs(char[][]grid,int x,int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || trad[x][y] == true){
            return;
        }
        if(grid[x][y] == '1'){
            trad[x][y] = true;
            for(int i = 0;i < 4;i++){
                dfs(grid,x + temp[i][0],y + temp[i][1]);
            }
        }
        return;
    }
}
package Graph;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if(!isVisited[i]){
                res++;
                dfs(i, isConnected, isVisited);
            }
        }
        return res;
    }

    public void dfs(int i, int[][] isConnected, boolean[] isVisited){
        isVisited[i] = true;
        for(int j = 0; j < isConnected[i].length; j++){
            if(isConnected[i][j] == 1 && !isVisited[j]){
                dfs(j, isConnected, isVisited);
            }
        }
    }
}
// @lc code=end


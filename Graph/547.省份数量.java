package Graph;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] isVisited = new boolean[isConnected.length];
        // iterate over the elements
        for (int i = 0; i < isConnected.length; i++) {
            // if not visited, update
            if(!isVisited[i]) res++;
            dfs(i, isVisited, isConnected);
        }
        return res;
    }

    /**
     * visit the adjacenct element of the element "elem", 
     * and update the corresponding boolean array isVisited
     * @param elem current element being visited
     * @param isVisited boolean array
     * @param isConnected graph
     */
    public void dfs(int elem, boolean[] isVisited, int[][] isConnected){
        // base case: if the current element has been visited, return
        if(isVisited[elem] == true){
            return;
        }
        // mark as visited
        isVisited[elem] = true;
        // perform the same operation for its adjacent elements
        for(int i = 0; i < isConnected[elem].length; i++){
            if(isConnected[elem][i] == 1 && !isVisited[i])
                dfs(i, isVisited, isConnected);
        }
        return;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=1007 lang=java
 *
 * [1007] 行相等的最少多米诺旋转
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int length = tops.length;
        int rotation = check(tops[0], tops, bottoms, length);
        if(rotation != -1 || tops[0] == bottoms[0]){
            return rotation;
        }else{
            rotation = check(bottoms[0], tops, bottoms, length);
        }
        return rotation;
    }

    public int check(int target, int[] tops, int[] bottoms, int length){
        int rotationA = 0;
        int rotationB = 0;
        for(int i = 0; i < length; i++){
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            }else if(tops[i] != target){
                rotationA++;
            }else if(bottoms[i] != target){
                rotationB++;
            }
        }
        return Math.min(rotationA, rotationB);
    }
}

class SolutionBASE {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int length = tops.length;
        int[] countA = new int[6];
        int[] countB = new int[6];
        int[] countAB = new int[6];
        for(int i = 0; i < length; i++){
            countA[tops[i] - 1]++;
            countB[bottoms[i] - 1]++;
            countAB[tops[i] - 1]++;
            if(tops[i] != bottoms[i])
                countAB[bottoms[i] - 1]++;
        }
        for(int i = 0; i < 6; i++){
            if(countAB[i] == length){
                return length - Math.max(countA[i], countB[i]);
            }
        }
        return -1;
    }
}
// @lc code=end


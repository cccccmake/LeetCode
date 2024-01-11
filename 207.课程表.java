/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] coursePair : prerequisites) {
            adjacency.get(coursePair[1]).add(coursePair[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i))
                return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adjacency, int[] flags, int courseNr) {
        /*
         * Consider the base cases of this recursion function: flags[courseNr] == -1 or flags[courseNr] == 1
         * Why it works => flags[courseNr] = 0 BY DEFAULT
         */
        if (flags[courseNr] == 1)
            return false;
        if (flags[courseNr] == -1)
            return true;
        flags[courseNr] = 1;
        for (Integer preCourse : adjacency.get(courseNr)) {
            if (!dfs(adjacency, flags, preCourse))
                return false;
        }
        flags[courseNr] = -1;
        return true;
    }

    /**
     * The BFS version
     * @param numCourses
     * @param prerequisites
     * @return true or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // adjacency list **adjacency.get(i)** stores prerequisites for course **i**
        List<List<Integer>> adjacency = new ArrayList<>();
        // The queue stores the course that ARE NOT prerequisites for any courses
        Queue<Integer> notPreCourses = new LinkedList<>();
        // An array to store the indegrees of each courses
        int[] inDegrees = new int[numCourses];
        // init the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] coursePair : prerequisites) {
            // update the indegree for the course coursePair[0]
            inDegrees[coursePair[0]]++;
            // update the post courses for the course **coursePair[1]**, i.e., 
            // coursePair[1] is the prerequist for the coursePair[0]
            adjacency.get(coursePair[1]).add(coursePair[0]);
        }
        // update the courses that DOES NOT play as a prerequisite course
        for (int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0){
                notPreCourses.offer(i);
            }
        }
        while(!notPreCourses.isEmpty()){
            int notPreCoursesElem = notPreCourses.poll();
            numCourses--;
            for(int preCourse : adjacency.get(notPreCoursesElem)){
                if(--inDegrees[preCourse] == 0) 
                    notPreCourses.offer(preCourse);
            }
        }
        return numCourses == 0;
    }
}
// @lc code=end

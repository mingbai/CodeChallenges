/* 
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
*/

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] in_degree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            in_degree[i] =0;
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            in_degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in_degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] order = new int[numCourses];
        int courseOrder = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[courseOrder++] = course;
            
            int numNeighbors = edges[course].size();
            for (int i = 0; i < numNeighbors; i++) {
                int pointer = (int)edges[course].get(i);
                in_degree[pointer]--;
                if (in_degree[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }
        
        if (courseOrder == numCourses) {
            return order;
        }
        
        return new int[0];
    }
}
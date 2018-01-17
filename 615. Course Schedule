
/* There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

*/


public class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] inDegree = new int[numCourses];
        List[] outCourses = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            outCourses[i] = new ArrayList<Integer>();
        }
        
        // prerequisites[i][j] => to take i have to take j first
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            outCourses[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        // queue to store the courses whose indegree is 0
        // which means a course is ready to be taken, no prerequisite any more
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int finished = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            int size = outCourses[course].size();
            for (int i = 0; i < size; i++) {
                int nextCourse = (int) outCourses[course].get(i);
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
            finished++;
        }
        if (finished == numCourses) {
            return true;
        }
        return false;
    }
}
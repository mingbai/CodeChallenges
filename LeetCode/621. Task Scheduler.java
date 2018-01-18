/* 
There are ·n· different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.

Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
*/

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskDegree = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            int m = tasks[i] - 'A';
            taskDegree[m]++;
        }
        
        Arrays.sort(taskDegree);
        int high = 25;
        while(high >= 0 && taskDegree[high] == taskDegree[25]) {
            high--;
        }
        
        return Math.max(tasks.length, (taskDegree[25] - 1) * (n + 1) + 25 - high);
    }
}
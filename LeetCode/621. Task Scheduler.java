/* 
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.
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
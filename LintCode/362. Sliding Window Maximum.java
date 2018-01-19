/*
Given an array of n integer with duplicate number, and a moving window(size k),
move the window at each iteration from the start of the array, find the maximum number inside the window at each moving.

*/

public class Solution {
    
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<>();
        // if (nums == null || nums.length < k) {
        //     return rst;
        // }
        
        if (nums == null || nums.length == 0) {
            return rst;
        }
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < k - 1; i++) {
            inQueue(deque, nums[i]);
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            inQueue(deque, nums[i]);
            rst.add(deque.peekFirst());
            outQueue(deque, nums[i - k + 1]);
        }
        return rst;
    }
    
    public void inQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num){
            deque.pollLast();
        }
        deque.offer(num);
    }
    
    public void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }
};
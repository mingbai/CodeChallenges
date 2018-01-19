/*
Given an array of n * m matrix, and a moving matrix window (size k * k), move the window from top left to botton right at each iteration,
find the maximum sum inside the window at each moving. Return 0 if the answer does not exist.
*/

public class Solution {
    
    public int maxSlidingMatrix(int[][] matrix, int k) {
        // corner case first
        int m = matrix.length;
        if (m == 0 || m < k) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0 || n < k) {
            return 0;
        }
        
        // 3D version of preSum
        // construct the presum matrix
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            preSum[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            preSum[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
        
        // calculate the sum of matrix from the pre sum matrix
        int max = Integer.MIN_VALUE;
        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                int sum_k = preSum[i][j] - preSum[i - k][j] - preSum[i][j - k] + preSum[i - k][j - k];
                if (sum_k > max) {
                    max = sum_k;
                }
            }
        }
        return max;
    }
}
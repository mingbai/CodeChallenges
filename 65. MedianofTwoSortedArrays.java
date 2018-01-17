




















public Solution {
	public double findMedianTwoSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		if (m < n) {
			findMedianTwoSortedArrays(nums2, nums1);
		}
		if (n == 0) {
			return (double) (nums1[(m - 1) / 2] + nums1[m / 2]) / 2;
		}

		int low = 0;
		int high = n * 2;
		while (low <= high) {
			int cut_b = low + (high - low) / 2;
			int cut_a = m + n - cut_b;

			double L_a = (cut_a == 0) ? Integer.MIN_VALUE : nums1[(cut_a - 1) / 2];
            double L_b = (cut_b == 0) ? Integer.MIN_VALUE : nums2[(cut_b - 1) /2];
            double R_a = (cut_a == m * 2) ? Integer.MAX_VALUE : nums1[cut_a / 2];
            double R_b = (cut_b == n * 2) ? Integer.MAX_VALUE : nums2[cut_b / 2];


            if (L_a > R_b) {
                lo = cut_b + 1;
            }
            else if (L_b > R_a){
                 hi=cut_b-1;
            }
            else {
                return (Math.max(L_a, L_b) + Math.min(R_b, R_a)) / 2; 
            }
		}
		return -1;
	}
}
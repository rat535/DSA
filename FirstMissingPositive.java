
// First Missing Positive
// Solved
// Hard
// Topics
// Companies
// Hint
// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

// Example 1:

// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.
public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            boolean contains1 = false;

            for (int i = 0; i < n; i++) {

                if (nums[i] == 1) {
                    contains1 = true;
                }
                if (nums[i] <= 0 || nums[i] > n) {
                    nums[i] = 1;
                }
            }

            if (!contains1)
                return 1;

            for (int i = 0; i < n; i++) {
                int val = Math.abs(nums[i]);
                int idx = val - 1;

                if (nums[idx] < 0)
                    continue;
                nums[idx] *= -1;
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] > 0)
                    return i + 1;
            }

            return n + 1;
        }
    }
}

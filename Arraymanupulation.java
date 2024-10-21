// Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in the array.

// Example

// Queries are interpreted as follows:

//     a b k
//     1 5 3
//     4 8 7
//     6 9 1
// Add the values of  between the indices  and  inclusive:

// index->	 1 2 3  4  5 6 7 8 9 10
// 	[0,0,0, 0, 0,0,0,0,0, 0]
// 	[3,3,3, 3, 3,0,0,0,0, 0]
// 	[3,3,3,10,10,7,7,7,0, 0]
// 	[3,3,3,10,10,8,8,8,1, 0]
// The largest value is  after all operations are performed.

import java.util.List;

public class Arraymanupulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long[] l = new long[n + 1]; // Create a difference array with one extra space

        // Apply the queries using the difference array approach
        for (List<Integer> li : queries) {
            int s = li.get(0) - 1;
            int e = li.get(1);
            long z = li.get(2);

            l[s] += z;
            if (e < n) {
                l[e] -= z;
            }
        }

        long max = 0;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += l[i];
            max = Math.max(max, currentSum);
        }

        return max;
    }
}

// Complete the rotateLeft function in the editor below.

// rotateLeft has the following parameters:

// int d: the amount to rotate by
// int arr[n]: the array to rotate
// Returns

// int[n]: the rotated array
// Input Format

// The first line contains two space-separated integers that denote , the number of integers, and , the number of left rotations to perform.
// The second line contains  space-separated integers that describe .

// Constraints

import java.util.List;

public class leftRotation {
    public static void reveres(List<Integer> l, int s, int e) {
        while (s < e) {

            int temp = l.get(s);
            l.set(s, l.get(e));
            l.set(e, temp);
            s++;
            e--;
        }
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        int k = d % n;
        reveres(arr, 0, k - 1);
        reveres(arr, k, n - 1);
        reveres(arr, 0, n - 1);

        return arr;

    }
}


import java.util.ArrayList;
import java.util.List;

// Declare a 2-dimensional array, , of  empty arrays. All arrays are zero indexed.
// Declare an integer, , and initialize it to .

// There are  types of queries, given as an array of strings for you to parse:

// Query: 1 x y
// Let .
// Append the integer  to .
// Query: 2 x y
// Let .
// Assign the value  to .
// Store the new value of  to an answers array.
// Note:  is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia.  is the modulo operator.
// Finally, size(arr[idx]) is the number of elements in arr[idx]

public class dynamicArray {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();

        // Initialize the array of lists
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (List<Integer> query : queries) {
            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int idx = (x ^ lastAnswer) % n;

            if (type == 1) {
                arr.get(idx).add(y);
            } else {
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                result.add(lastAnswer);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 0, 5));
        queries.add(List.of(1, 1, 7));
        queries.add(List.of(1, 0, 3));
        queries.add(List.of(2, 1, 0));
        queries.add(List.of(2, 1, 1));

        List<Integer> result = dynamicArray(2, queries);
        System.out.println(result); // Output the result
    }
}

// 51. N-Queens
// Solved
// Hard
// Topics
// Companies
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

import java.util.ArrayList;
import java.util.List;

public class Nqueen {
    public class Solution {
        private List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            if (n == 0)
                return result;

            List<String> board = new ArrayList<>();
            // For n = 3, board = {"...", "...", "..."} initially
            for (int i = 0; i < n; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    row.append('.');
                }
                board.add(row.toString());
            }

            solve(board, 0);

            return result;
        }

        private boolean isValid(List<String> board, int row, int col) {
            // Look for up
            for (int i = row; i >= 0; i--) {
                if (board.get(i).charAt(col) == 'Q')
                    return false;
            }

            // Check left diagonal upwards
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q')
                    return false;
            }

            // Check right diagonal upwards
            for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
                if (board.get(i).charAt(j) == 'Q')
                    return false;
            }

            return true;
        }

        private void solve(List<String> board, int row) {
            if (row == board.size()) {
                result.add(new ArrayList<>(board));
                return;
            }

            for (int i = 0; i < board.size(); i++) {
                if (isValid(board, row, i)) {
                    StringBuilder newRow = new StringBuilder(board.get(row));
                    newRow.setCharAt(i, 'Q');
                    board.set(row, newRow.toString());

                    solve(board, row + 1);

                    newRow.setCharAt(i, '.');
                    board.set(row, newRow.toString());
                }
            }
        }
    }

}

import java.util.*;

class Solution {
    // Function to check if it's safe to place the queen at board[row][col]
    public boolean isSafe(int row, int col, char[][] board) {//**5
        // Check horizontally
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Check vertically
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Check upper right diagonal
        r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Check lower left diagonal
        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Check lower right diagonal
        r = row;
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // It's safe to place the queen here
        return true;
    }

    // Function to save the board configuration
    public void saveBoard(char[][] board, List<List<String>> allBoards) {//**6
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            newBoard.add(row);//after one inner loop the row's value wil be stored here
        }
        allBoards.add(newBoard);//then finally when outer loop terminates the values of newBoard will be soted here
    }

    // Helper function to place queens on the board
    public void helper(char[][] board, List<List<String>> allBoards, int col) {//**4
        if (col == board.length) {
            saveBoard(board, allBoards); // Save valid board configuration
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) { // Check if it's safe to place the queen
                board[row][col] = 'Q'; // Place queen
                helper(board, allBoards, col + 1); // Recur to place the next queen
                board[row][col] = '.'; // it backtracks and add . to the Q position if it finds difficuity in placing Q in another cols
            }
        }
    }

    // Main function to solve the N-Queens problem
    public List<List<String>> solveNQueens(int n) {//**2
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.' in every position
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Start solving the problem
        helper(board, allBoards, 0);//**3
        return allBoards;
    }

    public static void main(String[] args) {//**1
        Solution sol = new Solution();
        int n = 4; // Example: Solving for 4x4 chessboard
        List<List<String>> result = sol.solveNQueens(n);

        //<List<String> stores the answer of only one row or col
        // List<List<String>> sotres the final position of all the rows or cols

// sol sirf solveNQueens(n) method ko call kar raha hai, 
// lekin jo result return hota hai, usko sol mein store nahi kiya jata.
// Jo result return hota hai, usko tum kisi alag variable (jaise result) mein store karte ho.


        // Print all solutions
        for (List<String> solution : result) {

            // Ye sab loops me : ka use enhanced for loop ke liye hota hai. 
// Enhanced for loop ka purpose hai ki koi collection (jaise list, array) ke har element ko ek simple tarike se access kiya ja sake, bina index ka manually use kiye.

// solution : result ka matlab hai ki har iteration me result ke andar ek solution ko access kiya ja raha hai, jo ek pura list hai (i.e. ek solution ka pura chessboard).
// solution ek ek karke result ke har solution ko lega.
            for (String row : solution) {
                // row : solution ka matlab hai ki har solution (jo ek pura chessboard hai) ke andar ek ek row ko row me store karte hain.
// Phir System.out.println(row); ka use karke hum us row ko print karte hain

                System.out.println(row);
            }
            System.out.println();
        }
    }
}

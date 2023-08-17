package validSudoku;

public class Solution {

    private boolean isValid(char[][] board, int row, int column, char value) {
        // value is present, we dont need to check the [row, column] coordinates.
        // because its the coordinate where our value is present.
        // we just need to check other elements.
        for ( int i = 0; i < 9; i++) {

            if ( i != column && board[row][i] == value) {
                return false;
            }

            if ( i != row && board[i][column] == value) {
                return false;
            }

            int c1 = (3 * (row/3)) + ( i / 3);
            int c2 = ( 3 * (column/3)) + (i %3);

            if (c1 == row && c2 == column ) {
                continue;
            }

            if ( board[c1][c2] == value) {
                return false;
            }
        }
        return true;

    }



    public boolean isValidSudoku(char[][] board) {
        for ( int  i = 0; i < 9; i++ ) {
            for ( int j = 0; j < 9; j++) {
                // ignore unfilled data.
                if ( board[i][j] == '.') {
                    continue;
                }
                char value = board[i][j];
                if ( ! isValid(board, i, j, value)) {
                    return false;
                }

            }
        }
        return true;
    }

}

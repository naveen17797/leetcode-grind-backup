package sudokuSolver;

class Solution {

    public void solveSudoku(char[][] board) {
        // general idea is to choose a number between 1 to 9, place it
        // then try to solve it recursively
        // By this way we will go through all possible combinations of sudoku board
        // and will get only the board which has the valid combination.
        solve(board);


    }

    private boolean isValid(char[][]board, int row, int column, char k) {

        for ( int  i = 0; i < 9; i++) {
            // now we check if element going to be inserted is present in
            // the row
            if ( board[row][i] == k) {
                return false;
            }

            if ( board[i][column] == k) {
                return false;
            }

            if ( board[(3* (row/3) ) + (i/3) ][(3 * (column/3)) + (i%3)] == k ) {
                return  false;
            }
        }

        return true;


    }

    private boolean solve(char[][] board) {
        for ( int i = 0; i < 9; i++ ) {
            for ( int j = 0; j < 9; j++) {
                char value = board[i][j];
                if ( value != '.') {
                    continue;
                }

                // now that we have encountered the value with dot
                // we can put some value between 1 to 9 and see if
                // it actually solves the sudoku.
                for ( int k = 1; k < 10; k++) {



                    if ( isValid(board, i, j, (char)(k + '0'))) {
                        // now that we put the value we need to check if the value can be solved though.
                        board[i][j] = (char)(k + '0');
                        if ( solve(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;

            }


        }

        // none of the solution works.
        return true;
    }
}
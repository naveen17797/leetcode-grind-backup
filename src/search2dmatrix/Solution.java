package search2dmatrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = (m * n ) - 1;


        // now that we have the array, implement binary search.
        while ( start <= end) {
            int mid = ((end-start) / 2) + start;
            int mid_value = matrix[mid/n][mid % n];

            if ( mid_value == target) {
                return true;
            }
            else if ( mid_value < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }


        return false;


    }
}
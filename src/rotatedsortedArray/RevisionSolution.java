package rotatedsortedArray;

public class RevisionSolution {

    public static void main(String[] args) {
        System.out.println( search( new int[] {4,5,6,7,0,1,2}, 1) );
    }

    public static int search(int[] nums, int target) {

        int len = nums.length;
        int  start = 0;
        int  end = len - 1;

        while ( start <= end ) {

            int mid = ((end - start) / 2) + start ;
            // we need to find which part of array is sorted.

            if ( nums[mid] == target) {
                return mid;
            }

            if ( nums[start] == target) {
                return start;
            }

            if ( nums[end] == target) {
                return end;
            }

            if ( nums[start] < nums[mid] ) {
                // i to mid is sorted.
                if ( target < nums[mid] && target > nums[start]) {
                    // we have to check this part, it lies in range
                    // move the end pointer to mid
                    end = mid;
                }
                else {
                    start = mid + 1;
                }

            }
            else {
                // mid to end is sorted.
                if ( target < nums[end] && target > nums[mid]) {
                    // move the start pointer to mid + 1
                    start = mid + 1;
                }
                else {
                    end = mid;
                }
            }

        }

        return -1;



    }



}

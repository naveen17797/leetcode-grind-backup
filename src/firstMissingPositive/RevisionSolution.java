package firstMissingPositive;

class RevisionSolution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int  i = 0;

        while ( i < len) {

            int value = nums[i];
            int target_index = value - 1;
            if ( target_index >= 0 && target_index <= len &&
                    nums[target_index] != i ) {
                nums[i] = nums[target_index];
                nums[target_index] = value;
            }
            else {
                i += 1;
            }
        }


        for ( int j = 0; j < len; j++ ) {
            if ( nums[j] != j + 1) {
                return j + 1;
            }
        }

        return len + 1;


    }
}



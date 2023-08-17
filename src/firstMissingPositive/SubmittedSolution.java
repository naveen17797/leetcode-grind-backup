package firstMissingPositive;

class SubmittedSolution {
    public int firstMissingPositive(int[] nums) {
        int len  = nums.length;
        int i = 0;
        while ( i < len) {
            // steps
            // 1. at each index check if the value is at right pos
            // But for negative and value out of array index bound
            // we should not do the swap

            int current_val = nums[i];
            if ( current_val > 0 && current_val <= len &&
                    current_val != nums[ current_val - 1]) {
                int value_to_be_swapped = nums[ current_val - 1];
                nums[current_val - 1] = current_val;
                nums[i] = value_to_be_swapped;
            }
            else {
                i += 1;
            }
        }

        // now cyclic sort is done, we need to check which index now doesnt
        // have the value equals to it.
        for ( int j = 0; j < len; j++) {
            if ( nums[j] != j + 1) {
                return j + 1;
            }
        }


        return nums.length + 1;
    }
}
package subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RevisionSolution {

    public static void main(String[] args) {
        subsets(new int[] {4,5,5});
        // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        Arrays.sort(nums);

        recurse(0, nums, new ArrayList<>(), output);

        return output;
    }

    private static void recurse(int start, int[] nums, List<Integer> curr, List<List<Integer>> output) {

        for ( int i = start; i < nums.length; i++) {
            if ( i != start && nums[i] == nums[i-1] ) {
                continue;
            }
            curr.add(nums[i]);
            output.add(new ArrayList<>(curr));
            recurse(i + 1, nums, curr, output);
            curr.remove(curr.size() - 1);
        }

    }

}

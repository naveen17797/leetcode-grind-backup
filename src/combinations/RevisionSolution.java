package combinations;

import java.util.ArrayList;
import java.util.List;

public class RevisionSolution {


    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> output = new ArrayList();
        recurse(output, new ArrayList<>(), 1, n, k);

        return output;
    }

    private static void recurse(List<List<Integer>> output, List<Integer> curr, int start, int n, int k) {
        if ( curr.size() == k) {
            output.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++ ) {
            curr.add(i);
            recurse(output, curr, i + 1, n, k);
            // Remember to pop the array.
            curr.remove(curr.size() - 1);
        }
    }

}

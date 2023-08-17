package slidingWindowMaximum;

import java.util.*;

public class RevisionSolution {

    public static void main(String[] args) {
        maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> output = new ArrayList<>();
        int window_start = 0;
        Deque<Integer> curr = new ArrayDeque<>();

        for ( int window_end = 0; window_end < nums.length; window_end++) {


            // cleanup out of bound indexes.
            while ( curr.size() > 0 && curr.peek() < window_end - k + 1) {
                curr.pollFirst();
            }

            // remove all elements which are less than the element going
            // to be added
            while ( curr.size() > 0 && nums[curr.peekLast()] < nums[window_end] ) {
                curr.pollLast();
            }


            curr.offerLast(window_end);


            int window_capacity = window_end - window_start + 1;

            if ( window_capacity < k) {
                continue;
            }

            // now that we have maximum capacity
            output.add(nums[curr.peek()]);

            window_start += 1;

        }




        return output.stream().mapToInt( i -> i).toArray();
    }
}

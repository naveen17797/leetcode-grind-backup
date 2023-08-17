package allanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RevisionSolution {

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }


    public static List<Integer> findAnagrams(String s, String p) {


        int[] target_frequency_map = new int[26];
        int len = s.length();
        int target_len = p.length();

        for ( char c: p.toCharArray()) {
            target_frequency_map[c - 'a'] += 1;
        }

        int window_start = 0;

        int[] window_frequency_map = new int[26];

        List<Integer> result = new ArrayList();

        for ( int window_end = 0; window_end < len; window_end++) {

            window_frequency_map[ s.charAt(window_end) - 'a'] += 1;

            // if sufficient length not reached dont compare.
            if ( window_end - window_start + 1 < target_len ) {

                continue;
            }


            if ( Arrays.hashCode(window_frequency_map) == Arrays.hashCode(target_frequency_map)) {
                result.add(window_start);
            }

            // but this means we have to remove the character from frequency map.
            window_frequency_map[ s.charAt(window_start) - 'a'] -= 1;

            // shift the window one step forward;
            window_start += 1;





        }

        return result;



    }
}

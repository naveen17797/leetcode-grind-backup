package longestRepeatingCharacterReplacement;

public class RevisionSolution {


    public int characterReplacement(String s, int k) {
        int len = s.length();
        int window_start = 0;
        int max = 0;
        int max_char_count = 0;
        int[] char_counts = new int[26];
        for (int window_end = 0; window_end < len; window_end++) {
            char_counts[s.charAt(window_end) - 'A'] += 1;
            int current_char_count = char_counts[s.charAt(window_end) - 'A'];
            max_char_count = Math.max(max_char_count, current_char_count);
            while (window_end - window_start - max_char_count + 1 > k) {
                char_counts[s.charAt(window_start) - 'A'] -= 1;
                window_start += 1;
            }
            max = Math.max(max, window_end - window_start + 1);
        }
        return max;
    }





}

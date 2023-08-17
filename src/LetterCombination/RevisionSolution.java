package LetterCombination;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;

public class RevisionSolution {

    String[] keys = new String[] { "0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        recurse("", 0, digits, output);
        return output;
    }


    public void recurse(String current, int start, String digits, List<String> output) {
        if ( current.length() == digits.length()) {
            output.add(current);
            return;
        }

        for (char c : keys[Character.getNumericValue(digits.charAt(start))].toCharArray()) {
            recurse(current + c, start + 1, digits, output);
        }


    }


}

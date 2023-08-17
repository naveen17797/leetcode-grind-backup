package validPalindrome;

public class RevisionSolution {

    public static void main(String[] args) {
        isPalindrome("race a car");
    }

    public static boolean isPalindrome(String s) {

        String formatted = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int len = formatted.length();
        if ( len == 0) return true;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if ( formatted.charAt(i) != formatted.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

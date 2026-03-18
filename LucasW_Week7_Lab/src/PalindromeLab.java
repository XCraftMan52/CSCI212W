public class PalindromeLab {

    public static boolean isPalindrome(String str) {

        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static String cleanString(String input) {
        return input.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    public static void main(String[] args) {


        String input = "!!!";
        String cleaned = cleanString(input);

        if (isPalindrome(cleaned)) {
            System.out.println("This IS a palindrome.");
        } else {
            System.out.println("This is NOT a palindrome.");
        }

    }
}
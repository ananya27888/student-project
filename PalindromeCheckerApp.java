class PalindromeCheckerRecursive {

    static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        return checkPalindrome(str, 0, str.length() - 1);
    }

    static boolean checkPalindrome(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return checkPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "racecar";
        boolean result = isPalindrome(input);
        System.out.println("Is Palindrome: " + result);
    }

}
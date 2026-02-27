class PalindromeCheckerNormalized {

    static boolean isPalindrome(String str) {
        if (str == null)
            return false;

        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;


    }



    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";
        boolean result = isPalindrome(input);
        System.out.println("Is Palindrome: " + result);
    }


}
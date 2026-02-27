import java.util.Stack;

class PalindromeChecker {

    private String value;

    public PalindromeChecker(String value) {
        this.value = value;
    }

    public boolean checkPalindrome() {
        if (value == null)
            return false;

        String normalized = value.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < normalized.length(); i++)
            stack.push(normalized.charAt(i));

        for (int i = 0; i < normalized.length(); i++)
            if (normalized.charAt(i) != stack.pop())
                return false;

        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker("Level");
        System.out.println("Is Palindrome: " + checker.checkPalindrome());
    }
}
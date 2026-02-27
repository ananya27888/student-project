import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

interface PalindromeStrategy {
    boolean check(String value);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String value) {
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

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String value) {
        if (value == null)
            return false;

        String normalized = value.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < normalized.length(); i++)
            deque.addLast(normalized.charAt(i));

        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;

        return true;
    }
}

class PalindromeService {

    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String value) {
        return strategy.check(value);
    }
}

public class Main {

    public static void main(String[] args) {
        PalindromeService service = new PalindromeService(new StackStrategy());
        System.out.println("Stack Strategy: " + service.checkPalindrome("Madam"));

        service.setStrategy(new DequeStrategy());
        System.out.println("Deque Strategy: " + service.checkPalindrome("Racecar"));
    }

}
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

interface PalindromeStrategy {
    boolean check(String value);
}

class IterativeStrategy implements PalindromeStrategy {

    public boolean check(String value) {
        if (value == null)
            return false;

        String normalized = value.replaceAll("\\s+", "").toLowerCase();
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

public class PerformanceComparison {

    static void measure(String name, PalindromeStrategy strategy, String input) {
        long start = System.nanoTime();
        boolean result = strategy.check(input);
        long end = System.nanoTime();
        System.out.println(name + " Result: " + result +
                " | Time(ns): " + (end - start));
    }

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        measure("Iterative", new IterativeStrategy(), input);
        measure("Stack", new StackStrategy(), input);
        measure("Deque", new DequeStrategy(), input);
    }
}
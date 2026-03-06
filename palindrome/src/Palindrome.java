import java.util.*;

interface PalindromeStrategy {
    boolean check(String s);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        String rev = "";

        for (int i = 0; i < s.length(); i++)
            stack.push(s.charAt(i));

        while (!stack.isEmpty())
            rev += stack.pop();

        return s.equals(rev);
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++)
            deque.addLast(s.charAt(i));

        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast())
                return false;

        return true;
    }
}

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1)
            strategy = new StackStrategy();
        else
            strategy = new DequeStrategy();

        if (strategy.check(input))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}

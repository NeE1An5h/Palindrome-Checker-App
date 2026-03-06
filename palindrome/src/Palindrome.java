import java.util.*;

public class Palindrome {

    static boolean stackCheck(String s) {
        Stack<Character> stack = new Stack<>();
        String rev = "";

        for (int i = 0; i < s.length(); i++)
            stack.push(s.charAt(i));

        while (!stack.isEmpty())
            rev += stack.pop();

        return s.equals(rev);
    }

    static boolean dequeCheck(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++)
            deque.addLast(s.charAt(i));

        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast())
                return false;

        return true;
    }

    static boolean recursiveCheck(String s, int start, int end) {
        if (start >= end)
            return true;

        if (s.charAt(start) != s.charAt(end))
            return false;

        return recursiveCheck(s, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start1 = System.nanoTime();
        boolean r1 = stackCheck(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean r2 = dequeCheck(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean r3 = recursiveCheck(input, 0, input.length() - 1);
        long end3 = System.nanoTime();

        System.out.println("Stack Result: " + (r1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Stack Time: " + (end1 - start1) + " ns");

        System.out.println("Deque Result: " + (r2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Deque Time: " + (end2 - start2) + " ns");

        System.out.println("Recursive Result: " + (r3 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}


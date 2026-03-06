import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String s = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = s.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}
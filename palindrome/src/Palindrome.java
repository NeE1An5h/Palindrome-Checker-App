import java.util.*;
public class Palindrome
{
    static void main() {
       Scanner sc=new Scanner(System.in);
        System.out.print("Input String: ");
        String str = sc.next();
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        System.out.println("Reversed string: " + rev);

        if (str.equals(rev)) {
            System.out.println("The string is a Palindrome");
        } else {
            System.out.println("The string is NOT a Palindrome");
        }

        sc.close();
    }
}

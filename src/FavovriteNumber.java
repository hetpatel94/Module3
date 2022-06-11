import java.util.Scanner;

public class FavovriteNumber
{
    public static void main(String[]args)
    {
        int n;
        Scanner inp = new Scanner(System.in); //user's favorite number
        // to read input
        // get user's favorite number
        System.out.println("What is your favorite number? ");
        n = inp.nextInt();

        // computer next number
        n = n +1;

        // Write the output
        System.out.println();
        System.out.println("My favorite number is 1 more than that, " + n);
        System.out.println();
        System.out.println();
    }
}
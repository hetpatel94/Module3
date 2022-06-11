/* java Random Sorter program
 * Generate 25 random numbers between the. number 1 and 100,
 * and append them into the appropriate odd or even list  */

public class OddEven{
    public static void main( String []args)
    {
        int num[] = new int[25];
        int odd = 0, even = 0;
        int randomNumber;

        //create array of 25 random numbers
        for (int i = 0; i < 25; i++)
        {
            randomNumber = 1 + (int) (Math.random() * 100);
            num[i] = randomNumber;
            if (randomNumber % 2==0) ++even;
            else ++odd;
        }

        // create odd and even arrays to exact lengths
        int evenArray[] = new int[even];
        int oddArray[] = new int[odd];
        int x = 0,y = 0;

        for (int n : num) {
            if (n % 2== 0) {  //evens
                evenArray[x] = n;
                x++;
            }
            else {
                oddArray[y] = n;
                y++;
            }

        }
        // display odd and even arrays
        System.out.print("Even numbers are:");
        for (int i : evenArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Odd numbers are:");
        for (int i :oddArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

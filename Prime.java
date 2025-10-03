import java.util.Scanner;

/**
 * Lab 5 - Prime Numbers
 * This program checks if a number is prime or not.
 * After each test, the user can decide to continue or quit.
 * 
 * @author Alessandro Greco
 */
public class Prime {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        // do-while loop to repeat until user says "no"
        do {
            // Ask for number
            System.out.print("Enter a whole number > 2 (e.g. 19): ");
            int number = input.nextInt();

            // Test if prime
            boolean prime = testForPrime(number);

            if (prime) {
                System.out.println(number + " is prime");
            } else {
                System.out.println(number + " is not prime");
            }

            // Ask if the user wants to test another number
            System.out.print("Enter yes to test another number, no to quit: ");
            choice = input.next();

        } while (choice.equalsIgnoreCase("yes"));

        input.close();
    }

    /**
     * Tests if a number is prime.
     * @param number number to test
     * @return true if prime, false otherwise
     */
    public static boolean testForPrime(int number) {
        if (number <= 1) {
            return false;
        }
        // only need to check divisors up to sqrt(number)
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // divisible, not prime
            }
        }
        return true;
    }
}

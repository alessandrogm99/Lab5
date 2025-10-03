import java.util.Scanner;

/**
 * Lab 5 - Prime Numbers
 * This program tests whether a number greater than 2 is prime.
 * The user can continue testing until choosing to quit.
 * 
 * @author Alessandro Greco
 */
public class Prime {

    /**
     * Main method: asks for a number, checks if prime,
     * and repeats until user enters "no".
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String again;

        do {
            System.out.print("Enter a number greater than 2: ");
            int number = input.nextInt();

            if (testForPrime(number)) {
                System.out.println(number + " is prime.");
            } else {
                System.out.println(number + " is not prime.");
            }

            System.out.print("Do you want to test another number? (yes/no): ");
            again = input.next();
        } while (again.equalsIgnoreCase("yes"));
    }

    /**
     * Tests whether the given number is prime.
     * 
     * @param number the integer to test
     * @return true if the number is prime, false otherwise
     */
    public static boolean testForPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

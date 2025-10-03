import java.util.Scanner;

/**
 * Lab 5 - Falling Distance
 * This program computes the distance an object falls in free fall
 * for a number of seconds entered by the user.
 * 
 * It demonstrates the use of methods, constants, and formatted output.
 * 
 * @author Alessandro Greco
 */
public class FallingDistance {

    public static final double ACCELERATION = 9.8;

    /**
     * Main method: asks the user for the number of seconds,
     * then prints a table of time vs. distance.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of seconds: ");
        int seconds = input.nextInt();

        System.out.println("Time\tDistance");
        System.out.println("-----------------");
        for (int i = 1; i <= seconds; i++) {
            double d = getDistance(i);
            System.out.printf("%d\t%.2f\n", i, d);
        }
    }

    /**
     * Calculates the falling distance after a given number of seconds.
     * 
     * @param seconds the number of seconds
     * @return the distance in meters
     */
    public static double getDistance(int seconds) {
        return 0.5 * ACCELERATION * seconds * seconds;
    }
}

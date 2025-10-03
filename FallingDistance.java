import java.util.Scanner;

/**
 * Lab 5 - Falling Distance
 * This program calculates the distance an object falls
 * in free fall for a given number of seconds.
 * 
 * @author Alessandro Greco
 */
public class FallingDistance {

    // constant for gravity acceleration (m/s^2)
    public static final double ACCELERATION = 9.8;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user for the number of seconds
        System.out.print("Please enter how many seconds to compute: ");
        int numOfSecs = input.nextInt();

        // Print table header
        System.out.println("Time(secs)   Distance(m)");
        System.out.println("==========   ===========");

        // Loop from 1 to numOfSecs
        for (int i = 1; i <= numOfSecs; i++) {
            double distance = getDistance(i);
            System.out.printf("%-11d %.1f\n", i, distance);
        }

        input.close();
    }

    /**
     * Calculates the distance traveled in free fall
     * after a given number of seconds.
     * @param seconds number of seconds
     * @return distance in meters
     */
    public static double getDistance(int seconds) {
        double distance = 0.5 * ACCELERATION * Math.pow(seconds, 2);
        return distance;
    }
}

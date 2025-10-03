import java.io.*;
import java.util.Scanner;

/**
 * Lab 5 - Grades
 * This program reads grades from an input file and writes statistics
 * (letter grade counts, min, max, and average) to an output file.
 * 
 * Each line of the input ends with -1. If no grades are present,
 * it writes "No grades to average".
 * 
 * @author Alessandro Greco
 */
public class Grades {

    /**
     * Main method: asks for input/output file names and processes them.
     * 
     * @param args command line arguments (not used)
     * @throws IOException if file read/write fails
     */
    public static void main(String[] args) throws IOException {
        String inFile = getInFile();
        String outFile = getOutFile();
        processFile(inFile, outFile);
        System.out.println("Processing complete. Results written to " + outFile);
    }

    /**
     * Prompts the user for the name of the input file, checking if it exists.
     * 
     * @return the name of the input file
     */
    public static String getInFile() {
        Scanner input = new Scanner(System.in);
        File file;
        String filename;

        do {
            System.out.print("Enter input filename: ");
            filename = input.nextLine();
            file = new File(filename);

            if (!file.exists()) {
                System.out.println("File does not exist. Try again.");
            }
        } while (!file.exists());

        return filename;
    }

    /**
     * Prompts the user for the name of the output file.
     * 
     * @return the name of the output file
     */
    public static String getOutFile() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter output filename: ");
        return input.nextLine();
    }

    /**
     * Reads grades from the input file and writes statistics to the output file.
     * 
     * @param inFile the input filename
     * @param outFile the output filename
     * @throws IOException if file read/write fails
     */
    public static void processFile(String inFile, String outFile) throws IOException {
        Scanner in = new Scanner(new File(inFile));
        PrintWriter out = new PrintWriter(outFile);

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty()) continue;

            Scanner lineScan = new Scanner(line);

            int count = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            int aCount = 0, bCount = 0, cCount = 0, dCount = 0, fCount = 0;

            while (lineScan.hasNextInt()) {
                int grade = lineScan.nextInt();
                if (grade == -1) break;

                count++;
                sum += grade;
                if (grade < min) min = grade;
                if (grade > max) max = grade;

                if (grade >= 90) aCount++;
                else if (grade >= 80) bCount++;
                else if (grade >= 70) cCount++;
                else if (grade >= 60) dCount++;
                else fCount++;
            }

            if (count == 0) {
                out.println("No grades to average");
            } else {
                double avg = (double) sum / count;
                out.printf("A:%d B:%d C:%d D:%d F:%d\n", aCount, bCount, cCount, dCount, fCount);
                out.printf("Min: %d  Max: %d  Average: %.1f\n", min, max, avg);
            }
            out.println();

            lineScan.close();
        }

        in.close();
        out.close();
    }
}

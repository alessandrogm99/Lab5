import java.io.*;
import java.util.Scanner;

/**
 * Lab 5 - Grade Processing
 * Reads grades from an input file, computes statistics, and
 * writes results to an output file.
 * 
 * @author Alessandro Greco
 */
public class Grades {

    public static void main(String[] args) throws IOException {
        String inFile = getInFile();
        String outFile = getOutFile();
        processFile(inFile, outFile);
        System.out.println("Processing complete. Results written to " + outFile);
    }

    /**
     * Ask user for the name of the input file
     * @return file name
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
     * Ask user for the name of the output file
     * @return file name
     */
    public static String getOutFile() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter output filename: ");
        return input.nextLine();
    }

    /**
     * Process the input file and write results to output file
     * @param inFile input file name
     * @param outFile output file name
     * @throws IOException
     */
    public static void processFile(String inFile, String outFile) throws IOException {
        Scanner in = new Scanner(new File(inFile));
        PrintWriter out = new PrintWriter(outFile);

        // Process each line of grades
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

                // letter grades
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
            out.println(); // blank line between records
            lineScan.close();
        }

        in.close();
        out.close();
    }
}

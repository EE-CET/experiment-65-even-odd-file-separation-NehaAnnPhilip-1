import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSeparator {
    public static void main(String[] args) {
        // Step 1: Read from numbers.txt and separate into even.txt and odd.txt
        try {
            // TODO: Initialize Scanner for numbers.txt
            Scanner reader = new Scanner(new File("numbers.txt"));
            
            // TODO: Initialize PrintWriter for even.txt and odd.txt
            PrintWriter evenWriter = new PrintWriter("even.txt");
            PrintWriter oddWriter = new PrintWriter("odd.txt");

            // TODO: Loop through the input file, check if numbers are even or odd, and write to respective files
            while (reader.hasNextInt()) {
                int num = reader.nextInt();
                if (num % 2 == 0) {
                    evenWriter.print(num + " ");
                } else {
                    oddWriter.print(num + " ");
                }
            }
            
            // TODO: Close all resources to save the files properly
            reader.close();
            evenWriter.close();
            oddWriter.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error processing files.");
            return;
        }

        // Step 2: Read and display even.txt
        System.out.print("Even File: ");
        try (Scanner evenReader = new Scanner(new File("even.txt"))) {
            while (evenReader.hasNext()) {
                System.out.print(evenReader.next() + (evenReader.hasNext() ? " " : ""));
            }
        } catch (FileNotFoundException e) {
            // Ignore if file doesn't exist
        }
        System.out.println();

        // Step 3: Read and display odd.txt
        System.out.print("Odd File: ");
        try (Scanner oddReader = new Scanner(new File("odd.txt"))) {
            while (oddReader.hasNext()) {
                System.out.print(oddReader.next() + (oddReader.hasNext() ? " " : ""));
            }
        } catch (FileNotFoundException e) {
            // Ignore if file doesn't exist
        }
        System.out.println();
    }
}

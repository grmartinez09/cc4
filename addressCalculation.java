/*INDIVIDUALLY look for OR create a Java program that computes the RMS address of the given. The given should be user inputs such as:

Number of Dimensions
Upper bound of each dimension
Address to look for in each  */
import java.util.Scanner;

public class addressCalculation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Base Address: ");
        int baseAddress = scanner.nextInt();
        System.out.print("Enter Weight: ");
        int weight = scanner.nextInt();
        System.out.print("Enter the number of dimensions: ");
        int numDimensions = scanner.nextInt();

        int[] upperBounds = new int[numDimensions];
        for (int i = 0; i < numDimensions; i++) {
            System.out.print("Enter the upper bound of dimension " + (i + 1) + ": ");
            upperBounds[i] = scanner.nextInt();
        }

        int[] index = new int[numDimensions];
        for (int i = 0; i < numDimensions; i++) {
            System.out.print("Enter the index of dimension " + (i + 1) + ": ");
            index[i] = scanner.nextInt();
            
        }
        scanner.close();

        int rms = computeRMS(baseAddress, weight, numDimensions, index, upperBounds);
        System.out.println("The RMS address is: " + rms);
    }

    private static int computeRMS(int baseAddress, int weight, int size, int[] index, int[] upperBounds) {
        int sum = 0;

        for (int i = 1; i <= size; i++) {
            int temp = index[i-1];
            for (int j = i; j < size; j++) {
                temp *= upperBounds[j];
            }
            sum += temp;
        }
        int rms = baseAddress + (weight * sum);
        return rms;
    }
}
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* This program uses a bubble sort.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-05-15
*/

public final class BubbleSort {
    /**
    * For style checker.
    *
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private BubbleSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        // Static void main will.
        // Declare list and variable.
        final ArrayList<String> inputList = new ArrayList<String>();
        String sortStr = "";

        try {
            // In this section of the code,
            // it will pick a file to collect data from.
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);

            // In this section,
            // the code must choose and create a file.
            // to print the output.
            // Output file.
            final FileWriter output = new FileWriter("output.txt");

            // While Loop.
            // While loo used to.
            // read each line of input file.
            while (scanInput.hasNextLine()) {
                try {
                    final String[] tempArr = scanInput.nextLine().split(" ");
                    final int numInts = tempArr.length - 1;
                    final int[] arrInt = new int[numInts];
                    // Convert to int.
                    for (int index = 0; index < numInts; index++) {
                        arrInt[index] = Integer.parseInt(tempArr[index]);
                    }
                    // In this section
                    // code will call the function.
                    final int[] sortedArr = bubble(arrInt, numInts);
                    sortStr = sortStr + Arrays.toString(sortedArr) + "\n";
                } catch (NumberFormatException err) {
                    sortStr = sortStr + "Error: " + err.getMessage() + "\n";
                }
            }

            // sortStr is used...
            // To write to output file.
            output.write(sortStr);
            System.out.println(sortStr);

            // The writer is closed.
            output.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * The bubble sort used by this function is recursive.
    *
    * @param listOfNum found in the file
    * @param length of an array
    * @return sorted the array
    */
    public static int[] bubble(int[] listOfNum, int length) {
        // Base case is used at
        // the end of array.
        if (length == 1) {
            return listOfNum;
        }

        // Just one pass through of the array.
        for (int element = 0; element < length - 1; element++) {
            // Verify the two nearby components.
            if (listOfNum[element] > listOfNum[element + 1]) {
                final int temp = listOfNum[element];
                listOfNum[element] = listOfNum[element + 1];
                listOfNum[element + 1] = temp;
            }
        }

        return bubble(listOfNum, length - 1);
    }
}

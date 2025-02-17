/* Module 5, Critical Thinking, Implementing Recursion to Provide a Product
 *
 * The program collects five numbers and provides the product
 * of all five numbers using recursive method.
 *
 */
import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Scanner object for input
        int[] numbers = new int[5]; //Array to store user's input

        //Loop to collect 5 integers
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int product = calculateProduct(numbers, 0);
        System.out.println("The product is: " + product);
    }

    // Recursive method to calculate the product of elements in the array
    private static int calculateProduct(int[] numbers, int index) {
        if (index >= numbers.length) {
            return 1;
        }

        // Recursive step: Multiply current element with the product of remaining elements
        return numbers[index] * calculateProduct(numbers, index + 1);
    }
}
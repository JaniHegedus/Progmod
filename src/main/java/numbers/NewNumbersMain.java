package numbers;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class NewNumbersMain {
    private static final Random RANDOM_GENERATOR = new Random(50);

    /**
     * Task 0: Update the project:
     *          - From menu: Git / "Update Project...", OR
     *          - In right upper corner: blue arrow, OR
     *          - Keyboard shortcut: Ctrl+T
     * In "Update the project" popup click on Ok button.
     */

    /**
     * Task 1: Create a main method.
     * Create a generateArray method to generate a 1-dimensional array: 1 2 3 4 5
     * Call this method and print the return value in main.
     */
    public static void main(String[] args) {
        int[] array = generateArray(true);

        System.out.println(array.length);

        System.out.println();

        for (int i = 0; i< array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println();

        for (int number : array) {
            System.out.println(number);
        }

        int[][] twoDimensionalArray = generateTwoDimensionalArray(false);

        System.out.println(twoDimensionalArray.length);
        System.out.println(twoDimensionalArray[0].length);

        System.out.println(twoDimensionalArray);

        ArrayList<Integer> list = generateList(true, 10);

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(4));
        System.out.println(list.contains(15));
        System.out.println(list.indexOf(15));
        print(list);
        separateEvenAndOdds(list);
    }

    public static int[] generateArray()
    {
        return generateArray(false);
    }

    public static int[] generateArray(boolean random)
    {
        int[] array = {1, 2, 3, 4, 5};
        if (random) {
            for (int i = 0; i < array.length; i++) {
                array[i] = RANDOM_GENERATOR.nextInt(100) - 50;
            }
        }
        return array;
    }

    /**
     * Task 2: Add a random parameter to generateArray method:
     * - If the value of random parameter is true,
     *   then return with a 5 element array filled with random numbers.
     * - If the value of random parameter is false,
     *   then return with the same array as before.
     * Hint: You can generate random numbers with Random objects.
     * Hint: Use nextInt(bound) method to get integers between 0 and bound value.
     * Call the method with true and false parameters and print the results in main.
     */

    /**
     * Task 3: Create a generateTwoDimensionalArray(random) method to generate a 2-dimensional array:
     * - If the value of random parameter is true,
     *   then return with a 2x3 array filled with random numbers.
     * - If the value of random parameter is false, then return with array of this matrix:
     *     1 2 3
     *     4 5 6
     * Call this method and print the return value in main.
     */
    public static int[][] generateTwoDimensionalArray(boolean random) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        if (random) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = RANDOM_GENERATOR.nextInt(100) - 50;
                }
            }
        }
        return array;
    }

    /**
     * Task 4: Create a generateList(random, length) method to generate
     * a 1-dimensional array with dynamic length.
     * - If the value of random parameter is true, then return with a list of random numbers.
     *   The length of this list has to match with length parameter.
     * - If the value of random parameter is false,
     *   then return with an array with the numbers from 1 to value of length parameter.
     * Hint: Use ArrayList.
     */
    public static @NotNull ArrayList<Integer> generateList(boolean random, int length) {
        ArrayList<Integer> result = new ArrayList<>();
        /*result.size();
        result.add(5);
        result.remove(0);
        result.contains(3);
        result.get(0);
        result.indexOf(5);*/
        if (random) {
            for (int i = 0; i < length; i++) {
                result.add(RANDOM_GENERATOR.nextInt(30));
            }
        } else {
            for (int i = 1; i <= length; i++) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * Task 5: Create a print method to print all element of a list parameter to the console.
     * For example: [1, 2, 3, 4, 5]
     * Extra: Create similar method for 1- and 2-dimensional arrays.
     */
    public static void print(@NotNull ArrayList<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Task 6: Create a selectEvenNumbers method, what return a subset of the list parameter.
     * The subset list has to contains all and only the even numbers.
     * Call this method in main and print a message with the length of subset list or
     * the static "There are no even number in the list" message.
     */
    public static @NotNull ArrayList<Integer> selectEvenNumbers(@NotNull ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int number : list) {
            if (number % 2 == 0) {
                result.add(number);
            }
        }
        return result;
    }

    /**
     * Task 7: Create an intersection method, what get 2 lists as parameters.
     * The method has to return with a list, what contains all and only those elements,
     * which is in both list parameters.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static @NotNull ArrayList<Integer> intersection(ArrayList<Integer> list1, @NotNull ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int number : list2) {
            if (list1.contains(number)) {
                result.add(number);
            }
        }
        return result;
    }

    /**
     * Task 8: Create a separateEvenAndOdds method, what create 2 sublist of the list parameter.
     * First sublist has to contains all and only the even numbers, and the second one
     * has to contains all and only the odd numbers.
     * Print to console:
     *     - sublist of even numbers
     *     - sublist of odd numbers
     *     - length of sublist of even numbers
     *     - length of sublist of odd numbers
     *     - length of original list
     * Hint: This method should have no return value, because you should print the values.
     */
    public static void separateEvenAndOdds(@NotNull ArrayList<Integer> list) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        for (int number : list) {
            if (number % 2 == 0){
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }
        print(evenNumbers);
        print(oddNumbers);
        System.out.println(evenNumbers.size());
        System.out.println(oddNumbers.size());
        System.out.println(list.size());
    }

    /**
     * Task 9: Create a numberOfOdds(array) method to count how many odd value is in a list.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     */
    public static int numberOfOdds(@NotNull ArrayList<Integer> array)
    {
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        for (int number : array) {
            if (number % 2 == 0)
            {
                //semmi
            }
            else {
                oddNumbers.add(number);
            }
        }
        return oddNumbers.size();
    }
    /**
     * Task 10: Create a contains(array, value) method to decide the value is in a list or not.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static boolean contains(@NotNull ArrayList<Integer> array, int value)
    {
        for (int number : array)
        {
            if(number==value) return true;
        }
        return false;
    }
    /**
     * Task 11: Create a sum(array) method to get the sum of values in a list.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static int sum(@NotNull ArrayList<Integer> array)
    {
        int sum=0;
        for (int number : array)
        {
            sum+=number;
        }
        return sum;
    }
    /**
     * Task 12: Create a indexOf(array, value) method to return the index of value in a list.
     * If the list does not contain the value, then return with -1.
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static int indexOf(@NotNull ArrayList<Integer> array, int value)
    {
        return array.indexOf(value);
    }
    /**
     * Task 13: Create a union method, what get 2 lists as parameters.
     * The method has to return with a list, what contains all elements of list parameters,
     * but it has to contain all elements only 1 time (eliminate the duplications).
     * Extra: Create same method for 1- and 2-dimensional arrays.
     * Extra: Create same method for lists and arrays with double values.
     */
    public static @NotNull ArrayList<Integer> union(@NotNull ArrayList<Integer> array0, ArrayList<Integer> array1)
    {
        ArrayList<Integer> All = new ArrayList<>();
        for (int number : array0)
        {
            All.add(number);
        }
        for (int number : array1)
        {
            All.add(number);
        }
        return All;
    }
}

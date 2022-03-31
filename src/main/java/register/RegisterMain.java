package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RegisterMain
{
    /**
     * Task 0: Update the project:
     *          - From menu: Git / "Update Project...", OR
     *          - In right upper corner: blue arrow, OR
     *          - Keyboard shortcut: Ctrl+T
     * In "Update the project" popup click on Ok button.
     */
    public static void main(String[] args) {
        int i = 5;
        System.out.println(i);
        System.out.println(i++);
        System.out.println(++i);

        User user = new User();
        User anotherUser = new User("Joe Doe", 2010, "Második utca 1");
        user.setName("John Doe");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String row = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        user.setName(scanner.nextLine());
        System.out.print("Please enter your year of birth: ");
        user.setBirthYear(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Please enter your address: ");
        user.setAddress(scanner.nextLine());

        System.out.println(user.getName());
        System.out.println(user.getBirthYear());
        System.out.println(user.getAddress());
        System.out.println(anotherUser.getName());
        System.out.println(anotherUser.getBirthYear());
        System.out.println(anotherUser.getAddress());
    }

    /**
     * Task 1: Create main method.
     * Hint: Use psvm in IntelliJ
     * More templates in File / Settings / Editor / Live Templates
     */

    /**
     * Task 2: Create a User class in register package.
     * The class should have 3 attributes: name, birthYear, address.
     * Implement a setter and a getter to each attributes.
     * Implement a constructor.
     * In main method read, store and print these data using standard input and output.
     * Hint: Use sout to print in IntelliJ
     * Hint: Use Scanner class to get user input. System.in is the standard input stream of console.
     * Create a method which tells the age of user in a given year.
     */

    /**
     * Task 3: Create a Song class in register package, which has a band, a title and a length attributes.
     * Please apply the information hiding rule.
     * When we create a new Song object, we should give its band, title and length.
     * Extend the main method to read, store and print data of a song using standard input and output.
     */

    /**
     * Task 4: Create a Note class in register package.
     * Note objects should have a name, a topic and a text attributes. Both of them should be String.
     * Please apply the information hiding rule.
     * Implement constructors to create:
     *  - Notes with name, topic and text.
     *  - Notes without name. In this case we should set the name to Anonymous.
     * Write a getNoteText method to return all data of a note in this format: name (topic): text.
     */

    /**
     * Task 5: Create a Book class in register package.
     * This class should have author, title and isbn attributes, both of them should be String.
     * Please apply the information hiding rule.
     * When we create a new Book object, we should give its author and title.
     * We need also a register method to assign an isbn number to it.
     */
}

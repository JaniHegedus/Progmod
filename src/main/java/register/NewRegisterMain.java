package register;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class NewRegisterMain {
    private static final String SEMICOLON = ";";

    /**
     * Task 0: Update the project:
     *          - From menu: Git / "Update Project...", OR
     *          - In right upper corner: blue arrow, OR
     *          - Keyboard shortcut: Ctrl+T
     * In "Update the project" popup click on Ok button.
     */

    /**
     * Task 1: Create a main method, where:
     *          - Create a new list of User objects.
     *          - Add 3 users to the list:
     *              - Tony Stark, 1970, 10880 Malibu Point, Malibu
     *              - Stephen Strange, 1930, 177A Bleecker Street, New York City
     *              - Steve Rogers, 1918, 569 Leaman Place, Brooklyn
     *          - Print the list
     *          - Remove Tony Stark from the list
     *          - Print the list
     *          - Add to the 2nd position a new user:
     *              - Peter Parker, 2001, 20 Ingram Street, New York
     *          - Print the list
     */
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User tony = new User("Tony Stark", 1970, "10880 Malibu Point, Malibu");
        users.add(tony);
        users.add(new User("Stephen Strange", 1930, "177A Bleecker Street, New York City"));
        users.add(new User("Steve Rogers", 1918, "569 Leaman Place, Brooklyn"));

        System.out.println(users);
        printList(users);

        System.out.println();

        //users.remove(tony);
        users.remove(0);

        System.out.println(users);
        printList(users);

        System.out.println();

        users.set(1, new User("Peter Parker", 2001, "20 Ingram Street, New York"));

        System.out.println(users);
        printList(users);

        writeUsersIntoFile(users, "src/main/resources/users.csv");

        System.out.println();

        ArrayList<User> users2 = readUsersFromFile("src/main/resources/users.csv");
        printList(users2);
    }

    /**
     * Task 2: Create a printList method to print the name of users in the list:
     * 1. Tony Stark
     * 2. Stephen Strange
     * 3. Steve Rogers
     * Use this method in main to print the list.
     */
    public static void printList(ArrayList<User> users) {
        for (User user : users) {
            System.out.println((users.indexOf(user) + 1) + ". " + user.getName());
        }
    }

    /**
     * Task 3: Create a writeUsersIntoFile method to save data of users into a file.
     * The method should get the list of users and the filepath.
     * Add a header to the file: Name;BirthYear;Address.
     * After the header write the name, year of birth and address data of users.
     * Each data of the same user should be separated by semicolon (';') character.
     * Data of users should be listed in separated rows.
     * Call the method with previously created list and "src/main/resources/users.csv" string as filepath.
     * Hint: Use BufferedWriter or FileOutputStream to write a file.
     * Hint: You should convert Strings to bytearrays with getBytes() method of String class.
     * Hint: Do not forget to add new line characters.
     * Hint: Create new method for repeating code snippets.
     */
    public static void writeUsersIntoFile(ArrayList<User> users, String filepath) {
        try {
            FileOutputStream writer = new FileOutputStream(filepath);
            writer.write("Name;BirthYear;Address\r\n".getBytes(StandardCharsets.UTF_8));
            String row = "";
            for (User user : users) {
                row = user.getName() + SEMICOLON + user.getBirthYear() + SEMICOLON +
                        user.getAddress() + "\r\n";
                writer.write(row.getBytes(StandardCharsets.UTF_8));
                /*
                writer.write(user.getName().getBytes(StandardCharsets.UTF_8));
                writer.write(SEMICOLON.getBytes(StandardCharsets.UTF_8));
                writer.write(user.getBirthYear());
                writer.write(SEMICOLON.getBytes(StandardCharsets.UTF_8));
                writer.write(user.getAddress().getBytes(StandardCharsets.UTF_8));
                writer.write("\r\n".getBytes(StandardCharsets.UTF_8));
                */
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeUsersIntoFileWithBufferedWriter(ArrayList<User> users, String filepath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            writer.write("Name;BirthYear;Address\r\n");
            for (int i = 0; i < users.size(); i++) {
                writer.write(users.get(i).getName() + SEMICOLON + users.get(i).getBirthYear() +
                                SEMICOLON + users.get(i).getAddress() + "\r\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Task 4: Create a readUsersFromFile method to read user's data from the file.
     * The method should return with the list of users.
     * Hint: Use BufferedReader or FileInputStream to read from a file.
     * Hint: Take care about the header row.
     */
    public static ArrayList<User> readUsersFromFile(String filepath) {
        ArrayList<User> users = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            reader.readLine(); //Read the header row
            String row;
            String[] data;
            while (reader.ready()) {
                row = reader.readLine();
                data = row.split(SEMICOLON);
                users.add(new User(data[0], Integer.parseInt(data[1]), data[2]));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


    public static ArrayList<User> readUsersFromFileWithFileInputStream(String filepath) {
        ArrayList<User> users = new ArrayList<>();
        try {
            FileInputStream reader = new FileInputStream(filepath);
            readHeader(reader);
            while (reader.available() > 0) {
                readUser(reader, users);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static void readHeader(FileInputStream inputStream) throws IOException {
        char character = ' ';
        while (character != '\n' && inputStream.available() > 0) {
            character = (char) inputStream.read();
        }
    }

    private static void readUser(FileInputStream inputStream, ArrayList<User> users) throws IOException {
        String name = readData(inputStream);
        String birthYear = readData(inputStream);
        String address = readData(inputStream);
        addUser(name, birthYear, address, users);
    }

    private static void addUser(String name, String birthYear, String address, ArrayList<User> users) {
        if (!name.isEmpty() && !birthYear.isEmpty() && !address.isEmpty()) {
            users.add(new User(name, Integer.parseInt(birthYear), address));
        }
    }

    private static String readData(FileInputStream inputStream) throws IOException {
        String data = "";
        char character = ' ';
        while (!isSeparator(character) && inputStream.available() > 0) {
            character = (char) inputStream.read();
            if (!isSeparator(character) && character != '\r') {
                data += character;
            }
        }
        return data;
    }

    private static boolean isSeparator(char character) {
        return character == '\n' || character == SEMICOLON.charAt(0);
    }

    /**
     * Task 5: Create similar reader and writer methods to read and write Song objects.
     */

    /**
     * Task 6: Create similar reader and writer methods to read and write Note objects.
     */

    /**
     * Task 7: Create similar reader and writer methods to read and write Book objects.
     */
}

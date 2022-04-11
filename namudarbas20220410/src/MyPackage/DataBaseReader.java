package MyPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseReader {
    private final String dbPath;


    public DataBaseReader(String dbPath) {
        this.dbPath = dbPath;
    }

    public User addUser(User user) throws IOException {
        ArrayList<User> addusers = getAllUsers();
            if (addusers.contains(user.getUsername())) {
                return null;
            }addToFile(user);
        return user;
        }

    public User getUser(String username, String password) throws FileNotFoundException {
        ArrayList<User> getusers = getAllUsers();
        for (User user: getusers){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                getusers.add(user);
            }
        }

        return null;
    }

    public ArrayList<User> getAllUsers() throws FileNotFoundException {
        File file = new File(dbPath);
        Scanner sc = new Scanner(file);
        ArrayList<User> users = new ArrayList<>();
        while (sc.hasNextLine()) {
            String username = sc.nextLine();
            String password = sc.nextLine();
            String role= sc.nextLine();
            String name = sc.nextLine();
            String surname = sc.nextLine();
            int age = sc.nextInt();
            sc.nextLine();
            sc.nextLine();
            users.add(new User(username, password, role, name, surname, age));
        }
        return users;
    }

    private void addToFile(User user) throws IOException {
        FileWriter fw = new FileWriter(dbPath, true);
        PrintWriter writer = new PrintWriter(fw);
        writer.println(user.getUsername());
        writer.println(user.getPassword());
        writer.println(user.getRole());
        writer.println(user.getName());
        writer.println(user.getSurname());
        writer.println(user.getAge());
        writer.println();
        writer.close();

    }

    public User removeFromFile(String username) throws IOException {
        ArrayList<User> users = getAllUsers();
        if (users.contains(username)) {
            users.remove(username);
            rewriteAllUsers(users);

        }
        return null;
    }

    private void rewriteAllUsers(ArrayList<User> users) throws IOException {
        FileWriter fw = new FileWriter(dbPath);
        PrintWriter writer = new PrintWriter(fw);
        for (User user : users) {
            writer.println(user.getUsername());
            writer.println(user.getPassword());
            writer.println(user.getRole());
            writer.println(user.getName());
            writer.println(user.getSurname());
            writer.println(user.getAge());
            writer.println();
        }
        writer.close();
    }
}

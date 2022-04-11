package MyPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Data data = new Data();
        DataBaseReader baseReader = new DataBaseReader("src/MyPackage/userData.txt");


        while (true) {

            printMenu();
            String userInput = sc.nextLine();

            switch (userInput) {
                case "1":
                    loginUser(sc, baseReader);
                    break;
                case "2":
                    addNewUser(sc, baseReader);

                    break;
                case "3":
                    return;

                default:
                    System.out.println("Neatpazinta ivestis, bandykite dar karta");
                    break;
            }

        }
    }

    private static void loginUser(Scanner sc, DataBaseReader data) throws IOException {
        System.out.print("Iveskite prisijungimo varda: ");
        String username = sc.nextLine();
        System.out.print("Iveskite slaptazodi: ");
        String password = sc.nextLine();
        User loginUsers = data.getUser(username, password);
        if (username.equals(loginUsers.getUsername()) && password.equals(loginUsers.getPassword())) {
            System.out.println("Jus esate sekmingai prijungtas");
            if (loginUsers.getRole().equals("ADMIN")){
                printAdminMenu();
            }  printUserMenu();
        }
    }
    { System.out.println("Tokio prisijungimo vardo ir/ar slaptazodzio nera");
            }
        private static void addNewUser (Scanner sc, DataBaseReader data) throws IOException {
            System.out.print("Iveskite prisijungimo varda: ");
            String newUsername = sc.nextLine();
            System.out.print("Iveskite slaptazodi: ");
            String newPassword = sc.nextLine();
            System.out.print("Iveskite role: ");
            String newRole = sc.nextLine();
            System.out.print("Iveskite varda: ");
            String newName = sc.nextLine();
            System.out.print("Iveskite pavarde: ");
            String newSurname = sc.nextLine();
            System.out.print("Iveskite amziu: ");
            int newAge = sc.nextInt();
            sc.nextLine();

            User user = data.addUser(new User(newUsername, newPassword, newRole, newName, newSurname, newAge));
            if (user == null) {
                System.out.println("Toks vartotojas jau egzistuoja");
            } else {
                System.out.println();
                System.out.println("***********************************");
                System.out.println("Vartotojas sekmingai uzregistruotas");
                System.out.println("***********************************");
                System.out.println();
            }


        }

        private static void removeUserFromFile (Scanner sc, DataBaseReader data) throws IOException {
            System.out.println("Iveskite vartotojo varda, kuri reikia istrinti: ");
            String usernameToRemove = sc.nextLine();
            User usernameRemove = data.removeFromFile(usernameToRemove);
            if (usernameRemove != null) {
                System.out.printf("Vartotojas %s\n istrintas", usernameRemove.getUsername());
            }
            System.out.println("Tokio vartotojo nerasta");
        }

        private static void printMenu () {
            System.out.println("[1] Prisijungti");
            System.out.println("[2] Registruotis");
            System.out.println("[3] EXIT");
        }

        private static void printAdminMenu () {
            System.out.println("[1] Perziureti savo informacija");
            System.out.println("[2] Perziureti visu vartotoju informacija");
            System.out.println("[3] Prideti nauja vartotoja");
            System.out.println("[4] Istrinti vartotoja");
            System.out.println("[5] Atsijungti");
        }

        private static void printUserMenu () {
            System.out.println("[1] Perziureti savo informacija");
            System.out.println("[2] Atsijungti");
        }

        private static void printUsers (ArrayList < User > users) throws IOException {
            for (User user : users) {
                System.out.printf("Vartotojo prisijungimo vardas: s%\n", user.getUsername());
                System.out.printf("Vartotojo vardas: s%\n", user.getName());
                System.out.printf("Vartotojo pavarde: s%\n", user.getSurname());
                System.out.printf("Vartotojo amzius: f%\n", user.getAge());
                if (user.getRole().equals("ADMIN")) {
                    System.out.printf("Vartotojo role: s%\n", user.getRole());
                }
            }
        }
//                    while (true) {
//        String adminInput = sc.nextLine();
//        switch (adminInput) {
//            case "1":
//                break;
//            case "2":
//                break;
//            case "3":
//                break;
//            case "4":
//                break;
//            case "5":
//                return;
//            default:
//                System.out.println("Neatpazinta ivestis, bandykite dar karta");
//                break;
//        }
//    }

        private static class Data {
        }
    }
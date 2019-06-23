package pl.codreslab.model.app;

import pl.codreslab.dao.GroupDao;
import pl.codreslab.model.User;
import pl.codreslab.dao.UserDao;

import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {


        GroupDao groupDao = new GroupDao();

    }

    private static void userOperations() {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        String line = "";
        while (!(line = scanner.nextLine()).equals("quit")) {
            userDao.allUsers();
            System.out.println("Wybierz jedną z opcji:\n" +
                    "add – dodanie użytkownika,\n" +
                    "edit – edycja użytkownika,\n" +
                    "delete – usunięcie użytkownika,\n" +
                    "quit – zakończenie programu.");
            switch (line) {
                case "add":
                    addingUser(scanner, userDao);
                    break;
                case "edit":
                    editUser(scanner, userDao);
                    break;
                case "delete":
                    deleteUser(scanner, userDao);
                    break;
                default:
                    System.out.println("Dokonałeś niepoprawnego wyboru!");
            }
            System.out.println("Wybierz jedną z opcji:\n" +
                    "add – dodanie użytkownika,\n" +
                    "edit – edycja użytkownika,\n" +
                    "delete – usunięcie użytkownika,\n" +
                    "quit – zakończenie programu.");
            scanner.nextLine();
        }
        scanner.close();
    }

    private static void deleteUser(Scanner scanner, UserDao userDao) {
        System.out.println("Podaj id użytkownika do usunięcia: ");
        int id = scanner.nextInt();
        userDao.delete(id);
    }

    private static void editUser(Scanner scanner, UserDao userDao) {
        System.out.println("Podaj username: ");
        String userName = scanner.nextLine();
        System.out.println("Podaj email: ");
        String email = scanner.nextLine();
        System.out.println("Podaj password: ");
        String password = scanner.nextLine();
        System.out.println("Podaj id użytkownika do zmiany: ");
        int id = scanner.nextInt();
        User user = new User(userName, email, password);
        user.setId(id);
        userDao.update(user);
    }

    private static void addingUser(Scanner scanner, UserDao userDao) {
        System.out.println("Podaj username: ");
        String userName = scanner.nextLine();
        System.out.println("Podaj email: ");
        String email = scanner.nextLine();
        System.out.println("Podaj password: ");
        String password = scanner.nextLine();
        User user = new User(userName, email, password);
        userDao.create(user);
    }
}
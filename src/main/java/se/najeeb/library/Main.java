package se.najeeb.library;

import se.najeeb.library.DAO.bookDAO;
import se.najeeb.library.DAO.loanDAO;
import se.najeeb.library.DAO.userDAO;
import se.najeeb.library.Modell.Book;
import se.najeeb.library.Modell.User;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public void main(String[] args) {
        Connection db = Database.getConnection();

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean running = true;

        while (running) {

            System.out.println("""
                    1. Ny Användare
                    2. Logga In
                    3. Låna Bok
                    4. Lämna Bok
                    5. Söka
                    6. Se dina lån
                    7. Avsluta program
                    Välj: """);

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Ogiltig inmatning");
            }

            switch (choice) {
                case 1:
                    System.out.println("Ny användare");
                    System.out.println("------------");

                    System.out.println("FirstName");
                    String firstName = sc.next();

                    System.out.println("LastName");
                    String lastName = sc.next();

                    System.out.println("E_Post");
                    String nyUserEPost = sc.next();

                    System.out.println("Password");
                    String password = sc.next();

                    User nyUser = new User (firstName, lastName, nyUserEPost, password);

                    userDAO.registerUser(nyUser);
                    break;

                case 2:
                    System.out.println("Ange E-post: ");
                    String loginEPost = sc.next();

                    System.out.println("Ange Lösenord: ");
                    String loginPassword = sc.next();

                    Login.User(loginEPost, loginPassword);
                    break;


                case 3:
                    System.out.println("Ange UserID: ");
                    int loanUserId = sc.nextInt();

                    System.out.println("Ange BookID: ");
                    int loanBookId = sc.nextInt();

                    loanDAO.createLoan(loanUserId, loanBookId);
                    break;

                case 4:
                    System.out.println("Ange UserID: ");
                    int returnUserId = sc.nextInt();

                    System.out.println("Ange BookID: ");
                    int returnBookId = sc.nextInt();

                    loanDAO.returnLoan(returnUserId, returnBookId, LocalDate.now());
                    break;

                case 5:
                    System.out.println("Sök efter titel eller författare: ");
                    sc.nextLine();
                    String keyword = sc.nextLine();

                    List<Book> results = bookDAO.searchByNameOrTitle(keyword);

                    if (results.isEmpty()) {
                        System.out.println("Tyvärr hittade ingen som matchade: " + keyword);
                    } else {
                        System.out.println("Sökresultat: ");
                        for (Book b : results) {
                            System.out.println(b.toString());
                        }
                    }

                case 6:
                    System.out.println("Ange UserId för att se dina lån: ");
                    int inputId = sc.nextInt();
                    sc.nextLine();

                    loanDAO.showAllLoans(inputId);
                    break;


                case 7:
                System.out.println("Avsluta program");
                running = false;
                break;

                default:
                    System.out.println("Ogiltig val");
            }
        }

    }

}
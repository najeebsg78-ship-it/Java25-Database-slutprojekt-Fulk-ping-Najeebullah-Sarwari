package se.najeeb.library.DAO;

import se.najeeb.library.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class loanDAO {
    public static void createLoan (int userId, int bookId) {

        Connection db = Database.getConnection();

        String sql = "INSERT INTO Loans (user_id, book_id, start_date) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = db.prepareStatement(sql)) {


            pstmt.setInt (1, userId);
            pstmt.setInt (2, bookId);
            pstmt.setDate (3, java.sql.Date.valueOf(LocalDate.now()));

            int rowInserted = pstmt.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("Loan lyckades: " + userId + "Lånade book " + bookId);
            } else {
                System.out.println("Loan misslyckades");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void returnLoan (int userId, int bookId, LocalDate endDate) {

        Connection db = Database.getConnection();

        String sql = "UPDATE Loans SET end_date = ? WHERE user_id = ? AND book_id = ?";

        try (PreparedStatement pstmt = db.prepareStatement(sql)) {

            pstmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()) );
            pstmt.setInt(2, userId);
            pstmt.setInt(3, bookId);

            int rowInserted = pstmt.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("Retur lyckades av UserID: " + userId + "BookID: " + bookId);
            } else {
                System.out.println("Retur misslyckades");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showAllLoans (int userId) {
        Connection db = Database.getConnection();

        String sql = "SELECT Users.f_name, Books.title, Loans.start_date " +
                "FROM Loans " +
                "JOIN Users ON Loans.user_id = Users.user_id " +
                "JOIN Books ON Loans.book_id = Books.book_id " +
                "WHERE Loans.user_id = ?";

        try (PreparedStatement pstmt = db.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("f_name");
                String title = rs.getString("title");
                String date = rs.getString("start_date");

                System.out.println(name + " har lånat " + title + " från och med: " + date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

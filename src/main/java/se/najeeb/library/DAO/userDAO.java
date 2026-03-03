package se.najeeb.library.DAO;

import se.najeeb.library.Database;
import se.najeeb.library.Modell.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userDAO {
    public static User registerUser (User newUser) {
        Connection db = Database.getConnection();

        String sql = "INSERT INTO Users (f_name, l_name, e_post, password) VALUES (?, ?, ?, ?)";

        try(PreparedStatement pstmt = db.prepareStatement(sql)) {

            pstmt.setString(1, newUser.getFirstName());
            pstmt.setString(2, newUser.getLastName());
            pstmt.setString(3, newUser.getePost());
            pstmt.setString(4, newUser.getPassword());

            int rowInverted = pstmt.executeUpdate();

            if (rowInverted > 0) {
                System.out.println("Ny användare skapades");
            } else {
                System.out.println("Misslyckades skapa ny användare");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }
}

package se.najeeb.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public static void User (String ePost, String password) {

        Connection db = Database.getConnection();

        String sql = "SELECT * FROM Users WHERE e_post = ? AND password = ?";

        try (PreparedStatement pstmt = db.prepareStatement(sql)) {

            pstmt.setString(1, ePost);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("inloggning lyckades! Välkommen " + rs.getString("f_name"));
            } else {
                System.out.println("fel lösenord eller epost");
            }


        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

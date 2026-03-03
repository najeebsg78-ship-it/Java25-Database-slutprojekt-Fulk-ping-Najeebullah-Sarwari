package se.najeeb.library.DAO;

import se.najeeb.library.Database;
import se.najeeb.library.Modell.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookDAO {
    public List<Book> searchByNameOrTitle (String search) {
      List<Book> bookList = new ArrayList<>();

      Connection db = Database.getConnection();

      String sql = "SELECT * FROM Books WHERE title LIKE = ? OR author LIKE = ?";

      try(PreparedStatement pstmt = db.prepareStatement(sql)) {

          pstmt.setString (1, "%" + search + "%");
          pstmt.setString (2, "%" + search + "%");

          ResultSet rs = pstmt.executeQuery();

          while (rs.next()) {
              Book b = new Book (
                      rs.getInt ("book_id"),
                      rs.getString ("author"),
                      rs.getString ("title"),
                      rs.getString ("type"),
                      rs.getString ("category")
              );
              bookList.add(b);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return bookList;
    }
}

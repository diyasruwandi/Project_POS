
package projectt2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konfig {


    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost/POS";
            String user = "root";
            String pass = "";

          try (Connection con = DriverManager.getConnection(url,user,pass)) {
            System.out.println("koneksi berhasil");
        } catch (SQLException e) {
            System.err.println("koneksi gagal" +e.getMessage());
        }
    }
    
}

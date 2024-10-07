
package dbkoneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class konfig {
    private static Connection konfig;
    public static Connection getkonfig(){
        if(konfig==null){
            try {
                String url = new String();
                String user = new String();
                String password = new String();
                url = "jdbc:mysql://localhost:3306/pos";
                user = "root";
                password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                konfig = DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {
                System.out.println("koneksi error");
            }
        }
        return konfig;
    }


//    public static void main(String[] args) {
//            String url = "jdbc:mysql://localhost:3306/pos/user";
//            String user = "root";
//            String pass = "";
//
//          try (Connection con = DriverManager.getConnection(url,user,pass)) {
//            System.out.println("koneksi berhasil");
//        } catch (SQLException e) {
//            System.err.println("koneksi gagal" +e.getMessage());
//        }
//    }
    
}

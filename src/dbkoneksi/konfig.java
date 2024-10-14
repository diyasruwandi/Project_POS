
package dbkoneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class konfig {
    private static Connection konfig;
    public static Connection getkonfig(){
        if(konfig==null){
            try {
//                String url = new String();
//                String user = new String();
//                String password = new String();
                String url = "jdbc:mysql://localhost:3306/pos";
                String user = "root";  
                String password = "";
//                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                konfig = DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {
                System.out.println("koneksi error:" + e.getMessage());
            }
        }
        return konfig;
        
        //baca data dari mysql
//        public static ResultSet read(String sql) throws SQLException{
//            ResultSet rs = null;
//            
//            try {
//                konfig = (Connection) getkonfig();
//                Statement st = konfig.createStatement();
//                st.executeQuery(sql);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, ex.toString());
//            }
//            return rs;
//        }
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

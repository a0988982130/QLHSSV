/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author admin
 */
public class Connect {
    public static Connection openConnection() throws ClassNotFoundException, SQLException {
       //driver
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       //khai báo chuỗi url
       //Laptop huy
//       String connectionURL = "jdbc:sqlserver://LAPTOP-A8DMS1GU\\SQLEXPRESS;database=Quan_ly_SV;portNumber=1433;encrypt=true;trustServerCertificate=true";
        //Laptop khoa
        String connectionURL = "jdbc:sqlserver://LAPTOP14\\SQLEXPRESS;database=Quan_ly_SV;portNumber=1433;encrypt=true;trustServerCertificate=true";
       //khai báo tk, mk
       String user = "sa";
       String password = "123";
       //thực hiện kết nối
       Connection conn = DriverManager.getConnection(connectionURL, user, password);
        if (conn != null) {
            System.out.println("Kết nối thành công");
        }
       return conn;
    }
        
}

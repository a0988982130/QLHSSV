/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.Connect;
import Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class AccountDAO {
    
     public Account checkLogIn(String user, String password)
            throws Exception
    {
        String sql = "select * from tblTaiKhoan where TenTaiKhoan = ? and MatKhau = ?";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, user);
            ps.setString(2, password);
            try(ResultSet rs = ps.executeQuery())
            {
                if(rs.next())
                {
                    Account ac = new Account();
                    ac.setUser(user);
                    ac.setRole(rs.getString("Quyen"));
                    return  ac;
                }
            }
        }
        return null;
    }   
     
     
     public Boolean updatePassword(Account ac) throws ClassNotFoundException, SQLException
     {
         String sql = "update tblTaiKhoan set MatKhau = ?, Quyen = ? where TenTaiKhoan = ?";
         try 
         (
             Connection con = Connect.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
                    
         )
         {
             ps.setString(3, ac.getUser());
             ps.setString(1, ac.getPassword());
             ps.setString(2, ac.getRole());
            
             return ps.executeUpdate() > 0;
         }
     }
}

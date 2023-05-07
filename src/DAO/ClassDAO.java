/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author khoa2
 */

import DB.Connect;
import Model.Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    public boolean insert(Class lop)
            throws Exception
    {
        String sql = "insert into tblLop (Ma_Lop, Ten_Lop) "
                            + "values ( ?, ?)";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(1, lop.getMa_Lop());
            pstmt.setString(2, lop.getTen_Lop());
         
            return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean update(Class lop)
            throws Exception
    {
        String sql = "update tblLop set Ten_Lop = ? where Ma_Lop = ?";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(2, lop.getMa_Lop());
            pstmt.setString(1, lop.getTen_Lop());
         
            return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean delete(String Ma_Lop)
            throws Exception
    {
        String sql = "delete from tblLop where Ma_Lop = ?";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(1, Ma_Lop);
         
            return pstmt.executeUpdate()>0;
        }
    }
    
    public Class findByMa_Lop(String Ma_Lop)
            throws Exception
    {
        String sql = "select *  from tblLop where Ma_Lop = ?";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(1, Ma_Lop);
            try(ResultSet rs = pstmt.executeQuery();)
            {
                if(rs.next())
                {
                    Class lop = createLop(rs);
                    return lop;
                }
            }
            return null;
        }
    }

    private Class createLop(final ResultSet rs) throws SQLException {
        Class lop = new Class();
        lop.setMa_Lop(rs.getString("Ma_Lop"));
        lop.setTen_Lop(rs.getString("Ten_Lop"));
        
        return lop;
    }
    
    public List<Class> findAll()
            throws Exception
    {
        String sql = "select *  from tblLop";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            try(ResultSet rs = pstmt.executeQuery();)
            {
                List<Class> list = new ArrayList<>();
                while(rs.next())
                {
                    Class lop = createLop(rs);
                    list.add(lop);
                }
                return list;
            }
        }
    }
}

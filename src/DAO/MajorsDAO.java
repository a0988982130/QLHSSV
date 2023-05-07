/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DB.Connect;
import Model.Majors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author khoa2
 */
public class MajorsDAO {
    public boolean insert(Majors nganh)
            throws Exception
    {
        String sql = "insert into tblNganh (Ma_Nganh, Ten_Nganh) "
                            + "values ( ?, ?)";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(1, nganh.getMa_Nganh());
            pstmt.setString(2, nganh.getTen_Nganh());
         
            return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean update(Majors nganh)
            throws Exception
    {
        String sql = "update tblNganh set Ten_Nganh = ? where Ma_Nganh = ? ";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(2, nganh.getMa_Nganh());
            pstmt.setString(1, nganh.getTen_Nganh());
         
            return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean delete(String Ma_Nganh)
            throws Exception
    {
        String sql = "delete from tblNganh where Ma_Nganh = ?";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(1, Ma_Nganh);
         
            return pstmt.executeUpdate()>0;
        }
    }
    
    public Majors findByMa_Nganh(String Ma_Nganh)
            throws Exception
    {
        String sql = "select *  from tblNganh where Ma_Nganh = ?";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(1, Ma_Nganh);
            try(ResultSet rs = pstmt.executeQuery();)
            {
                if(rs.next())
                {
                    Majors nganh = createNganh(rs);
                    return nganh;
                }
            }
            return null;
        }
    }

    private Majors createNganh(final ResultSet rs) throws SQLException {
        Majors nganh = new Majors();
        nganh.setMa_Nganh(rs.getString("Ma_Nganh"));
        nganh.setTen_Nganh(rs.getString("Ten_Nganh"));
        
        return nganh;
    }
    
    public List<Majors> findAll()
            throws Exception
    {
        String sql = "select *  from tblNganh";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            try(ResultSet rs = pstmt.executeQuery();)
            {
                List<Majors> list = new ArrayList<>();
                while(rs.next())
                {
                    Majors nganh = createNganh(rs);
                    list.add(nganh);
                }
                return list;
            }
        }
    }  
}

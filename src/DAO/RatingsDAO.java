
package DAO;

import DB.Connect;
import Model.Ratings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingsDAO {
    public Boolean insert(Ratings ratings) throws ClassNotFoundException, SQLException
    {
        String sql = "insert into tblXepHang (Ma_SV,Ho_Ten,Ma_KH,Nam_Hoc,Hoc_Ky,Xep_Loai)"
                + "values(?,?,?,?,?,?)";
        try (
                Connection con = Connect.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                
            )
        {
            ps.setString(1, ratings.getMaSV());
            ps.setString(2, ratings.getHoTen());
            ps.setString(3, ratings.getMaKH());
            ps.setString(4, ratings.getNamHoc());
            ps.setString(5, ratings.getHocKy());
            ps.setString(6, ratings.getXepLoai());
            
            return ps.executeUpdate() > 0;
        }
    }
    
    public Boolean update(Ratings ratings) throws SQLException, ClassNotFoundException {
        String sql = "update tblXepHang "
                + "set Ho_Ten = ?, Ma_KH = ?, Nam_Hoc = ?, Xep_Loai = ?"
                + "where Ma_SV = ? and Hoc_Ky = ?";
        try (
                Connection con = Connect.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
            )
        {
            ps.setString(5, ratings.getMaSV());
            ps.setString(1, ratings.getHoTen());
            ps.setString(2, ratings.getMaKH());
            ps.setString(3, ratings.getNamHoc());
            ps.setString(6, ratings.getHocKy());
            ps.setString(4, ratings.getXepLoai());
            
            return ps.executeUpdate() > 0;
        }
    }
    
    public Boolean delete(Ratings ratings) throws ClassNotFoundException, SQLException, SQLException, SQLException, SQLException{
        String sql = "delete from tblXepHang where Ma_SV = ? and Hoc_Ky = ?";
        try (
                Connection con = Connect.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
            )
        {
            ps.setString(1, ratings.getMaSV());
            ps.setString(2, ratings.getHocKy());
            
            return ps.executeUpdate() > 0;
        }
    }
    
        public Ratings findByMa_SV(String Ma_SV)
            throws Exception
    {
        String sql = "select *  from tblXepHang where Ma_SV = ?";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, Ma_SV);
            try(ResultSet rs = ps.executeQuery();)
            {
                if(rs.next())
                {
                    Ratings ratings = createXepHang(rs);
                    return ratings;
                }
            }
            return null;
        }
    }
    
    public Ratings findByMa(String Ma_SV, String Nam_Hoc, String Hoc_Ky)
            throws Exception
    {
        String sql = "select *  from tblXepHang where Ma_SV = ? and Nam_Hoc = ? and Hoc_Ky = ?";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, Ma_SV);
            ps.setString(2, Nam_Hoc);
            ps.setString(3, Hoc_Ky);
            try(ResultSet rs = ps.executeQuery();)
            {
                if(rs.next())
                {
                    Ratings ratings = createXepHang(rs);
                    return ratings;
                }
            }
            return null;
        }
    }

    private Ratings createXepHang(final ResultSet rs) throws SQLException {
        Ratings ratings = new Ratings();
        ratings.setMaSV(rs.getString("Ma_SV"));
        ratings.setHoTen(rs.getString("Ho_Ten"));
        ratings.setMaKH(rs.getString("Ma_KH"));
        ratings.setNamHoc(rs.getString("Nam_Hoc"));
        ratings.setHocKy(rs.getString("Hoc_Ky"));
        ratings.setXepLoai(rs.getString("Xep_Loai"));
        
        return ratings;
    }
    
    public List<Ratings> findAll()
            throws Exception
    {
        String sql = "select *  from tblXepHang";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            try(ResultSet rs = ps.executeQuery();)
            {
                List<Ratings> list = new ArrayList<>();
                while(rs.next())
                {
                    Ratings ratings = createXepHang(rs);
                    list.add(ratings);
                }
                return list;
            }
        }
    }

    public boolean delete(String toString, String toString0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

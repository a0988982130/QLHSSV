/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.Connect;
import Model.Training;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author khoa2
 */
public class TrainingDAO {
    public boolean insert(Training daotao) throws Exception
    {
        String sql = "insert into tblThongTinDaoTao (Ma_SV, Ho_Ten, Ma_HeDT, Ma_KH, Ma_Lop, Ma_Nganh, Trang_Thai)"
                +"values (?, ?, ?, ?, ?, ?, ?)";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(1, daotao.getMa_SV());
            pstmt.setString(2, daotao.getHo_Ten());
            pstmt.setString(3, daotao.getMa_HeDT());
            pstmt.setString(4, daotao.getMa_KH());
            pstmt.setString(5, daotao.getMa_Lop());
            pstmt.setString(6, daotao.getMa_Nganh());
            pstmt.setString(7, daotao.getTrang_Thai());
            
            return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean update(Training daotao) throws Exception
    {
        String sql = "update tblThongTinDaoTao set Ho_Ten = ?, Ma_HeDT = ?, Ma_KH = ?, Ma_Lop = ?, Ma_Nganh = ?, Trang_Thai = ? where Ma_SV = ?";
               
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(7, daotao.getMa_SV());
            pstmt.setString(1, daotao.getHo_Ten());
            pstmt.setString(2, daotao.getMa_HeDT());
            pstmt.setString(3, daotao.getMa_KH());
            pstmt.setString(4, daotao.getMa_Lop());
            pstmt.setString(5, daotao.getMa_Nganh());
            pstmt.setString(6, daotao.getTrang_Thai());
            
            return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean delete(String Ma_SV) throws Exception
    {
        String sql = "delete from tblThongTinDaoTao where Ma_SV = ?";
        try
        (
                Connection con = Connect.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(1, Ma_SV);
            
            return pstmt.executeUpdate()>0;
        }
    }
    
    public Training findByMa_SV(String Ma_SV)
            throws Exception
    {
        String sql = "select *  from tblThongTinDaoTao where Ma_SV = ?";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            pstmt.setString(1, Ma_SV);
            try(ResultSet rs = pstmt.executeQuery();)
            {
                if(rs.next())
                {
                    Training daotao = createThongTinDaoTao(rs);
                    return daotao;
                }
            }
            return null;
        }
    }

    private Training createThongTinDaoTao(final ResultSet rs) throws SQLException {
        Training daotao = new Training();
        daotao.setMa_SV(rs.getString("Ma_SV"));
        daotao.setHo_Ten(rs.getString("Ho_Ten"));
        daotao.setMa_HeDT(rs.getString("Ma_HeDT"));
        daotao.setMa_KH(rs.getString("Ma_KH"));
        daotao.setMa_Lop(rs.getString("Ma_Lop"));
        daotao.setMa_Nganh(rs.getString("Ma_Nganh"));
        daotao.setTrang_Thai(rs.getString("Trang_Thai"));
        
        return daotao;
    }
    
    public List<Training> findAll()
            throws Exception
    {
        String sql = "select *  from tblThongTinDaoTao";
        try
        (
            Connection con = Connect.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        )
        {
            try(ResultSet rs = pstmt.executeQuery();)
            {
                List<Training> list = new ArrayList<>();
                while(rs.next())
                {
                    Training daotao = createThongTinDaoTao(rs);
                    list.add(daotao);
                }
                return list;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin
 */
public class Ratings {
    private String maSV;
    private String hoTen;
    private String maKH;
    private String namHoc;
    private String hocKy;
    private String xepLoai;

    public Ratings() {
    }

    public Ratings(String maSV, String hoTen, String maKH, String namHoc, String hocKy, String xepLoai) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.maKH = maKH;
        this.namHoc = namHoc;
        this.hocKy = hocKy;
        this.xepLoai = xepLoai;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }
    
}

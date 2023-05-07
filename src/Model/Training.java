/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author khoa2
 */
public class Training {
    private String Ma_SV, Ho_Ten, Ma_HeDT, Ma_KH, Ma_Lop, Ma_Nganh, Trang_Thai;

    public Training() {
    }

    public Training(String Ma_SV, String Ho_Ten, String Ma_HeDT, String Ma_KH, String Ma_Lop, String Ma_Nganh, String Trang_Thai) {
        this.Ma_SV = Ma_SV;
        this.Ho_Ten = Ho_Ten;
        this.Ma_HeDT = Ma_HeDT;
        this.Ma_KH = Ma_KH;
        this.Ma_Lop = Ma_Lop;
        this.Ma_Nganh = Ma_Nganh;
        this.Trang_Thai = Trang_Thai;
    }

    public String getMa_SV() {
        return Ma_SV;
    }

    public void setMa_SV(String Ma_SV) {
        this.Ma_SV = Ma_SV;
    }

    public String getHo_Ten() {
        return Ho_Ten;
    }

    public void setHo_Ten(String Ho_Ten) {
        this.Ho_Ten = Ho_Ten;
    }

    public String getMa_HeDT() {
        return Ma_HeDT;
    }

    public void setMa_HeDT(String Ma_HeDT) {
        this.Ma_HeDT = Ma_HeDT;
    }

    public String getMa_KH() {
        return Ma_KH;
    }

    public void setMa_KH(String Ma_KH) {
        this.Ma_KH = Ma_KH;
    }

    public String getMa_Lop() {
        return Ma_Lop;
    }

    public void setMa_Lop(String Ma_Lop) {
        this.Ma_Lop = Ma_Lop;
    }

    public String getMa_Nganh() {
        return Ma_Nganh;
    }

    public void setMa_Nganh(String Ma_Nganh) {
        this.Ma_Nganh = Ma_Nganh;
    }

    public String getTrang_Thai() {
        return Trang_Thai;
    }

    public void setTrang_Thai(String Trang_Thai) {
        this.Trang_Thai = Trang_Thai;
    }    
    
}

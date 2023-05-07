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
public class Class {
    private String Ma_Lop, Ten_Lop;

    public Class() {
    }

    public Class(String Ma_Lop, String Ten_Lop) {
        this.Ma_Lop = Ma_Lop;
        this.Ten_Lop = Ten_Lop;
    }

    public String getMa_Lop() {
        return Ma_Lop;
    }

    public void setMa_Lop(String Ma_Lop) {
        this.Ma_Lop = Ma_Lop;
    }

    public String getTen_Lop() {
        return Ten_Lop;
    }

    public void setTen_Lop(String Ten_Lop) {
        this.Ten_Lop = Ten_Lop;
    }
    
}

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
public class Majors {
    private String Ma_Nganh, Ten_Nganh;

    public Majors() {
    }

    public Majors(String Ma_Nganh, String Ten_Nganh) {
        this.Ma_Nganh = Ma_Nganh;
        this.Ten_Nganh = Ten_Nganh;
    }

    public String getMa_Nganh() {
        return Ma_Nganh;
    }

    public void setMa_Nganh(String Ma_Nganh) {
        this.Ma_Nganh = Ma_Nganh;
    }

    public String getTen_Nganh() {
        return Ten_Nganh;
    }

    public void setTen_Nganh(String Ten_Nganh) {
        this.Ten_Nganh = Ten_Nganh;
    }
}

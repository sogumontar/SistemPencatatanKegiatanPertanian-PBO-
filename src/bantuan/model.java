/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bantuan;

/**
 *
 * @author DedekManisTasBiru
 */
public class model {

    private int no;
    private String jenisBantuan;
    private String deskripsi;
    private String jenisTanaman;

    public model(int no,String jenisBantuan, String deskripsi, String jenisTanaman) {
        this.no=no;
        this.jenisBantuan = jenisBantuan;
        this.deskripsi = deskripsi;
        this.jenisTanaman = jenisTanaman;
    }

    public String getJenisBantuan() {
        return jenisBantuan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getJenisTanaman() {
        return jenisTanaman;
    }

    public void setJenisBantuan(String jenisBantuan) {
        this.jenisBantuan = jenisBantuan;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setJenisTanaman(String jenisTanaman) {
        this.jenisTanaman = jenisTanaman;
    }

}

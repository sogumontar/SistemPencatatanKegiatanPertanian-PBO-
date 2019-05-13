/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpembibitan;

import java.util.Date;

/**
 *
 * @author DedekManisTasBiru
 */
public class model {
    private String jenis;
    private String tanggalMulai;
    private String tanggalSelesai;
    private String lokasi;
    private String metode;
    private String Status;
    private Double ukuran;
    int no;
    int id;

    public model(int id,int no,String jenis, String tanggalMulai, String tanggalSelesai, String lokasi, String metode, String Status, Double ukuran) {
        this.id=id;
        this.no=no;
        this.jenis = jenis;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.lokasi = lokasi;
        this.metode = metode;
        this.Status = Status;
        this.ukuran = ukuran;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public int getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getMetode() {
        return metode;
    }

    public String getStatus() {
        return Status;
    }

    public Double getUkuran() {
        return ukuran;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setUkuran(Double ukuran) {
        this.ukuran = ukuran;
    }
    
}

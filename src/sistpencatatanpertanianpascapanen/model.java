/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpascapanen;

/**
 *
 * @author DedekManisTasBiru
 */
public class model {
    int no;
    Double ukuran;
    String jenis;
    String tanggal;
    String deskripsi;
    int banyak;
    String lokasi;
    String metode;
    int harga;
    int quantity;
    String status;

    public model(int no, Double ukuran, String jenis, String tanggal, String deskripsi, int banyak, String lokasi, String metode, int harga, int quantity, String status) {
        this.no = no;
        this.ukuran = ukuran;
        this.jenis = jenis;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.banyak = banyak;
        this.lokasi = lokasi;
        this.metode = metode;
        this.harga = harga;
        this.quantity = quantity;
        this.status = status;
    }

    public int getNo() {
        return no;
    }

    public Double getUkuran() {
        return ukuran;
    }

    public String getJenis() {
        return jenis;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getBanyak() {
        return banyak;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getMetode() {
        return metode;
    }

    public int getHarga() {
        return harga;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setUkuran(Double ukuran) {
        this.ukuran = ukuran;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
           
}

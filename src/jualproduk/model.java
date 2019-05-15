/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jualproduk;

/**
 *
 * @author DedekManisTasBiru
 */
public class model {
    private int id;
    private int no;
    private String nama_produk;
    private  int jumlah;
    private int harga;
    private int id_akun;
    private String deskripsi;
    private String status;
    private String gambar;

    public model(int no,String nama_produk, int jumlah, int harga, String deskripsi, String status) {
        this.no=no;
        this.nama_produk = nama_produk;
        this.jumlah = jumlah;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.status = status;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public int getId_akun() {
        return id_akun;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setId_akun(int id_akun) {
        this.id_akun = id_akun;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
    
    
    
}

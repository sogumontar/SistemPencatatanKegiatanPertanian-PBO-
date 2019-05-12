/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpemupukan;

/**
 *
 * @author DedekManisTasBiru
 */
public class model {
    public int no;
    public Double ukuran;
    public String jenis;
    public String tanggalMulai;
    public String tanggalSelesai;
    public String Deskripsi;
    public String lokasi;
    public String metode;
    public String pupuk;
    public int banyak;
    public String gambar;

    public model(int no, Double ukuran, String jenis, String tanggalMulai, String tanggalSelesai, String Deskripsi, String lokasi, String metode, String pupuk, int banyak, String gambar) {
        this.no = no;
        this.ukuran = ukuran;
        this.jenis = jenis;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.Deskripsi = Deskripsi;
        this.lokasi = lokasi;
        this.metode = metode;
        this.pupuk = pupuk;
        this.banyak = banyak;
        this.gambar = gambar;
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

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getMetode() {
        return metode;
    }

    public String getPupuk() {
        return pupuk;
    }

    public int getBanyak() {
        return banyak;
    }

    public String getGambar() {
        return gambar;
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

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public void setDeskripsi(String Deskripsi) {
        this.Deskripsi = Deskripsi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public void setPupuk(String pupuk) {
        this.pupuk = pupuk;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
    
    
}

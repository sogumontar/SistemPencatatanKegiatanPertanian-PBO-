package entity;
// Generated May 15, 2019 9:13:58 PM by Hibernate Tools 4.3.1



/**
 * Penanaman generated by hbm2java
 */
public class Penanaman  implements java.io.Serializable {


     private Integer id;
     private Akun akun;
     private String createdAt;
     private Double ukuranLahan;
     private String jenisTanaman;
     private String jenisBibit;
     private String tanggalMulaiPemupukan;
     private String tanggalSelesaiPemupukan;
     private String deskripsiTanaman;
     private String lokasi;
     private String caraPenanaman;
     private String status;
     private String bookedStatus;
     private String gambar;

    public Penanaman() {
    }

    public Penanaman(Akun akun, String createdAt, Double ukuranLahan, String jenisTanaman, String jenisBibit, String tanggalMulaiPemupukan, String tanggalSelesaiPemupukan, String deskripsiTanaman, String lokasi, String caraPenanaman, String status, String bookedStatus, String gambar) {
       this.akun = akun;
       this.createdAt = createdAt;
       this.ukuranLahan = ukuranLahan;
       this.jenisTanaman = jenisTanaman;
       this.jenisBibit = jenisBibit;
       this.tanggalMulaiPemupukan = tanggalMulaiPemupukan;
       this.tanggalSelesaiPemupukan = tanggalSelesaiPemupukan;
       this.deskripsiTanaman = deskripsiTanaman;
       this.lokasi = lokasi;
       this.caraPenanaman = caraPenanaman;
       this.status = status;
       this.bookedStatus = bookedStatus;
       this.gambar = gambar;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Akun getAkun() {
        return this.akun;
    }
    
    public void setAkun(Akun akun) {
        this.akun = akun;
    }
    public String getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public Double getUkuranLahan() {
        return this.ukuranLahan;
    }
    
    public void setUkuranLahan(Double ukuranLahan) {
        this.ukuranLahan = ukuranLahan;
    }
    public String getJenisTanaman() {
        return this.jenisTanaman;
    }
    
    public void setJenisTanaman(String jenisTanaman) {
        this.jenisTanaman = jenisTanaman;
    }
    public String getJenisBibit() {
        return this.jenisBibit;
    }
    
    public void setJenisBibit(String jenisBibit) {
        this.jenisBibit = jenisBibit;
    }
    public String getTanggalMulaiPemupukan() {
        return this.tanggalMulaiPemupukan;
    }
    
    public void setTanggalMulaiPemupukan(String tanggalMulaiPemupukan) {
        this.tanggalMulaiPemupukan = tanggalMulaiPemupukan;
    }
    public String getTanggalSelesaiPemupukan() {
        return this.tanggalSelesaiPemupukan;
    }
    
    public void setTanggalSelesaiPemupukan(String tanggalSelesaiPemupukan) {
        this.tanggalSelesaiPemupukan = tanggalSelesaiPemupukan;
    }
    public String getDeskripsiTanaman() {
        return this.deskripsiTanaman;
    }
    
    public void setDeskripsiTanaman(String deskripsiTanaman) {
        this.deskripsiTanaman = deskripsiTanaman;
    }
    public String getLokasi() {
        return this.lokasi;
    }
    
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    public String getCaraPenanaman() {
        return this.caraPenanaman;
    }
    
    public void setCaraPenanaman(String caraPenanaman) {
        this.caraPenanaman = caraPenanaman;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getBookedStatus() {
        return this.bookedStatus;
    }
    
    public void setBookedStatus(String bookedStatus) {
        this.bookedStatus = bookedStatus;
    }
    public String getGambar() {
        return this.gambar;
    }
    
    public void setGambar(String gambar) {
        this.gambar = gambar;
    }




}



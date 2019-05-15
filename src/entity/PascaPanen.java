package entity;
// Generated May 15, 2019 9:13:58 PM by Hibernate Tools 4.3.1



/**
 * PascaPanen generated by hbm2java
 */
public class PascaPanen  implements java.io.Serializable {


     private Integer id;
     private Akun akun;
     private String createdAt;
     private Double ukuranLalhan;
     private String jenisTanaman;
     private String tanggalMulaiPanen;
     private String tanggalSelesaiPanen;
     private String deskripsiTanaman;
     private Integer banyakHasilPanen;
     private String lokasi;
     private String caraPanen;
     private Integer harga;
     private Integer quantity;
     private String status;
     private String bookedStatus;
     private String gambar;

    public PascaPanen() {
    }

    public PascaPanen(Akun akun, String createdAt, Double ukuranLalhan, String jenisTanaman, String tanggalMulaiPanen, String tanggalSelesaiPanen, String deskripsiTanaman, Integer banyakHasilPanen, String lokasi, String caraPanen, Integer harga, Integer quantity, String status, String bookedStatus, String gambar) {
       this.akun = akun;
       this.createdAt = createdAt;
       this.ukuranLalhan = ukuranLalhan;
       this.jenisTanaman = jenisTanaman;
       this.tanggalMulaiPanen = tanggalMulaiPanen;
       this.tanggalSelesaiPanen = tanggalSelesaiPanen;
       this.deskripsiTanaman = deskripsiTanaman;
       this.banyakHasilPanen = banyakHasilPanen;
       this.lokasi = lokasi;
       this.caraPanen = caraPanen;
       this.harga = harga;
       this.quantity = quantity;
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
    public Double getUkuranLalhan() {
        return this.ukuranLalhan;
    }
    
    public void setUkuranLalhan(Double ukuranLalhan) {
        this.ukuranLalhan = ukuranLalhan;
    }
    public String getJenisTanaman() {
        return this.jenisTanaman;
    }
    
    public void setJenisTanaman(String jenisTanaman) {
        this.jenisTanaman = jenisTanaman;
    }
    public String getTanggalMulaiPanen() {
        return this.tanggalMulaiPanen;
    }
    
    public void setTanggalMulaiPanen(String tanggalMulaiPanen) {
        this.tanggalMulaiPanen = tanggalMulaiPanen;
    }
    public String getTanggalSelesaiPanen() {
        return this.tanggalSelesaiPanen;
    }
    
    public void setTanggalSelesaiPanen(String tanggalSelesaiPanen) {
        this.tanggalSelesaiPanen = tanggalSelesaiPanen;
    }
    public String getDeskripsiTanaman() {
        return this.deskripsiTanaman;
    }
    
    public void setDeskripsiTanaman(String deskripsiTanaman) {
        this.deskripsiTanaman = deskripsiTanaman;
    }
    public Integer getBanyakHasilPanen() {
        return this.banyakHasilPanen;
    }
    
    public void setBanyakHasilPanen(Integer banyakHasilPanen) {
        this.banyakHasilPanen = banyakHasilPanen;
    }
    public String getLokasi() {
        return this.lokasi;
    }
    
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    public String getCaraPanen() {
        return this.caraPanen;
    }
    
    public void setCaraPanen(String caraPanen) {
        this.caraPanen = caraPanen;
    }
    public Integer getHarga() {
        return this.harga;
    }
    
    public void setHarga(Integer harga) {
        this.harga = harga;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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



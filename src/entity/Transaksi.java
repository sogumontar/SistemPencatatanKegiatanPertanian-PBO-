package entity;
// Generated May 15, 2019 9:13:58 PM by Hibernate Tools 4.3.1



/**
 * Transaksi generated by hbm2java
 */
public class Transaksi  implements java.io.Serializable {


     private Integer id;
     private Akun akun;
     private Integer hargaTotal;
     private Integer tanamanId;
     private String createdAt;

    public Transaksi() {
    }

    public Transaksi(Akun akun, Integer hargaTotal, Integer tanamanId, String createdAt) {
       this.akun = akun;
       this.hargaTotal = hargaTotal;
       this.tanamanId = tanamanId;
       this.createdAt = createdAt;
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
    public Integer getHargaTotal() {
        return this.hargaTotal;
    }
    
    public void setHargaTotal(Integer hargaTotal) {
        this.hargaTotal = hargaTotal;
    }
    public Integer getTanamanId() {
        return this.tanamanId;
    }
    
    public void setTanamanId(Integer tanamanId) {
        this.tanamanId = tanamanId;
    }
    public String getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }




}



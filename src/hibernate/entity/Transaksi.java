package hibernate.entity;
// Generated May 3, 2019 9:07:01 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Transaksi generated by hbm2java
 */
public class Transaksi  implements java.io.Serializable {


     private Integer id;
     private Date createdAt;
     private Integer idAkun;
     private Integer idTanaman;
     private Integer harga;

    public Transaksi() {
    }

    public Transaksi(Date createdAt, Integer idAkun, Integer idTanaman, Integer harga) {
       this.createdAt = createdAt;
       this.idAkun = idAkun;
       this.idTanaman = idTanaman;
       this.harga = harga;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Integer getIdAkun() {
        return this.idAkun;
    }
    
    public void setIdAkun(Integer idAkun) {
        this.idAkun = idAkun;
    }
    public Integer getIdTanaman() {
        return this.idTanaman;
    }
    
    public void setIdTanaman(Integer idTanaman) {
        this.idTanaman = idTanaman;
    }
    public Integer getHarga() {
        return this.harga;
    }
    
    public void setHarga(Integer harga) {
        this.harga = harga;
    }




}


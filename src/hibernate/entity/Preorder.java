package hibernate.entity;
// Generated May 3, 2019 9:07:01 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Preorder generated by hbm2java
 */
public class Preorder  implements java.io.Serializable {


     private Integer id;
     private Integer idAkun;
     private Integer idTanaman;
     private Date createdAt;
     private String status;

    public Preorder() {
    }

    public Preorder(Integer idAkun, Integer idTanaman, Date createdAt, String status) {
       this.idAkun = idAkun;
       this.idTanaman = idTanaman;
       this.createdAt = createdAt;
       this.status = status;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


package hibernate.entity;
// Generated May 3, 2019 9:07:01 PM by Hibernate Tools 4.3.1



/**
 * Requestregister generated by hbm2java
 */
public class Requestregister  implements java.io.Serializable {


     private Integer id;
     private String nama;
     private String email;
     private String notelp;
     private String username;
     private String alamat;

    public Requestregister() {
    }

    public Requestregister(String nama, String email, String notelp, String username, String alamat) {
       this.nama = nama;
       this.email = email;
       this.notelp = notelp;
       this.username = username;
       this.alamat = alamat;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNotelp() {
        return this.notelp;
    }
    
    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAlamat() {
        return this.alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }




}



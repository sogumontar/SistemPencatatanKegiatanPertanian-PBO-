/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpenanaman;

/**
 *
 * @author DedekManisTasBiru
 */
public class model {

    private Integer no;
    private Integer id;
    private Double ukuranLahan;
    private String jenisTanaman;
    private String jenisBibit;
    private String tanggalMulaiPemupukan;
    private String tanggalSelesaiPemupukan;
    private String deskripsiTanaman;
    private String lokasi;
    private String caraPenanaman;
    private String bookedStatus;

    public model(Integer id,Integer no, Double ukuranLahan, String jenisTanaman, String jenisBibit, String tanggalMulaiPemupukan, String tanggalSelesaiPemupukan, String deskripsiTanaman, String lokasi, String caraPenanaman, String bookedStatus) {
        this.no = no;
        this.id=id;
        this.ukuranLahan = ukuranLahan;
        this.jenisTanaman = jenisTanaman;
        this.jenisBibit = jenisBibit;
        this.tanggalMulaiPemupukan = tanggalMulaiPemupukan;
        this.tanggalSelesaiPemupukan = tanggalSelesaiPemupukan;
        this.deskripsiTanaman = deskripsiTanaman;
        this.lokasi = lokasi;
        this.caraPenanaman = caraPenanaman;
        this.bookedStatus = bookedStatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNo() {
        return no;
    }

    public Double getUkuranLahan() {
        return ukuranLahan;
    }

    public String getJenisTanaman() {
        return jenisTanaman;
    }

    public String getJenisBibit() {
        return jenisBibit;
    }

    public String getTanggalMulaiPemupukan() {
        return tanggalMulaiPemupukan;
    }

    public String getTanggalSelesaiPemupukan() {
        return tanggalSelesaiPemupukan;
    }

    public String getDeskripsiTanaman() {
        return deskripsiTanaman;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getCaraPenanaman() {
        return caraPenanaman;
    }

    public String getBookedStatus() {
        return bookedStatus;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public void setUkuranLahan(Double ukuranLahan) {
        this.ukuranLahan = ukuranLahan;
    }

    public void setJenisTanaman(String jenisTanaman) {
        this.jenisTanaman = jenisTanaman;
    }

    public void setJenisBibit(String jenisBibit) {
        this.jenisBibit = jenisBibit;
    }

    public void setTanggalMulaiPemupukan(String tanggalMulaiPemupukan) {
        this.tanggalMulaiPemupukan = tanggalMulaiPemupukan;
    }

    public void setTanggalSelesaiPemupukan(String tanggalSelesaiPemupukan) {
        this.tanggalSelesaiPemupukan = tanggalSelesaiPemupukan;
    }

    public void setDeskripsiTanaman(String deskripsiTanaman) {
        this.deskripsiTanaman = deskripsiTanaman;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setCaraPenanaman(String caraPenanaman) {
        this.caraPenanaman = caraPenanaman;
    }

    public void setBookedStatus(String bookedStatus) {
        this.bookedStatus = bookedStatus;
    }
    
    
}

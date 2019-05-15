/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpanen;

/**
 *
 * @author DedekManisTasBiru
 */
public class model {

    private int no;
    private int id;
    private String jenis;
    private Double ukuran;
    private String lokasi;
    private String metode;
    private Integer Quantity;
    private Integer Harga;

    public model(int no,int id, String jenis, Double ukuran, String lokasi, String metode, Integer Quantity, Integer Harga) {
        this.id=id;
        this.no = no;
        this.jenis = jenis;
        this.ukuran = ukuran;
        this.lokasi = lokasi;
        this.metode = metode;
        this.Quantity = Quantity;
        this.Harga = Harga;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public String getJenis() {
        return jenis;
    }

    public Double getUkuran() {
        return ukuran;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getMetode() {
        return metode;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public Integer getHarga() {
        return Harga;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setUkuran(Double ukuran) {
        this.ukuran = ukuran;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public void setHarga(Integer Harga) {
        this.Harga = Harga;
    }
}

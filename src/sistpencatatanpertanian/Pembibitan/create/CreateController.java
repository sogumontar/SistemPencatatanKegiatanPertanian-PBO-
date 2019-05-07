/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanian.pembibitan.create;

import db.Util.HibernateUtil;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class CreateController implements Initializable {

    @FXML
    private TextField ukuran;

    @FXML
    private TextField jenis;

    @FXML
    private TextField metode;

    @FXML
    private TextField lokasi;

    @FXML
    private Button submit;

    @FXML
    private TextArea deskripsi;

    @FXML
    private DatePicker tglPenanaman;

    @FXML
    private DatePicker tgl_selesai;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void insert() {
        Session ses = HibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        
        Query q = ses.createSQLQuery("INSERT INTO penanaman (created_at,ukuran_lahan,jenis_tanaman,tanggal_penanaman,target_selesai_penanaman,deskrispsi_tanaman,lokasi,cara_pembibitan,status,booked_status) " + "VALUES (:created_at, :ukuran ,:jenis, :tanggal_tanam, :target_selesai, :deskripsi, :lokasi, :metode, :status, :booked)");
        q.setParameter("created_at", dtf.format(now));
        q.setParameter("ukuran", ukuran.getText().toString());
        q.setParameter("jenis", jenis.getText().toString());
        q.setParameter("tanggal_tanam", tglPenanaman.getValue());
        q.setParameter("target_selesai", tgl_selesai.getValue());
        q.setParameter("deskripsi", deskripsi.getText().toString());
        q.setParameter("lokasi", lokasi.getText().toString());
        q.setParameter("metode", metode.getText().toString());
        q.setParameter("status", 0);
        q.setParameter("booked", 0);
        q.executeUpdate();
        ses.getTransaction().commit();
        ses.close();
    }

}

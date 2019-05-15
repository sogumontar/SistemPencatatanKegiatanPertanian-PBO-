/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianPembibitanCreate;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    private TextField lokasi;
    @FXML
    private Button submit;
    @FXML
    private TextArea deskripsi;
    @FXML
    private DatePicker tglPenanaman;
    @FXML
    private DatePicker tgl_selesai;
    @FXML
    private MenuButton metode;
    @FXML
    private AnchorPane layout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void insert(ActionEvent event) throws IOException, ParseException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(formatter.format(date));
        String created=formatter.format(date).toString();
        
        Query query = session.createSQLQuery("INSERT INTO pembibitan (created_at,ukuran_lahan,jenis_tanaman,tanggal_mulai_pembibitan,tanggal_selesai_pembibitan,deskripsi_tanaman,lokasi,cara_pembibitan,status,booked_status)VALUES(:created, :ukuran, :jenis, :tanggalM, :tanggalS, :deskripsi, :lokasi, :cara, :status, :booked)");
        query.setParameter("created", created);
        query.setParameter("ukuran", ukuran.getText().toString());
        query.setParameter("jenis", jenis.getText().toString());
        query.setParameter("tanggalM", tglPenanaman.getValue().toString());
        query.setParameter("tanggalS", tgl_selesai.getValue().toString());
        query.setParameter("deskripsi", deskripsi.getText().toString());
        query.setParameter("lokasi", lokasi.getText().toString());
        query.setParameter("deskripsi", deskripsi.getText().toString());
        query.setParameter("cara", metode.getText().toString());
        query.setParameter("status", "normal");
        query.setParameter("booked", "normal");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Sukses");
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpembibitan/pembibitan.fxml"));
        layout.getChildren().setAll(root);

    }
    
    @FXML
    public void home() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void pembibitan() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpembibitan/pembibitan.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void pemupukan() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpemupukan/pemupukan.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void penanaman() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpenanaman/penanaman.fxml"));
        layout.getChildren().setAll(root);
    }
    @FXML
    public void panen() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpanen/panen.fxml"));
        layout.getChildren().setAll(root);
    }
    public void pascapanen() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpanen/panen.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void pascaPanen(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpanen/panen.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FormLogin.fxml"));
        layout.getChildren().setAll(root);
    }

}

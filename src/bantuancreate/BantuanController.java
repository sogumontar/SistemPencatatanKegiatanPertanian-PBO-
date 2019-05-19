/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bantuancreate;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import sistpencatatanpertanian.FormLoginController;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class BantuanController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private TextField jenisTanaman;
    @FXML
    private TextField jenisBantuan;
    @FXML
    private TextArea deskripsi;
    @FXML
    private Button btn_submit;
    @FXML
    private Button btn_pembibitan;
    @FXML
    private Button btn_penanaman;
    @FXML
    private Button btn_pemupukan;
    @FXML
    private Button btn_panen;
    @FXML
    private Button btn_pascaPanen;

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
        
        Query query = session.createSQLQuery("INSERT INTO bantuan (id_akun,jensi_bantuan,jenis_tanaman,deskripsi)VALUES(:id_akun, :jenisB, :jenisT,:deskripsi)");
        query.setParameter("created", created);
        int idAkun=FormLoginController.id_akun;
        String ida= Integer.toString(idAkun);
        query.setParameter("id_akun", ida);
        query.setParameter("jenisB", jenisBantuan.getText().toString());
        query.setParameter("jenisT", jenisTanaman.getText().toString());
        query.setParameter("deskripsi", deskripsi.getText().toString());
        query.setParameter("status", "normal");
        query.setParameter("booked", "normal");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Sukses");
        AnchorPane root = FXMLLoader.load(getClass().getResource("/bantuan/bantuan.fxml"));
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

    private void bantuan(ActionEvent event) throws IOException {
         AnchorPane root = FXMLLoader.load(getClass().getResource("/bantuan/create.fxml"));
        layout.getChildren().setAll(root);
    }

    
}

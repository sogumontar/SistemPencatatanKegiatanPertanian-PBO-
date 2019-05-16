/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpemupukan;

import entity.Pemupukan;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class PemupukanController implements Initializable {

    ObservableList obv;
    List list;
    @FXML
    private AnchorPane layout;
    @FXML
    private TableView<model> table;
    @FXML
    private TableColumn<model, Integer> no;
    @FXML
    private TableColumn<model, Integer> ukuran;
    @FXML
    private TableColumn<model, String> jenis;
    @FXML
    private TableColumn<model, String> deskripsi;
    @FXML
    private TableColumn<model, String> lokasi;
    @FXML
    private TableColumn<model, String> metode;
    @FXML
    private TableColumn<model, String> jenisPupuk;
    @FXML
    private TableColumn<model, Integer> banyakPupuk;
    @FXML
    private TableColumn<model, String> mulai;
    @FXML
    private TableColumn<model, String> selesai;
    @FXML
    private ImageView img_pemupukan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        img_pemupukan.setVisible(false);
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        obv = FXCollections.observableArrayList();
        Query query = session.createQuery("from Pemupukan");
        list = query.list();
        session.getTransaction().commit();
        session.close();
        int indikator = 1;
        for (Object i : list) {
            Pemupukan objek = (Pemupukan) i;
            String jenis = objek.getJenisTanaman();
            String tanggalMulai = objek.getTanggalMulaiPemupukan();
            String tanggalSelesai = objek.getTanggalSelesaiPemupukan();
            String lokasi = objek.getLokasi();
            String metode = objek.getCaraPemupukan();
            String status = objek.getBookedStatus();
            Double ukuran = objek.getUkuranLahan();
            String deskripsi = objek.getDeskripsiTanaman();
            String bookedStatus = objek.getBookedStatus();
            String pupuk = objek.getPupuk();
            Integer banyak = objek.getBanyakPupuk();

            indikator++;

            obv.add(new sistpencatatanpertanianpemupukan.model(indikator, ukuran, jenis, tanggalMulai, tanggalSelesai, deskripsi, lokasi, metode, pupuk, banyak, status));
        }
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        ukuran.setCellValueFactory(new PropertyValueFactory<>("Ukuran"));
        jenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<>("Deskripsi"));
        mulai.setCellValueFactory(new PropertyValueFactory<>("tanggal mulai"));
        selesai.setCellValueFactory(new PropertyValueFactory<>("tanggal selesai"));
        lokasi.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        metode.setCellValueFactory(new PropertyValueFactory<>("metode"));
        jenisPupuk.setCellValueFactory(new PropertyValueFactory<>("pupuk"));
        banyakPupuk.setCellValueFactory(new PropertyValueFactory<>("Banyak Pupuk"));
        table.setItems(obv);
        table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            sistpencatatanpertanianpemupukan.model model;

            @Override
            public void handle(MouseEvent event) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    
                    model = table.getSelectionModel().getSelectedItem();
                    img_pemupukan.setVisible(true);
                    img_pemupukan=new ImageView();
                   
                    System.out.println(model.getJenis());
                }
            }
        });

    }

    @FXML
    public void create(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpemupukancreate/pemupukan.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void pembibitan(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpembibitan/pembibitan.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void penanaman(ActionEvent event) throws IOException  {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpenanaman/penanaman.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void pemupukan(ActionEvent event) throws IOException  {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpemupukan/pemupukan.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void panen(ActionEvent event) throws IOException  {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpanen/panen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void pascaPanen(ActionEvent event) throws IOException  {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpascapanen/pascapanen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void home(ActionEvent event) throws IOException  {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException  {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FormLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

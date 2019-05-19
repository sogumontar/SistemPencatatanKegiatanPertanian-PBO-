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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import sistpencatatanpertanian.FormLoginController;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class PemupukanController implements Initializable {

    int id = 0;
    String idd = "";
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
    private TableColumn<model, String> mulai;
    private TableColumn<model, String> selesai;
    private ImageView img_pemupukan;
    @FXML
    private Button btn_create;
    @FXML
    private TextField update_jenis;
    @FXML
    private TextField update_ukuran;
    @FXML
    private TextField update_lokasi;
    @FXML
    private TextField update_quantity;
    @FXML
    private TextField update_harga;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_preOrder;
    @FXML
    private Button log;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (FormLoginController.role.equals("admin")) {
            btn_create.setVisible(true);
        } else {
            btn_create.setVisible(false);
        }
        btn_update.setVisible(false);
        btn_delete.setVisible(false);
        btn_create.setVisible(false);
        btn_preOrder.setVisible(false);
        update_jenis.setVisible(false);
        update_ukuran.setVisible(false);
        update_lokasi.setVisible(false);
        update_quantity.setVisible(false);
        update_harga.setVisible(false);
        if (FormLoginController.login == false) {
            log.setText("LOGIN");
        } else {
            if (FormLoginController.role != "admin") {
                btn_create.setVisible(true);
            } else {
                btn_create.setVisible(false);
            }
            log.setText("LOGOUT");
        }

//        img_pemupukan.setVisible(false);
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        obv = FXCollections.observableArrayList();
        Query query = session.createQuery("from Pemupukan");
        list = query.list();
        session.getTransaction().commit();
        session.close();
        int indikator = 0;
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

                    System.out.println(model.getJenis());

//                    if (FormLoginController.login == true) {
////                        String one = "src/images/test.PNG";
////                        ImageView img=Toolkit.getDefaultToolkit().getImage(one);
////                        Image img = Toolkit.getDefaultToolkit().getImage(one);
//                        btn_delete.setVisible(true);
//                        btn_update.setVisible(true);
//                        btn_preOrder.setVisible(true);
//                        btn_create.setVisible(true);
//
//                    }
                    if (FormLoginController.login == false) {
                        update_jenis.setVisible(true);
                        update_jenis.setDisable(true);
                        update_ukuran.setVisible(true);
                        update_ukuran.setDisable(true);
                        update_lokasi.setVisible(true);
                        update_lokasi.setDisable(true);
                        update_quantity.setVisible(true);
                        update_quantity.setDisable(true);
                        update_harga.setVisible(true);
                        update_harga.setDisable(true);
                    } else {
                        
                        btn_delete.setVisible(true);
                        btn_update.setVisible(true);
                        update_jenis.setVisible(true);
                        update_jenis.setDisable(false);
                        update_ukuran.setVisible(true);
                        update_ukuran.setDisable(false);
                        update_lokasi.setVisible(true);
                        update_lokasi.setDisable(false);
                        update_quantity.setVisible(true);
                        update_quantity.setDisable(false);
                        update_harga.setVisible(true);
                        update_harga.setDisable(false);
                    }

                    update_jenis.setText(model.getJenis().toString());
                    update_ukuran.setText(model.getUkuran().toString());
                    update_lokasi.setText(model.getLokasi().toString());
                    update_quantity.setText(Integer.toString(model.getBanyak()));
                    update_harga.setText(model.getPupuk().toString());

                    idd = model.getJenis();
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
    private void penanaman(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpenanaman/penanaman.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void pemupukan(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpemupukan/pemupukan.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void panen(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void pascaPanen(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpascapanen/pascapanen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FormLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void preorder(ActionEvent event) {
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("UPDATE Pemupukan SET ukuran_lahan='" + update_ukuran.getText() + "',jenis_tanaman='" + update_jenis.getText() + "',banyak_pupuk='" + update_quantity.getText() + "',lokasi='" + update_lokasi.getText() + "',pupuk='" + update_harga.getText() + "' WHERE jenis_tanaman= '" + idd + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        AnchorPane root = FXMLLoader.load(getClass().getResource("pemupukan.fxml"));
        layout.getChildren().setAll(root);

    }

    @FXML
    private void delete(ActionEvent event) throws IOException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("DELETE Pemupukan WHERE jenis_tanaman= '" + idd + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        AnchorPane root = FXMLLoader.load(getClass().getResource("pemupukan.fxml"));
        layout.getChildren().setAll(root);

    }

}

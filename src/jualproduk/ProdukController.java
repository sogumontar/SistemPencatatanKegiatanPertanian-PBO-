/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jualproduk;

import entity.Panen;
import entity.Produk;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import sistpencatatanpertanian.FormLoginController;
import sistpencatatanpertanianpanen.DetailController;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class ProdukController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> no;
    @FXML
    private TableColumn<?, ?> nama;
    @FXML
    private TableColumn<?, ?> jumlah;
    @FXML
    private TableColumn<?, ?> harga;
    @FXML
    private TableColumn<?, ?> deskripsi;
    @FXML
    private TableColumn<?, ?> status;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_delete;
    @FXML
    private TextField update_nama;
    @FXML
    private TextField update_jumlah;
    @FXML
    private TextField update_harga;
    @FXML
    private TextField update_deskripsi;
    ObservableList oo;
    model mod;
    @FXML
    private Button btn_create1;
    @FXML
    private TextField harga_tawaran;
    @FXML
    private Button log;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_update.setVisible(false);
        btn_delete.setVisible(false);
        btn_create1.setVisible(false);
        btn_create.setVisible(false);

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
        harga_tawaran.setVisible(false);
        Session ss = db.util.NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        oo = FXCollections.observableArrayList();
        Query query = ss.createQuery("FROM Produk ");
        List list = query.list();
        ss.getTransaction().commit();
        ss.close();
        int i = 1;
        for (Object obj : list) {
            Produk prod = (Produk) obj;
            String nama = prod.getNamaProduk();
            int jumlah = prod.getJumlah();
            int harga = prod.getHarga();
            String deskripsi = prod.getDeskripsi();
            String status = prod.getStatus();

            oo.add(new jualproduk.model(i, nama, jumlah, harga, deskripsi, status));

            i++;
        }
        no.setCellValueFactory(new PropertyValueFactory<>("No"));
        nama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        jumlah.setCellValueFactory(new PropertyValueFactory<>("Jumlah"));
        harga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<>("Deskripsi"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        table.setItems(oo);
        table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {

                if (table.getSelectionModel().getSelectedItem() != null) {

                    mod = (model) table.getSelectionModel().getSelectedItem();
                    if (FormLoginController.login == false) {
                        btn_update.setVisible(true);
                        btn_delete.setVisible(true);
                        btn_create1.setVisible(true);
                        btn_create.setVisible(true);
                    }
                }
            }
        });
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
        FormLoginController.login = false;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FormLogin.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void create(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/jualprodukcreate/create.fxml"));
        layout.getChildren().setAll(root);
    }

    private void detail(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("detail.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    private void tawar(ActionEvent event) {
        harga_tawaran.setVisible(true);
    }

    private void menawar(ActionEvent event) {
        System.out.println("tawar");
    }

}

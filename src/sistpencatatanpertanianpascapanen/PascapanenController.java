/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpascapanen;

import entity.Panen;
import entity.PascaPanen;
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

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class PascapanenController implements Initializable {

    ObservableList oo;
    List list;
    model mod;
    @FXML
    private AnchorPane layout;
    @FXML
    private TableColumn<model, Integer> no;
    @FXML
    private TableColumn<model, Double> ukuran;
    @FXML
    private TableColumn<model, String> jenis;
    private TableColumn<model, String> selesai;
    @FXML
    private TableColumn<model, String> deskripsi;
    @FXML
    private TableColumn<model, Integer> banyak;
    @FXML
    private TableColumn<model, String> lokasi;
    @FXML
    private TableColumn<model, String> carapanen;
    @FXML
    private TableColumn<model, Integer> harga;
    @FXML
    private TableColumn<model, Integer> quantity;
    @FXML
    private TableColumn<model, String> status;
    @FXML
    private TableView<model> table;
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
    @FXML
    private Button btn_create;
    @FXML
    private TextField update_jenis;
    @FXML
    private TextField update_ukuran;
    @FXML
    private TextField update_lokasi;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_update;
    @FXML
    private Button log;
    String idd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (FormLoginController.login == true) {
            btn_create.setVisible(true);
        } else {
            btn_create.setVisible(false);
        }
        btn_update.setVisible(false);
        btn_delete.setVisible(false);
        update_jenis.setVisible(false);
        update_ukuran.setVisible(false);
        update_lokasi.setVisible(false);

        if (FormLoginController.login == false) {
            log.setText("LOGIN");
        } else {

            log.setText("LOGOUT");
        }
        Session ss = db.util.NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        oo = FXCollections.observableArrayList();
        Query query = ss.createQuery("FROM PascaPanen ");
        List list = query.list();
        ss.getTransaction().commit();
        ss.close();
        int i = 1;
        for (Object obj : list) {
            PascaPanen panen = (PascaPanen) obj;
            String jenis = panen.getJenisTanaman();
            Double ukuran = panen.getUkuranLalhan();
            String lokasi = panen.getLokasi();
            Integer quantity = panen.getQuantity();
            Integer harga = panen.getHarga();
            String caraPanen = panen.getCaraPanen();
            String selesai = panen.getTanggalSelesaiPanen();
            Integer banyak = panen.getBanyakHasilPanen();
            String deskripsi = panen.getDeskripsiTanaman();
            String status = panen.getBookedStatus();
            oo.add(new sistpencatatanpertanianpascapanen.model(i, ukuran, jenis, selesai, deskripsi, banyak, lokasi, caraPanen, harga, quantity, status));

            i++;
        }
        no.setCellValueFactory(new PropertyValueFactory<>("No"));
        ukuran.setCellValueFactory(new PropertyValueFactory<>("Ukuran"));
        jenis.setCellValueFactory(new PropertyValueFactory<>("Jenis"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<>("Deskripsi"));
        banyak.setCellValueFactory(new PropertyValueFactory<>("Banyak"));
        lokasi.setCellValueFactory(new PropertyValueFactory<>("Lokasi"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        harga.setCellValueFactory(new PropertyValueFactory<>("Harga"));
        carapanen.setCellValueFactory(new PropertyValueFactory<>("Metode"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        table.setItems(oo);
        table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    mod = table.getSelectionModel().getSelectedItem();
                    System.out.println(mod.getNo());
                    idd = mod.getJenis().toString();
                    if (FormLoginController.login == true) {
                        btn_delete.setVisible(true);
                        btn_update.setVisible(true);
                    }
                    if (FormLoginController.login == false) {
                        update_jenis.setVisible(false);
                        update_ukuran.setVisible(false);
                        update_lokasi.setVisible(false);

                        update_jenis.setVisible(true);
                        update_jenis.setDisable(true);
                        update_ukuran.setVisible(true);
                        update_ukuran.setDisable(true);
                        update_lokasi.setVisible(true);
                        update_lokasi.setDisable(true);
                    } else {
                        update_jenis.setVisible(true);
                        update_jenis.setDisable(false);
                        update_ukuran.setVisible(true);
                        update_ukuran.setDisable(false);
                        update_lokasi.setVisible(true);
                        update_lokasi.setDisable(false);
                    }

                    update_jenis.setText(mod.getJenis().toString());
                    update_ukuran.setText(mod.getUkuran().toString());
                    update_lokasi.setText(mod.getLokasi().toString());
                }
            }
        });
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
    public void create(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpascapanencreate/create.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void delete(ActionEvent event) throws IOException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("Delete Pasca_Panen where jenis_tanaman ='" + idd + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

        AnchorPane root = FXMLLoader.load(getClass().getResource("pascapanen.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("UPDATE Pasca_Panen SET jenis_tanaman='" + update_jenis.getText() + "', ukuran_lalhan='" + update_ukuran.getText() + "',lokasi='" + update_lokasi.getText() + "' WHERE jenis_tanaman= '" + idd + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        AnchorPane root = FXMLLoader.load(getClass().getResource("pascapanen.fxml"));
        layout.getChildren().setAll(root);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpenanaman;

import entity.Penanaman;
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
import javafx.scene.control.PasswordField;
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
public class PenanamanController implements Initializable {

    int id=0;
    ObservableList obv;
    List list;
    @FXML
    private AnchorPane layout;
    @FXML
    private TableView<model> table;
    @FXML
    private TableColumn<model, Integer> no;
    private TableColumn<model, Double> ukuran;
    private TableColumn<model, String> jenis;
    private TableColumn<model, String> bibit;
    private TableColumn<model, String> mulai;
    private TableColumn<model, String> target;
    private TableColumn<model, String> deskripsi;
    private TableColumn<model, String> lokasi;
    private TableColumn<model, String> metode;
    private TableColumn<model, String> status;
    private Button btn_create;
    @FXML
    private Button log;
    private Button btn_update;
    private Button btn_delete;
    private TextField update_jenis;
    private TextField update_ukuran;
    private TextField update_lokasi;
    private TextField update_bibit;
    @FXML
    private TableColumn<?, ?> username;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> nama;
    @FXML
    private TableColumn<?, ?> alamat;
    @FXML
    private TableColumn<?, ?> notelp;
    @FXML
    private Button btn_approve;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_update.setVisible(false);
        btn_delete.setVisible(false);
        btn_create.setVisible(false);
        update_jenis.setVisible(false);
        update_ukuran.setVisible(false);
        update_lokasi.setVisible(false);
        update_ukuran.setVisible(false);
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
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        obv = FXCollections.observableArrayList();
        Query query = session.createQuery("from Penanaman");
        list = query.list();
        session.getTransaction().commit();
        session.close();
        int indikator = 1;
        for (Object i : list) {
            Penanaman objek = (Penanaman) i;
            String jenis = objek.getJenisTanaman();
            String tanggalMulai = objek.getTanggalMulaiPemupukan();
            String tanggalSelesai = objek.getTanggalSelesaiPemupukan();
            String lokasi = objek.getLokasi();
            String metode = objek.getCaraPenanaman();
            String status = objek.getBookedStatus();
            Double ukuran = objek.getUkuranLahan();
            String deskripsi = objek.getDeskripsiTanaman();
            String bookedStatus = objek.getBookedStatus();
            String jenisBibit = objek.getJenisBibit();
            indikator++;

            obv.add(new sistpencatatanpertanianpenanaman.model(objek.getId(),indikator, ukuran, jenis, jenisBibit, tanggalMulai, tanggalSelesai, deskripsi, lokasi, metode, status));
        }
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        ukuran.setCellValueFactory(new PropertyValueFactory<>("Ukuran"));
        jenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        bibit.setCellValueFactory(new PropertyValueFactory<>("Bibit"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<>("Deskripsi"));
        mulai.setCellValueFactory(new PropertyValueFactory<>("tanggal mulai"));
        target.setCellValueFactory(new PropertyValueFactory<>("tanggal selesai"));
        lokasi.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        metode.setCellValueFactory(new PropertyValueFactory<>("metode"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        table.setItems(obv);
        table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            sistpencatatanpertanianpenanaman.model model;

            @Override
            public void handle(MouseEvent event) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    model = table.getSelectionModel().getSelectedItem();
                    System.out.println(model.getCaraPenanaman());
                    id=model.getId();
                    if (FormLoginController.login == true) {
//                        String one = "src/images/test.PNG";
//                        ImageView img=Toolkit.getDefaultToolkit().getImage(one);
//                        Image img = Toolkit.getDefaultToolkit().getImage(one);
                        btn_delete.setVisible(true);
                        btn_update.setVisible(true);

                    }
                    update_jenis.setVisible(true);
                    update_ukuran.setVisible(true);
                    update_lokasi.setVisible(true);
                    update_bibit.setVisible(true);

                    update_jenis.setText(model.getJenisTanaman().toString());
                    update_ukuran.setText(model.getUkuranLahan().toString());
                    update_lokasi.setText(model.getLokasi().toString());
                    update_bibit.setText(model.getJenisBibit().toString());
                }
            }
        });
    }

    private void tambah(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpenanamancreate/create.fxml"));
        layout.getChildren().setAll(root);
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

        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpanen/panen.fxml"));

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

    public void bantuan(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/bantuan/create.fxml"));
        layout.getChildren().setAll(root);
    }


    private void delete(ActionEvent event) throws IOException {
          Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("Delete Penanaman where id =" + id + "");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        
      AnchorPane root = FXMLLoader.load(getClass().getResource("penanaman.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void approve(ActionEvent event) {
    }

}

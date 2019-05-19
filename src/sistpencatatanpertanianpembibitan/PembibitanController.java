/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpembibitan;

import entity.Pembibitan;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.DatePicker;
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
public class PembibitanController implements Initializable {
    model mod;
    String idd = "";
    ObservableList ov;
    List list;
    @FXML
    private AnchorPane layout;
    @FXML
    private TableView<model> table;
    @FXML
    private TableColumn<model, Integer> no;
    @FXML
    private TableColumn<model, String> jenis;
    @FXML
    private TableColumn<model, String> tanggalmulai;
    @FXML
    private TableColumn<model, String> tanggalselesai;
    @FXML
    private TableColumn<model, String> lokasi;
    @FXML
    private TableColumn<model, String> metode;
    @FXML
    private TableColumn<model, String> status;
    @FXML
    private TableColumn<model, Double> ukuran;
    private Button deletes;
    @FXML
    private TextField update_jenis;
    @FXML
    private TextField update_lokasi;
    @FXML
    private TextField update_metode;
    @FXML
    private TextField update_ukuran;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_tambah;
    @FXML
    private Button btn_delete;
    @FXML
    private ImageView img_pembibitan;
    @FXML
    private Button log;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (FormLoginController.login == true) {
            btn_tambah.setVisible(true);
        } else {
            btn_tambah.setVisible(false);
        }
        btn_update.setVisible(false);
        btn_delete.setVisible(false);
        update_jenis.setVisible(false);
        update_ukuran.setVisible(false);
        update_lokasi.setVisible(false);
        update_metode.setVisible(false);

        if (FormLoginController.login == false) {
            log.setText("LOGIN");
        } else {

            log.setText("LOGOUT");
        }

        Session ss = db.util.NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ov = FXCollections.observableArrayList();
        Query query = ss.createQuery("FROM Pembibitan WHERE booked_status='normal' ");
        List list = query.list();
        ss.getTransaction().commit();
        ss.close();
        int i = 1;
        for (Object obj : list) {
            entity.Pembibitan panen = (entity.Pembibitan) obj;
            String jenis = panen.getJenisTanaman();
            Double ukuran = panen.getUkuranLahan();
            String lokasi = panen.getLokasi();
            String metode = panen.getCaraPembibitan();
            String tglM = panen.getTanggalMulaiPembibitan();
            String tglS = panen.getTanggalSelesaiPembibitan();
            String status = panen.getStatus();
            ov.add(new model(i, panen.getId(), jenis, tglM, tglS, lokasi, metode, status, ukuran));

            i++;
        }
        no.setCellValueFactory(new PropertyValueFactory<>("No"));
        jenis.setCellValueFactory(new PropertyValueFactory<>("Jenis"));
        tanggalmulai.setCellValueFactory(new PropertyValueFactory<>("Tanggal Mulai"));
        tanggalselesai.setCellValueFactory(new PropertyValueFactory<>("Tanggal Selesai"));
        lokasi.setCellValueFactory(new PropertyValueFactory<>("Lokasi"));
        metode.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        ukuran.setCellValueFactory(new PropertyValueFactory<>("Ukuran"));

        table.setItems(ov);
        table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    mod = table.getSelectionModel().getSelectedItem();
                    if (FormLoginController.login == true) {
//                        String one = "src/images/test.PNG";
//                        ImageView img=Toolkit.getDefaultToolkit().getImage(one);
//                        Image img = Toolkit.getDefaultToolkit().getImage(one);
                        btn_delete.setVisible(true);
                        btn_update.setVisible(true);
                       

                    }
                    if (FormLoginController.login == false) {
                        update_jenis.setVisible(true);
                        update_jenis.setDisable(true);
                        update_ukuran.setVisible(true);
                        update_ukuran.setDisable(true);
                        update_lokasi.setVisible(true);
                        update_lokasi.setDisable(true);
                        update_metode.setVisible(true);
                        update_metode.setDisable(true);
                    } else {
                        update_jenis.setVisible(true);
                        update_jenis.setDisable(false);
                        update_ukuran.setVisible(true);
                        update_ukuran.setDisable(false);
                        update_lokasi.setVisible(true);
                        update_lokasi.setDisable(false);
                        update_metode.setVisible(true);
                        update_metode.setDisable(false);
                    }

                    update_jenis.setText(mod.getJenis().toString());
                    update_ukuran.setText(mod.getUkuran().toString());
                    update_lokasi.setText(mod.getLokasi().toString());
                    update_metode.setText(mod.getMetode().toString());  

                    System.out.println(mod.getJenis());
                    idd = mod.getJenis();
                }
            }
        });

    }

    @FXML
    private void create(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianPembibitanCreate/create.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void home(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pembibitan(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpembibitan/pembibitan.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FormLogin.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void pemupukan(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpemupukan/pemupukan.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void delete(ActionEvent event) throws IOException {

        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ov = FXCollections.observableArrayList();
        System.out.println(idd);
        Query query = session.createSQLQuery("Delete Pembibitan where jenis_tanaman ='" + idd + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

        AnchorPane root = FXMLLoader.load(getClass().getResource("pembibitan.fxml"));
        layout.getChildren().setAll(root);

    }
    @FXML
    private void update(ActionEvent event) throws IOException {
          Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("UPDATE Pembibitan SET ukuran_lahan='"+update_ukuran.getText()+"', jenis_tanaman='"+update_jenis.getText()+"',lokasi='"+update_lokasi.getText()+"',cara_pembibitan='"+update_metode.getText()+"' WHERE jenis_tanaman= '" + idd + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        AnchorPane root = FXMLLoader.load(getClass().getResource("pembibitan.fxml"));
        layout.getChildren().setAll(root);

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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanian;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import db.util.NewHibernateUtil;
import entity.Panen;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DedekManisTasBiru
 */
public class FXMLDocumentController implements Initializable {

    ObservableList oo;
    model mod = null;
    @FXML
    private Label label;
    @FXML
    private AnchorPane layout;
    @FXML
    private TableView<model> table;
    @FXML
    private TableColumn<model, Integer> nomor;
    @FXML
    private TableColumn<model, String> jenis;
    @FXML
    private TableColumn<model, Double> ukuran;
    @FXML
    private TableColumn<model, String> lokasi;
    @FXML
    private TableColumn<model, Double> quantity;
    @FXML
    private TableColumn<model, Integer> harga;
    @FXML
    private TableColumn<model, String> carapanen;
    @FXML
    private Button log;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_delete;
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
    private ImageView img;
    @FXML
    private Button regist;
    @FXML
    private Button btn_create1;
    int idAkun = 0;
    int idd = 1;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(FormLoginController.role);
        if (FormLoginController.role.equals("admin")) {
            regist.setVisible(true);
        } else {
            regist.setVisible(false);
        }
        btn_update.setVisible(false);
        btn_delete.setVisible(false);
        btn_create.setVisible(false);
        btn_create1.setVisible(false);
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

        Session ss = db.util.NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        oo = FXCollections.observableArrayList();
        Query query = ss.createQuery("FROM Panen WHERE booked_status='normal' ");
        List list = query.list();
        ss.getTransaction().commit();
        ss.close();
        int i = 1;
        for (Object obj : list) {
            entity.Panen panen = (entity.Panen) obj;
            String jenis = panen.getJenisTanaman();
            Double ukuran = panen.getUkuranLalhan();
            String lokasi = panen.getLokasi();
            Integer quantity = panen.getQuantity();
            Integer harga = panen.getHarga();
            String caraPanen = panen.getCaraPanen();
            oo.add(new model(i, panen.getId(), jenis, ukuran, lokasi, caraPanen, quantity, harga));

            i++;
        }
        nomor.setCellValueFactory(new PropertyValueFactory<>("No"));
        jenis.setCellValueFactory(new PropertyValueFactory<>("Jenis"));
        ukuran.setCellValueFactory(new PropertyValueFactory<>("Ukuran"));
        lokasi.setCellValueFactory(new PropertyValueFactory<>("Lokasi"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        harga.setCellValueFactory(new PropertyValueFactory<>("Harga"));
        carapanen.setCellValueFactory(new PropertyValueFactory<>("Metode"));

        table.setItems(oo);
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
                        btn_create1.setVisible(true);
                        btn_create.setVisible(true);

                    }
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

                    update_jenis.setText(mod.getJenis().toString());
                    update_ukuran.setText(mod.getUkuran().toString());
                    update_lokasi.setText(mod.getLokasi().toString());
                    update_quantity.setText(mod.getQuantity().toString());
                    update_harga.setText(mod.getHarga().toString());

                    System.out.println(mod.getId());
                    idd = mod.getId();
                }
            }
        });

    }

    @FXML
    public void logout() throws IOException {
        FormLoginController.login = false;
        AnchorPane root = FXMLLoader.load(getClass().getResource("FormLogin.fxml"));
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

    @FXML
    public void pascaPanen() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpanen/panen.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void bantuan() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/bantuan/create.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void create(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpanencreate/create.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("UPDATE Panen SET ukuran_lalhan='" + update_ukuran.getText() + "',jenis_tanaman='" + update_jenis.getText() + "',quantity='" + update_quantity.getText() + "',lokasi='" + update_lokasi.getText() + "',harga='" + update_harga.getText() + "' WHERE id= '" + idd + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        layout.getChildren().setAll(root);

    }

    @FXML
    private void delete(ActionEvent event) throws IOException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("DELETE Panen  WHERE id= '" + idd + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        layout.getChildren().setAll(root);

    }

    @FXML
    private void regist(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/registerrequest/request.fxml"));
        layout.getChildren().setAll(root);

    }

    @FXML
    private void preorder(ActionEvent event) throws IOException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("UPDATE Panen SET booked_status ='booked'  WHERE id= '" + idd + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        layout.getChildren().setAll(root);
    }
}

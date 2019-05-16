/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerrequest;

import entity.Akun;
import entity.Penanaman;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import sistpencatatanpertanian.FormLoginController;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class RequestController implements Initializable {
    int idd=0;
    @FXML
    private AnchorPane layout;
    @FXML
    private TableView<entity.Akun> table;
    @FXML
    private TableColumn<entity.Akun, Integer> no;
    @FXML
    private TableColumn<entity.Akun, String> username;
    @FXML
    private TableColumn<entity.Akun, String> email;
    @FXML
    private TableColumn<entity.Akun, String> nama;
    @FXML
    private TableColumn<entity.Akun, String> notelp;
    @FXML
    private TableColumn<entity.Akun, String> alamat;
    @FXML
    private Button log;
    @FXML
    private Button btn_approve;
    @FXML
    private ImageView img;
    ObservableList obv;
    List list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_approve.setVisible(false);
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        obv = FXCollections.observableArrayList();
        Query query = session.createQuery("from Akun WHERE gambar!=1");
        list = query.list();
        session.getTransaction().commit();
        session.close();
        int indikator = 1;
        for (Object i : list) {
            Akun objek = (Akun) i;
            String username= objek.getUsername();
            String email = objek.getEmail();
            String nama = objek.getNama();
            String notelp = objek.getNoTelp();
            String alamat = objek.getAlamat();
          
            indikator++;

            obv.add(new Akun(indikator,username,email, nama, notelp, alamat));
        }
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        username.setCellValueFactory(new PropertyValueFactory<>("Username"));
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        nama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        notelp.setCellValueFactory(new PropertyValueFactory<>("No Telp"));
        alamat.setCellValueFactory(new PropertyValueFactory<>("Alamat"));
        table.setItems(obv);
        table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            Akun model;

            @Override
            public void handle(MouseEvent event) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    btn_approve.setVisible(true);
                    model = table.getSelectionModel().getSelectedItem();
                    System.out.println(model.getId());
                    idd=model.getId();
                    

                }
            }
        });
    }

    @FXML
    private void pembibitan(ActionEvent event) {
    }

    @FXML
    private void penanaman(ActionEvent event) {
    }

    @FXML
    private void pemupukan(ActionEvent event) {
    }

    @FXML
    private void panen(ActionEvent event) {
    }

    @FXML
    private void pascaPanen(ActionEvent event) {
    }

    @FXML
    private void home(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void approve(ActionEvent event) {
    }

}

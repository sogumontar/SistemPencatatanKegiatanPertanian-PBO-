/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bantuan;

import entity.Bantuan;
import entity.Panen;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import sistpencatatanpertanian.FormLoginController;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class CreateController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private TableView<model> table;
    @FXML
    private TableColumn<model, String> jenisTanaman;
    @FXML
    private TableColumn<model, String> no;
    @FXML
    private TableColumn<model, String> jenisBantuan;
    @FXML
    private TableColumn<model, String> deskripsi;
    ObservableList oo;
    model mod;
    @FXML
    private Button btn_create;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (FormLoginController.role == "admin") {
            btn_create.setVisible(false);
        }
        Session ss = db.util.NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        oo = FXCollections.observableArrayList();
        Query query = ss.createQuery("FROM Bantuan ");
        List list = query.list();
        ss.getTransaction().commit();
        ss.close();
        int i = 1;
        for (Object obj : list) {
            Bantuan ban = (Bantuan) obj;
            String jenisBantuan = ban.getJenisBantuan().toString();
            String jenisTanaman = ban.getJenisTanaman().toString();
            String deskripsi = ban.getDeskripsi();
            oo.add(new bantuan.model(i, jenisBantuan, jenisTanaman, deskripsi));

            i++;
        }

        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        jenisBantuan.setCellValueFactory(new PropertyValueFactory<>("Jenis Bantuan"));
        jenisTanaman.setCellValueFactory(new PropertyValueFactory<>("Jenis Tanaman"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<>("Deskripsi"));

        table.setItems(oo);
        table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    mod = table.getSelectionModel().getSelectedItem();
                    System.out.println(mod.getJenisBantuan());
                }
            }
        });
    }

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
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpascapanen/pascapanen.fxml"));
        layout.getChildren().setAll(root);
    }

    private void logout(ActionEvent event) throws IOException {
        FormLoginController.login = false;
        AnchorPane root = FXMLLoader.load(getClass().getResource("FormLogin .fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void create(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/bantuancreate/bantuan.fxml"));
        layout.getChildren().setAll(root);
    }

}

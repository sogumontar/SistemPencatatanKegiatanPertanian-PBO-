/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpanen;

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

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class PanenController implements Initializable {
    ObservableList oo;
    List list;
    entity.Panen mod;
    @FXML
    private AnchorPane layout;
    @FXML
    private TableColumn<entity.Panen, Integer> no;
    @FXML
    private TableColumn<entity.Panen, String> jenis;
    @FXML
    private TableColumn<entity.Panen, Double> ukuran;
    @FXML
    private TableColumn<entity.Panen, String> lokasi;
    @FXML
    private TableColumn<entity.Panen, Integer> quantity;
    @FXML
    private TableColumn<entity.Panen, Integer> harga;
    @FXML
    private TableColumn<entity.Panen, String> carapanen;
    @FXML
    private TableView<entity.Panen> table;
    private Button detail;
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
    private TextField update_metode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session ss = db.util.NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        oo = FXCollections.observableArrayList();
        Query query = ss.createQuery("FROM Panen ");
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
            oo.add(new entity.Panen(i,ukuran, jenis,panen.getDeskripsiTanaman(), lokasi, caraPanen,harga, quantity, panen.getBookedStatus(),panen.getGambar()));

            i++;
        }
        no.setCellValueFactory(new PropertyValueFactory<>("No"));
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
                    DetailController.id=mod.getId();
                    mod = table.getSelectionModel().getSelectedItem();
                    System.out.println(mod.getId());
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

    @FXML
    private void create(ActionEvent event) throws IOException {
        AnchorPane root=FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpanencreate/create.fxml"));
        layout.getChildren().setAll(root);
    }

    private void detail(ActionEvent event) throws IOException {
         AnchorPane root=FXMLLoader.load(getClass().getResource("detail.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }
    
}

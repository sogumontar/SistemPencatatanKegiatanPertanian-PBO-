/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanian;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import db.Util.HibernateUtil;
import hibernate.entity.Panen;
import java.awt.event.MouseEvent;
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
import javafx.scene.control.cell.PropertyValueFactory;
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

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session ss = db.Util.HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        oo = FXCollections.observableArrayList();
        Query query = ss.createQuery("FROM Panen ");
        List list = query.list();
        ss.getTransaction().commit();
        ss.close();
        int i = 1;
        for (Object obj : list) {
            Panen panen = (Panen) obj;
            String jenis = panen.getJenisTanaman();
            Double ukuran = panen.getUkuranLahan();
            String lokasi = panen.getLokasi();
            Double quantity = panen.getQuantity();
            Integer harga = panen.getHarga();
            String caraPanen = panen.getCaraPanen();
            System.out.println(jenis+ukuran+lokasi+quantity+harga+carapanen);
            oo.add(new model(i, jenis, ukuran, lokasi, caraPanen, quantity, harga));

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
                    System.out.println(mod.getNo());
                }
            }
        });

    }
    public void logout() throws IOException{
        FormLoginController.login=false;
        AnchorPane root=FXMLLoader.load(getClass().getResource("FormLogin.fxml"));
        layout.getChildren().setAll(root);
        
    }
    public void home() throws IOException{
        AnchorPane root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        layout.getChildren().setAll(root);
    }
    public void pembibitan() throws IOException{
        AnchorPane root=FXMLLoader.load(getClass().getResource("sistpencatatanpertanian/Pembibitan/pembibitan.fxml"));
        layout.getChildren().setAll(root);
    }
}

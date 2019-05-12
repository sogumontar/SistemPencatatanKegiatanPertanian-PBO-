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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class PembibitanController implements Initializable {

    ObservableList ov;
    List list;
    @FXML
    private AnchorPane layout;
    @FXML
    private Button butt;
    @FXML
    private TableView<model> table;
    @FXML
    private TableColumn<model, Integer> no;
    @FXML
    private TableColumn<model, String> jenis;
    @FXML
    private TableColumn<model, Date> tanggalmulai;
    @FXML
    private TableColumn<model, Date> tanggalselesai;
    @FXML
    private TableColumn<model, String> lokasi;
    @FXML
    private TableColumn<model, String> metode;
    @FXML
    private TableColumn<model, String> status;
    @FXML
    private TableColumn<model, Double> ukuran;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ov = FXCollections.observableArrayList();
        Query query = session.createQuery("from Pembibitan");
        list = query.list();
        session.getTransaction().commit();
        session.close();
        int indikator = 1;
        for (Object i : list) {
            Pembibitan objek = (Pembibitan) i;
            String jenis=objek.getJenisTanaman();
            String now=objek.getCreatedAt();
            String tanggalMulai=objek.getTanggalMulaiPembibitan();
            String tanggalSelesai=objek.getTanggalSelesaiPembibitan();
            String lokasi=objek.getLokasi();
            String metode=objek.getCaraPembibitan();
            String status=objek.getBookedStatus();
            Double ukuran=objek.getUkuranLahan();
            String deskripsi=objek.getDeskripsiTanaman();
            String bookedStatus=objek.getBookedStatus();
            indikator++;
            
            ov.add(new model(indikator,jenis,tanggalMulai,tanggalSelesai,lokasi,metode,status,ukuran));
        }
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        jenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        tanggalmulai.setCellValueFactory(new PropertyValueFactory<>("tanggal mulai"));
        tanggalselesai.setCellValueFactory(new PropertyValueFactory<>("tanggal selesai"));
        lokasi.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        metode.setCellValueFactory(new PropertyValueFactory<>("metode"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        ukuran.setCellValueFactory(new PropertyValueFactory<>("ukuran"));
        table.setItems(ov);
        table.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            model model;
            @Override
            public void handle(MouseEvent event) {
               if(table.getSelectionModel().getSelectedItem() !=null){
                   model=table.getSelectionModel().getSelectedItem();
                   System.out.println(model.getJenis());
               }
            }
        } );
        
    
    }

    @FXML
    private void create(ActionEvent event) throws IOException {
        AnchorPane root=FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianPembibitanCreate/create.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void home(ActionEvent event) {
    }

    @FXML
    public void pembibitan(ActionEvent event) {
    }

    @FXML
    public void logout(ActionEvent event) {
    }
    public void pemupukan(ActionEvent event) throws IOException{
        AnchorPane root=FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpemupukan/pemupukan.fxml"));
        layout.getChildren().setAll(root);
    }
    

}

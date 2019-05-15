/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jualprodukcreate;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class CreateController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private TextArea deskripsi;
    @FXML
    private TextField metode;
    @FXML
    private TextField lokasi;
    @FXML
    private TextField banyak;
    @FXML
    private TextField jenis;
    @FXML
    private TextField ukuran;
    @FXML
    private DatePicker tanggalMulai;
    @FXML
    private DatePicker tanggalSelesai;
    @FXML
    private Button choose;
    @FXML
    private TextField harga;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void create(ActionEvent event) {
    }

    @FXML
    private void choose(ActionEvent event) {
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
    
}

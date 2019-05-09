/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pembibitan.Create;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class CreateController implements Initializable {

    @FXML
    private TextField ukuran;
    @FXML
    private TextField jenis;
    @FXML
    private TextField metode;
    @FXML
    private TextField lokasi;
    @FXML
    private Button submit;
    @FXML
    private TextArea deskripsi;
    @FXML
    private DatePicker tglPenanaman;
    @FXML
    private DatePicker tgl_selesai;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insert(ActionEvent event) {
    }
    
}

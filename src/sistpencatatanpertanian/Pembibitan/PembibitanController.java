/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanian.Pembibitan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class PembibitanController implements Initializable {

    @FXML
    private AnchorPane layout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void create() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("FormLogin.fxml"));
        layout.getChildren().setAll(root);
    }

    public void update() {

    }

    public void delete() {

    }

}

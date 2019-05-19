/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import sistpencatatanpertanian.FormLoginController;
import sistpencatatanpertanian.model;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class ProfileController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private Button log;
    @FXML
    private Label notiff;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField notelp;
    @FXML
    private TextField alamat;
    @FXML
    private TextField nama;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session ss = db.util.NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        Query query = ss.createQuery("FROM Akun WHERE id='" + FormLoginController.id_akun + "'");
        List list = query.list();
        ss.getTransaction().commit();
        ss.close();
        for (Object obj : list) {
            entity.Akun akun = (entity.Akun) obj;
            username.setText(akun.getUsername());
            email.setText(akun.getEmail());
            nama.setText(akun.getNama());
            notelp.setText(akun.getNoTelp());
            alamat.setText(akun.getAlamat());
        }

        // TODO
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        FormLoginController.login = false;
        AnchorPane root = FXMLLoader.load(getClass().getResource("FormLogin.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void create(ActionEvent event) throws IOException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("UPDATE Akun SET username='" + username.getText() + "',email='" + email.getText() + "',nama='" + nama.getText() + "',no_telp='" + notelp.getText() + "',alamat='" + alamat.getText() + "' WHERE id= '" + FormLoginController.id_akun + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FXMLDocument.fxml"));
        layout.getChildren().setAll(root);
    }

}

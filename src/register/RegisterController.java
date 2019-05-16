/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class RegisterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane layout;

    @FXML
    private Button btn_create;

    @FXML
    private Button log;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private TextField nama;

    @FXML
    private TextField alamat;

    @FXML
    private PasswordField password;

    @FXML
    private TextField notelp;

    @FXML
    void create(ActionEvent event) throws IOException {
        Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(formatter.format(date));
        String created = formatter.format(date).toString();
        Query query = session.createSQLQuery("INSERT INTO Akun (username,password,email,nama,no_telp,gambar,alamat,status)VALUES(:username, :password, :email, :nama, :notelp, :gambar, :alamat, :status)");
        query.setParameter("username", username.getText().toString());
        query.setParameter("password", password.getText().toString());
        query.setParameter("email", email.getText().toString());
        query.setParameter("nama", nama.getText().toString());
        query.setParameter("notelp", notelp.getText().toString());
        query.setParameter("gambar", "biasa");
        query.setParameter("alamat", alamat.getText().toString());
        query.setParameter("status", 0);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Sukses");
        reg();
    }

    protected void reg() throws IOException{
        AnchorPane root=FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FormLogin.fxml"));
        layout.getChildren().setAll(root);
    }
    @FXML
    void home(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

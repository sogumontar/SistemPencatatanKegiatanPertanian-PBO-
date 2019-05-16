/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanian;

import db.util.NewHibernateUtil;
import entity.Akun;
import entity.Panen;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class FormLoginController implements Initializable {
    public static boolean login=false;
    public static int id_akun=0;
    public static String role="";
    @FXML
    private AnchorPane layout;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label notif;
    @FXML
    private Button reg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void pindah(ActionEvent event) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void login(ActionEvent event) throws IOException {
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        Query q = ses.createQuery("from Akun where username = '" + username.getText() + "' AND password='" + password.getText() + "' AND status!=0 ");
        List list = q.list();
//        q.setParameter("username", username.getText());
//        q.setParameter("password", password.getText());
//        q.executeUpdate();
        ses.getTransaction().commit();
        ses.close();

        if (list.size() > 0) {
             for (Object obj : list) {
            Akun akun = (Akun) obj;
            String roles=akun.getGambar();
            FormLoginController.role=roles;
            FormLoginController.id_akun=akun.getId();
            

        }
            FormLoginController.login=true;
            notif.setText("Sukses");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            notif.setText("wrong Username/Password");
        }
    }

    @FXML
    private void reg(ActionEvent event) throws IOException {
        AnchorPane root=FXMLLoader.load(getClass().getResource("/register/register.fxml"));
        layout.getChildren().setAll(root);
    }
    

}

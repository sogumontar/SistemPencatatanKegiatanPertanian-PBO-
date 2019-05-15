/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpanen;

import entity.Panen;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class DetailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static int id = 0;
    @FXML
    private AnchorPane layout;
    @FXML
    private Text ukuran;
    @FXML
    private Text jenis;
    @FXML
    private Text tglMulai;
    @FXML
    private Text tglSelesai;
    @FXML
    private Text deskripsi;
    @FXML
    private Text lokasi;
    @FXML
    private Text metode;
    @FXML
    private Text harga;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session ss = db.util.NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();

        Query query = ss.createQuery("FROM Bantuan where id= " + id + "");
        List list = query.list();
        ss.getTransaction().commit();
        ss.close();
        int i = 1;
        String test = "";
        for (Object obj : list) {
            
            Panen ban = (Panen) obj;
            String aa=Double.toHexString(ban.getUkuranLalhan());
            ukuran.setText(aa);
            test = ban.getCaraPanen();

            i++;
        }
        System.out.println(test);
    }

}

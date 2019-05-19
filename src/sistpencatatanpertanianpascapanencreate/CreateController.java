/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpascapanencreate;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.hibernate.Query;
import org.hibernate.Session;
import sistpencatatanpertanian.FormLoginController;

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
    private TextField jenis;
    @FXML
    private TextField ukuran;
    @FXML
    private DatePicker tanggalMulai;
    @FXML
    private DatePicker tanggalSelesai;
    private Path copy;
    private Path files;
    @FXML
    private Button choose;
    private FileChooser fileChooser;
    private File file;
    private String gambar;
    @FXML
    private TextField banyak;
    @FXML
    private TextField harga;
    private TextField jumlah;
    private TextField nama;
    @FXML
    private Button log;
    @FXML
    private Label notiff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*jpeg", "*.bmp")
        );
    }

    @FXML
    public void choose() throws IOException {
        file = fileChooser.showOpenDialog(null);
        if (file != null) {

            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);

            gambar = file.getName();
            files = Paths.get(file.toURI());
            System.out.println(gambar);
            System.out.println(files);

        }
    }

    @FXML
    public void create(ActionEvent event) throws IOException {

        if (gambar != null) {
            File dir = new File(System.getProperty("user.dir"));
            copy = Paths.get(dir + "\\src\\sistpencatatanpertanianpascapanencreate\\images\\" + gambar);
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            Files.copy(files, copy, options);

        }
        if (ukuran.getText().equals("")||jenis.getText().equals("")||banyak.getText().equals("")||tanggalMulai.getValue().equals("")||tanggalSelesai.getValue().equals("")||lokasi.getText().equals("")) {
            notiff.setText("SEMUA FIELD HARUS DI ISI");
        } else {

            Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            System.out.println(formatter.format(date));
            String created = formatter.format(date).toString();
            int hrg = Integer.parseInt(harga.getText());
            Query query = session.createSQLQuery("INSERT INTO pasca_panen (created_at,ukuran_lalhan,jenis_tanaman,tanggal_mulai_panen,tanggal_selesai_panen,deskripsi_tanaman,banyak_hasil_panen,lokasi,cara_panen,harga,quantity,status,booked_status,gambar)VALUES(:created, :ukuran, :jenis, :tanggalM, :tanggalS, :deskripsi, :banyak, :lokasi, :cara, :harga, :quantity, :status, :booked, :gambar)");
            query.setParameter("created", created);
            query.setParameter("ukuran", ukuran.getText().toString());
            query.setParameter("jenis", jenis.getText().toString());
            query.setParameter("tanggalM", tanggalMulai.getValue().toString());
            query.setParameter("tanggalS", tanggalSelesai.getValue().toString());
            query.setParameter("lokasi", lokasi.getText().toString());
            query.setParameter("deskripsi", deskripsi.getText().toString());
            query.setParameter("cara", metode.getText().toString());
            query.setParameter("harga", harga.getText());
            query.setParameter("banyak", banyak.getText());
            query.setParameter("quantity", banyak.getText());
            query.setParameter("status", "normal");
            query.setParameter("booked", "normal");
            query.setParameter("gambar", gambar);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Sukses");
            pascaPanen();
        }
    }

    @FXML
    public void home() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void pembibitan() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpembibitan/pembibitan.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void pemupukan() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpemupukan/pemupukan.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void penanaman() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpenanaman/penanaman.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void panen() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FXMLDocument.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    public void pascaPanen() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpascapanen/pascapanen.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        FormLoginController.login = false;
        AnchorPane root = FXMLLoader.load(getClass().getResource("FormLogin .fxml"));
        layout.getChildren().setAll(root);
    }

}

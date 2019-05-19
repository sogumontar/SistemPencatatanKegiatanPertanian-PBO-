/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistpencatatanpertanianpenanamancreate;

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

/**
 * FXML Controller class
 *
 * @author DedekManisTasBiru
 */
public class CreateController implements Initializable {

    private Path copy;
    private Path files;
    private FileChooser fileChooser;
    private File file;
    private String gambar;
    @FXML
    private AnchorPane layout;
    @FXML
    private TextArea deskripsi;
    @FXML
    private TextField metode;
    @FXML
    private TextField lokasi;
    @FXML
    private TextField bibit;
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
    private void choose(ActionEvent event) throws IOException {
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
    private void create(ActionEvent event) throws IOException {

        if (gambar != null) {
            File dir = new File(System.getProperty("user.dir"));
            copy = Paths.get(dir + "\\src\\sistpencatatanpertanianpenanamancreate\\images\\" + gambar);
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            if (ukuran.getText().equals("") || jenis.getText().equals("") || bibit.getText().equals("") || tanggalMulai.getValue().equals("") || tanggalSelesai.getValue().equals("") || lokasi.getText().equals("") || metode.getText().equals("") || deskripsi.getText().equals("")) {
                notiff.setText("SEMUA FIELD HARUS DI ISI");
            } else {
                Files.copy(files, copy, options);
                Session session = db.util.NewHibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                System.out.println(formatter.format(date));
                String created = formatter.format(date).toString();

                Query query = session.createSQLQuery("INSERT INTO penanaman (created_at,ukuran_lahan,jenis_tanaman,jenis_bibit,tanggal_mulai_pemupukan,tanggal_selesai_pemupukan,deskripsi_tanaman,lokasi,cara_penanaman,status,booked_status,gambar)VALUES(:created, :ukuran, :jenis, :bibit, :tanggalM, :tanggalS, :deskripsi, :lokasi, :cara, :status, :booked, :gambar)");
                query.setParameter("created", created);
                query.setParameter("ukuran", ukuran.getText().toString());
                query.setParameter("jenis", jenis.getText().toString());
                query.setParameter("bibit", bibit.getText().toString());
                query.setParameter("tanggalM", tanggalMulai.getValue().toString());
                query.setParameter("tanggalS", tanggalSelesai.getValue().toString());
                query.setParameter("deskripsi", deskripsi.getText().toString());
                query.setParameter("lokasi", lokasi.getText().toString());
                query.setParameter("cara", metode.getText().toString());
                query.setParameter("status", "normal");
                query.setParameter("booked", "normal");
                query.setParameter("gambar", gambar);
                query.executeUpdate();
                session.getTransaction().commit();
                session.close();
                System.out.println("Sukses");
                penanamans();
            }
        }else{
            notiff.setText("SEMUA FIELD HARUS DI ISI");
        }
    }

    private void penanamans() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpenanaman/penanaman.fxml"));
        layout.getChildren().setAll(root);
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
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanianpanen/panen.fxml"));
        layout.getChildren().setAll(root);
    }

    public void pascapanen() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/sistpencatatanpertanian/FXMLDocument.fxml"));
        layout.getChildren().setAll(root);
    }

    @FXML
    private void pascaPanen(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

}

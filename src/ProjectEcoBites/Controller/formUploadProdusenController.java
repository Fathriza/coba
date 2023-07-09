package ProjectEcoBites.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import ProjectEcoBites.OpenScene;
import ProjectEcoBites.Model.Konsumen;
import ProjectEcoBites.Model.Produk;
import ProjectEcoBites.Model.Produsen;

public class formUploadProdusenController implements Initializable {
    ArrayList<Produk> produk = new ArrayList<>();
    XStream xst = new XStream(new StaxDriver());
    
    void produkXML(){
        FileInputStream input = null;
        xst.addPermission(AnyTypePermission.ANY);
        xst.allowTypesByWildcard(new String[]{"ProjectEcoBites.Model.Produk"});
        try {
            input = new FileInputStream("produk.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1){
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            produk = (ArrayList<Produk>) xst.fromXML(stringnya);
        }
        catch (Exception e){
            System.err.println("test: " + e.getMessage());
        }
        finally {
            if (input != null){
                try{
                    input.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField uploadNama;

    @FXML
    private TextField uploadDeskripsi;

    @FXML
    private TextField uploadWaktu;

    @FXML
    private TextField uploadStok;

    @FXML
    private TextField uploadAlamat;
    
    @FXML
    private ImageView imageView;

    @FXML
    private void keUploadMakanan(ActionEvent event) {
        
        
        produk.add(new Produk(uploadNama.getText(), uploadDeskripsi.getText(), uploadWaktu.getText(), Integer.parseInt(uploadStok.getText()),uploadAlamat.getText()));  
                    // produsen.add(new Produsen("al", "ui", "iu"));
                String xml = xst.toXML(produk);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("produk.xml");
                            byte[] bytes = xml.getBytes("UTF-8");
                            output.write(bytes);
                            OpenScene object = new OpenScene();
                            Pane halaman = object.getPane("LihatProdusen");
                            mainPane.setCenter(halaman);
                            mainPane.requestFocus();
                        }
                        catch (Exception e){
                            System.err.println("Perhatian: " + e.getMessage());
                        }
                        finally {
                            if (output != null){
                                try {
                                    output.close();
                                }
                                catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                        }
  
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("LihatProdusen");
        mainPane.setCenter(halaman);
    }

    

    @FXML
    private void uploadFoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Foto");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) mainPane.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // Menggunakan file yang dipilih untuk menampilkan gambar di ImageView
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        produkXML();
    }
}

package ProjectEcoBites.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import ProjectEcoBites.OpenScene;
import ProjectEcoBites.Model.Produk;
import ProjectEcoBites.Model.Produsen;

public class LihatProdusenController implements Initializable {
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
    private TextArea tampilDeskripsi;

     @FXML
    private TextArea tampilDeskripsi1;

     @FXML
    private TextArea tampilDeskripsi2;
    
    @FXML
    private void keLihat(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("TampilanLihatProdusen");
        mainPane.setCenter(halaman);
    }

     @FXML
    private void keEdit(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("editFormProdusen");
        mainPane.setCenter(halaman);
    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        produkXML();
        for (int i =0 ;i <produk.size() ;i++){
         Produk pro = (Produk) produk.get(i);
         
        if (i == 0) {
            tampilDeskripsi.setText(
                "\nNama \t: " + pro.getnama() +
                "\nAlamat \t: " + pro.getalamat() +
                "\nWaktu \t: " + pro.getwaktu() +
                "\nStok \t: " + pro.getstok() +
                "\nDeskripsi \t: " + pro.getdeskripsi()
            );
        } else if (i == 1) {
            tampilDeskripsi1.setText(
                "\nNama \t: " + pro.getnama() +
                "\nAlamat \t: " + pro.getalamat() +
                "\nWaktu \t: " + pro.getwaktu() +
                "\nStok \t: " + pro.getstok() +
                "\nDeskripsi \t: " + pro.getdeskripsi()
            );
        } else if (i == 1) {
            tampilDeskripsi2.setText(
                "\nNama \t: " + pro.getnama() +
                "\nAlamat \t: " + pro.getalamat() +
                "\nWaktu \t: " + pro.getwaktu() +
                "\nStok \t: " + pro.getstok() +
                "\nDeskripsi \t: " + pro.getdeskripsi()
            );
    }
                    
                    
                }
        }
}
        
     




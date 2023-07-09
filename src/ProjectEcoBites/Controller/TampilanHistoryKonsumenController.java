package ProjectEcoBites.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

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

public class TampilanHistoryKonsumenController implements Initializable {
       ArrayList<Konsumen> konsumen = new ArrayList<>();
       ArrayList<Produk> produk = new ArrayList<>();
       XStream xst = new XStream(new StaxDriver());
       
       void bukaXML(){
        FileInputStream input = null;
        xst.addPermission(AnyTypePermission.ANY);
        xst.allowTypesByWildcard(new String[]{"ProjectEcoBites.Model.Konsumen"});
        try {
            input = new FileInputStream("datakonsumen.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1){
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            konsumen = (ArrayList<Konsumen>) xst.fromXML(stringnya);
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
    private TextArea tampilDeskripKonsumen;

    @FXML
    private TextArea tampilDeskripKonsumen1;

    @FXML
    private TextArea tampilDeskripKonsumen2;

    @FXML
    private TextArea tampilDeskripKonsumen3;

   

    
    @FXML
    private void keOrderMakan(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("TampilanUtamaKonsumen");
        mainPane.setCenter(halaman);
    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bukaXML();
        produkXML();

                for(int j = 0; j < konsumen.size(); j++){
                    Konsumen kons = (Konsumen)konsumen.get(j);
                    if(kons.getpilih()==true){
                        ProjectEcoBites.Model.ArrayList<Produk> orderan=kons.getorderan();
                        for (int i = 0; i < orderan.size(); i ++){
                            Produk prod=(Produk)orderan.get(i);
                            System.out.println(prod.getstok());
                        }

                        for(int i = 0; i < orderan.size(); i++){
                            Produk prod = (Produk)orderan.get(i);
                            System.out.println(prod.getnama());
                            if (i == 0) {
                                tampilDeskripKonsumen.setText(
                                    "\nNama \t: " + prod.getnama() +
                                    "\nAlamat \t: " + prod.getalamat() +
                                    "\nWaktu \t: " + prod.getwaktu() +
                                    "\nStok \t: " + prod.getstok() +
                                    "\nDeskripsi \t: " + prod.getdeskripsi()
                                );
                                
                            } else if (i == 1) {
                                tampilDeskripKonsumen1.setText(
                                    "\nNama \t: " + prod.getnama() +
                                    "\nAlamat \t: " + prod.getalamat() +
                                    "\nWaktu \t: " + prod.getwaktu() +
                                    "\nStok \t: " + prod.getstok() +
                                    "\nDeskripsi \t: " + prod.getdeskripsi()
                                );
                            }
                        }

                        break;
                       
                                        
                       
                        }
                    }

    } 
}



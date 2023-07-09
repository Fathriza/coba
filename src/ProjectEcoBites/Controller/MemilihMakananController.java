package ProjectEcoBites.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

public class MemilihMakananController implements Initializable {

    ArrayList<Produk> produk = new ArrayList<>();
    ArrayList<Konsumen> konsumen = new ArrayList<>();
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
   
    @FXML
    private BorderPane mainPane;

    @FXML
    private TextArea tampilDeskripPilih;

    @FXML
    private TextField jumlahStok;
    
    @FXML
    private void keHistoryKonsumen(ActionEvent event) {
        boolean sudahOrder=false;

        for(int i = 0; i< produk.size();i++){
            Produk prod=(Produk)produk.get(i);
            if(i ==0){
                prod.setstok(prod.getstok() - Integer.parseInt(jumlahStok.getText()));
                    String xml = xst.toXML(produk);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("produk.xml");
                            byte[] bytes = xml.getBytes("UTF-8");
                            output.write(bytes);
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

                prod.setstok(Integer.parseInt(jumlahStok.getText()));
                for(int j = 0; j < konsumen.size(); j++){
                    Konsumen kons = (Konsumen)konsumen.get(j);
                    if(kons.getpilih()==true){
                        ProjectEcoBites.Model.ArrayList<Produk> orderan=kons.getorderan();
                        if(orderan==null){
                            kons.setorderan(new ProjectEcoBites.Model.ArrayList<>());
                        }
                        
                        kons.getorderan().add(prod);
                        String xml2 = xst.toXML(konsumen);
                        FileOutputStream output2 = null;
                        try{
                            output2 = new FileOutputStream("datakonsumen.xml");
                            byte[] bytes = xml2.getBytes("UTF-8");
                            output2.write(bytes);
                            OpenScene object=new OpenScene();
                            Pane halaman=object.getPane("TampilanUtamaKonsumen");
                            mainPane.setCenter(halaman);
                        }
                            catch (Exception e){
                                System.err.println("Perhatian: " + e.getMessage());
                            }
                            finally {
                                if (output2 != null){
                                    try {
                                        output2.close();
                                    }
                                    catch (IOException e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                            
                        }
                    }
                    break;
            }
            
        }

        
        // OpenScene object=new OpenScene();
        // Pane halaman=object.getPane("HistoryKonsumen");
        // mainPane.setCenter(halaman);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         produkXML();
         bukaXML();
        for (int i =0 ;i <produk.size() ;i++){
         Produk pro = (Produk) produk.get(i);
         
        if (i == 0) {
            tampilDeskripPilih.setText(
                "\nNama \t: " + pro.getnama() +
                "\nAlamat \t: " + pro.getalamat() +
                "\nWaktu \t: " + pro.getwaktu() +
                "\nStok \t: " + pro.getstok() +
                "\nDeskripsi \t: " + pro.getdeskripsi()
            );
            break;}
       
    }
                    
                    
                }
    } 



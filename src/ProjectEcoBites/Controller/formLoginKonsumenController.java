package ProjectEcoBites.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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

public class formLoginKonsumenController implements Initializable {
   ArrayList<Konsumen> konsumen = new ArrayList<>();
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
    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField passLogKonsumen;

    @FXML
    private TextField emailLogKonsumen;
    
    @FXML
    private void keTampilanUtamaKonsumen(ActionEvent event) {
        for(int i = 0 ; i < konsumen.size();i++){
                    Konsumen kons = (Konsumen)konsumen.get(i);
                    if(emailLogKonsumen.getText().equals(kons.getemail()) && passLogKonsumen.getText().equals(kons.getpassword())){
                        kons.setpilih(true);
                         String xml = xst.toXML(konsumen);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("datakonsumen.xml");
                            byte[] bytes = xml.getBytes("UTF-8");
                            output.write(bytes);
                            OpenScene object=new OpenScene();
                            Pane halaman=object.getPane("TampilanUtamaKonsumen");
                            mainPane.setCenter(halaman);
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

                       
                        
                        break;
                    }
                }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bukaXML();
    } 
}

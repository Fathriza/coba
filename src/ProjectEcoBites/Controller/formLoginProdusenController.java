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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import ProjectEcoBites.OpenScene;
import ProjectEcoBites.Model.Konsumen;
import ProjectEcoBites.Model.Produsen;

public class formLoginProdusenController implements Initializable {
    ArrayList<Produsen> produsen = new ArrayList<>();
    XStream xst = new XStream(new StaxDriver());

    void bukaXML2(){
        FileInputStream input = null;
        xst.addPermission(AnyTypePermission.ANY);
        xst.allowTypesByWildcard(new String[]{"ProjectEcoBites.Model.Produsen"});
        try {
            input = new FileInputStream("dataprodusen.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya = "";
            while ((isi = input.read()) != -1){
                charnya = (char) isi;
                stringnya = stringnya + charnya;
            }
            produsen = (ArrayList<Produsen>) xst.fromXML(stringnya);
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
    private TextField emailLogProdusen;

    @FXML
    private TextField passLogProdusen;
    
    @FXML
    private void keTampilanUtamaP(ActionEvent event) {
       for(int i = 0 ; i < produsen.size();i++){
                    Produsen prods = (Produsen)produsen.get(i);
                    if(emailLogProdusen.getText().equals(prods.getemail()) && passLogProdusen.getText().equals(prods.getpassword())){
                        OpenScene object=new OpenScene();
                        Pane halaman=object.getPane("Tampilanutamaprodusen");
                        mainPane.setCenter(halaman);
                        
                        break;
                    }
                }
    }
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bukaXML2();
    } 
}

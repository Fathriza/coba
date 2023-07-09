package ProjectEcoBites.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
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
import ProjectEcoBites.Model.Produsen;

public class SignUpController implements Initializable {

    ArrayList<Konsumen> konsumen = new ArrayList<>();
    ArrayList<Produsen> produsen = new ArrayList<>();
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
    private RadioButton RBKonsumen;

    @FXML
    private RadioButton RBProdusen;

    @FXML
    private ToggleGroup RadioButton;

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField txtfldemail;

    @FXML
    private TextField txtfldnama;

    @FXML
    private PasswordField passfldpass;


    
    // @FXML
    // private void keLoginPage(ActionEvent event) {
    //     OpenScene object=new OpenScene();
    //     Pane halaman=object.getPane("LoginPage");
    //     mainPane.setCenter(halaman);
    // }

    @FXML
    private void daftarUser(ActionEvent event) {
        boolean Emailada = false;

        if(RBProdusen.isSelected()){
             System.out.println("afsdtty");
                    if(txtfldnama.getText()=="" && txtfldemail.getText()=="" && passfldpass.getText()==""){
                Alert alert = new Alert(AlertType.ERROR,"Data harap diisi");
                alert.showAndWait();
            }
            else{
                for(int i = 0 ; i < produsen.size();i++){
                    Produsen prods = (Produsen)produsen.get(i);
                    if(prods.getemail().equals(txtfldemail.getText())){
                        Alert alert = new Alert(AlertType.WARNING, "Email sudah terdaftar!");
                        Emailada = true;
                        break;
                    }
                }
                if(!Emailada){
                    produsen.add(new Produsen(txtfldnama.getText(), txtfldemail.getText(), passfldpass.getText()));  
                    // produsen.add(new Produsen("al", "ui", "iu"));
                String xml = xst.toXML(produsen);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("dataprodusen.xml");
                            byte[] bytes = xml.getBytes("UTF-8");
                            output.write(bytes);
                            OpenScene object = new OpenScene();
                            Pane halaman = object.getPane("Tampilanutamaprodusen");
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

                }
              
              
            }
            
            // OpenScene object=new OpenScene();
            // Pane halaman=object.getPane("Tampilanutamaprodusen");
            // mainPane.setCenter(halaman);
        }
        else if(RBKonsumen.isSelected()){
            if(txtfldnama.getText()=="" && txtfldemail.getText()=="" && passfldpass.getText()==""){
                Alert alert = new Alert(AlertType.ERROR,"Data harap diisi");
                alert.showAndWait();
            }
            else{
                for(int i = 0 ; i < konsumen.size();i++){
                    Konsumen kons = (Konsumen)konsumen.get(i);
                    if(kons.getemail().equals(txtfldemail.getText())){
                        Alert alert = new Alert(AlertType.WARNING, "Email sudah terdaftar!");
                        Emailada = true;
                        break;
                    }
                }
                if(!Emailada){
                    konsumen.add(new Konsumen(txtfldnama.getText(), txtfldemail.getText(), passfldpass.getText()));  
                String xml = xst.toXML(konsumen);
                        FileOutputStream output = null;
                        try{
                            output = new FileOutputStream("datakonsumen.xml");
                            byte[] bytes = xml.getBytes("UTF-8");
                            output.write(bytes);
                            OpenScene object = new OpenScene();
                            Pane halaman = object.getPane("TampilanUtamaKonsumen");
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

                }
              
              
            }
        //     OpenScene object=new OpenScene();
        // Pane halaman=object.getPane("TampilanUtamaKonsumen");
        // mainPane.setCenter(halaman);
        }
    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bukaXML();
        bukaXML2();
        System.out.println("Size Konsumen" +konsumen.size());
    } 
}

package ProjectEcoBites.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProjectEcoBites.OpenScene;

public class TampilanUtamaProdusenController implements Initializable {
   
    @FXML
    private BorderPane mainPane;
    
    @FXML
    private void keUploadMakan(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("formUploadProdusen");
        mainPane.setCenter(halaman);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}


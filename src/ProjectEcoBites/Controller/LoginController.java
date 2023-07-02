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

public class LoginController implements Initializable {
   
    @FXML
    private BorderPane mainPane;
    
    
    @FXML
    private void keloginKonsumen(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("formLoginKonsumen");
        mainPane.setCenter(halaman);
    }
    @FXML
    private void keloginProdusen(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman=object.getPane("formLoginProdusen");
        mainPane.setCenter(halaman);
    }

   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}

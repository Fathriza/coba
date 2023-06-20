package ProjectEcoBites;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderMakananProdusenC {

    @FXML
    private Button uploadButton;

    @FXML
    private void showPilihMakanan(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UploadMakanan.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Pilih Makanan");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}









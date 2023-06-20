package ProjectEcoBites;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class LoginController {

    @FXML
    private Button formLoginProdusenButton;

    @FXML
    private Button formLoginKonsumenButton;

    private LandingPage mainApp;

    public void setMainApp(LandingPage mainApp) {
        this.mainApp = mainApp;
    }

@FXML
private void initialize() {
    System.out.println("LoginController initialized"); // Tambahkan baris ini

    formLoginProdusenButton.setOnAction(event -> {
        try {
            mainApp.showFormLoginProdusen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    });

    formLoginKonsumenButton.setOnAction(event -> {
        try {
            mainApp.showFormLoginKonsumen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
}
}
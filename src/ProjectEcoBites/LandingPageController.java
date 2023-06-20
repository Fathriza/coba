package ProjectEcoBites;

import javafx.fxml.FXML;

import java.io.IOException;

    public class LandingPageController {

    private LandingPage mainApp;

    public void setMainApp(LandingPage mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLoginButton() throws IOException {
        mainApp.showLoginPage();
    }

    @FXML
    private void handleSignUpButton() throws IOException {
        mainApp.showSignUpPage();
    }
}



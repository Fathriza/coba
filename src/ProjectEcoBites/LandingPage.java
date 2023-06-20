package ProjectEcoBites;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LandingPage extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LandingPage.fxml"));
        Parent root = loader.load();

        LandingPageController controller = loader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Landing Page");
        primaryStage.show();
    }

    public void showLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();

        Stage loginStage = new Stage();
        loginStage.setTitle("Login");
        loginStage.initOwner(primaryStage); // Set the owner stage

        Scene scene = new Scene(root);
        loginStage.setScene(scene);

        // Show the login scene
        loginStage.show();
    }

    public void showSignUpPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = loader.load();

        Stage signUpStage = new Stage();
        signUpStage.setTitle("Sign Up");
        signUpStage.initOwner(primaryStage); // Set the owner stage

        Scene scene = new Scene(root);
        signUpStage.setScene(scene);

        // Show the sign up scene
        signUpStage.show();
    }

    public void showFormLoginProdusen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormLoginProdusen.fxml"));
        Parent root = loader.load();

        Stage formLoginProdusenStage = new Stage();
        formLoginProdusenStage.setTitle("Form Login Produsen");
        formLoginProdusenStage.initOwner(primaryStage); // Set the owner stage

        Scene scene = new Scene(root);
        formLoginProdusenStage.setScene(scene);

        // Show the form login produsen scene
        formLoginProdusenStage.show();
    }

    public void showFormLoginKonsumen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormLoginKonsumen.fxml"));
        Parent root = loader.load();

        Stage formLoginKonsumenStage = new Stage();
        formLoginKonsumenStage.setTitle("Form Login Konsumen");
        formLoginKonsumenStage.initOwner(primaryStage); // Set the owner stage

        Scene scene = new Scene(root);
        formLoginKonsumenStage.setScene(scene);

        // Show the form login konsumen scene
        formLoginKonsumenStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

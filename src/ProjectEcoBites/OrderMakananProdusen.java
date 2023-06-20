package ProjectEcoBites;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderMakananProdusen extends Application {

    private Stage primaryStage; // Menyimpan stage utama

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage; // Menyimpan stage utama
        Parent root = FXMLLoader.load(getClass().getResource("OrderMakananProdusen.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Order Makanan");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showUploadMakananDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UploadMakanan.fxml"));
        Parent root = loader.load();

        Stage uploadStage = new Stage();
        uploadStage.setTitle("Upload Makanan");
        uploadStage.initModality(Modality.WINDOW_MODAL);
        uploadStage.initOwner(primaryStage); // Menggunakan stage utama sebagai owner

        Scene scene = new Scene(root);
        uploadStage.setScene(scene);

        // Menutup scene OrderMakananProdusen dan menampilkan scene UploadMakanan
        primaryStage.hide();
        uploadStage.showAndWait();

        // Menampilkan kembali scene OrderMakananProdusen setelah scene UploadMakanan ditutup
        primaryStage.show();
    }
}

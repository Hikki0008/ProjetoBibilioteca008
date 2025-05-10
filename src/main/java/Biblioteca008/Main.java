package Biblioteca008;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

    public class Main extends Application {
        @Override
        public void start(Stage primaryStage) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Biblioteca008/Views/Login.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setTitle("Tela de Login");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            launch(args);
        }
    }


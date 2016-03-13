package structvisualizer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    public static final double W = 200; // canvas dimension
    public static final double H = 200;

    public  static final double D = 20; // diameter

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setOnCloseRequest(e -> {
            askExit();
        });

        Parent root = FXMLLoader.load(getClass().getResource("structvisualizer.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(820);
        primaryStage.setMinHeight(620);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void askExit() {
        ConfirmBox.display("Confirm exit", "Do you really wan't to exit?");

    }

    public static void showAbout() {
        if(AboutWindow.display()) {
            Platform.exit();
            System.exit(0);
        }
    }
}

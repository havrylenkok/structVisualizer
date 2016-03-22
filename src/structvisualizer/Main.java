package structvisualizer;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import parser.SomeClass;

/**
 * Main javafx class
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setOnCloseRequest(e -> {
            if (askExit()) {
                primaryStage.close();
            } else {
                e.consume();
            }
        });

        Parent root = FXMLLoader.load(getClass().getResource("structvisualizer.fxml"));
        primaryStage.setTitle("Data Structure Visualizer");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(820);
        primaryStage.setMinHeight(620);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Shows user new window with confirmation whether he actually want to close app
     *
     * @return true if still wanted, false if dont want
     */
    public static boolean askExit() {
        return ConfirmBox.display("Confirm exit", "Do you really wan't to exit?");
    }

    /**
     * Shows user new window with about information of the app
     */
    public static void showAbout() {
        if (AboutWindow.display()) {
            Platform.exit();
            System.exit(0);
        }
    }

    public static SomeClass showCustomClassDialog() {
       return InputClassWindow.display();
    }
}

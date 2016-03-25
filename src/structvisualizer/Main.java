package structvisualizer;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parser.SomeClass;
import structvisualizer.window.AboutWindow;
import structvisualizer.window.ConfirmBoxWindow;
import structvisualizer.window.InputClassWindow;
import structvisualizer.window.InputWindow;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main javafx class
 */
public class Main extends Application {
    private static final Handler handler = new ConsoleHandler();
    private static final Logger logger = Logger.getLogger(SomeClass.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setOnCloseRequest(e -> {
            if (askExit()) {
                logger.log(Level.INFO, "Closing app");
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
        return ConfirmBoxWindow.display("Confirm exit", "Do you really wan't to exit?");
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

    public static String showInput() {
        return InputWindow.display();
    }

    public static SomeClass showCustomClassDialog() {
       return InputClassWindow.display();
    }
}

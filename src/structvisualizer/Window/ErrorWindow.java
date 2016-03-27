package structvisualizer.window;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * shows user error message
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class ErrorWindow {
    static boolean answer;

    /**
     * @param message
     *
     * @return
     */
    public static boolean display(String message) {
        Stage window = new Stage(); // пустое окно (stage)

        window.initModality(Modality.APPLICATION_MODAL); // make stage modal (нельзя переключить обратно, не закрыв это)
        window.setTitle("Error!");
        window.setMinWidth(500);
        window.setMaxWidth(500);
        window.setMaxHeight(200);

        Text error = new Text(message);

        javafx.scene.control.Button okay = new javafx.scene.control.Button("Okay");
        okay.setOnAction(event -> {
            event.consume();
            window.close();
        });
        okay.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(error, okay);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new javafx.geometry.Insets(10));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // fn+f1 to see documentation | ждет пока окно закроется прежде чем показывать другу сцену

        return answer;
    }
}

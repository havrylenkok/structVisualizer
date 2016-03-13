package structvisualizer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by robben1 on 23.02.16.
 */
public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window  = new Stage(); // пустое окно (stage)

        window.initModality(Modality.APPLICATION_MODAL); // make stage modal (нельзя переключить обратно, не закрыв это)
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox buttons = new HBox(3);
        buttons.getChildren().addAll(yesButton, noButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(label, buttons);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // fn+f1 to see documentation | ждет пока окно закроется прежде чем показывать другу сцену

        return answer;
    }


}

package structvisualizer;

 /*
 * InputClassWindow   3/22/16, 15:36
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import parser.SomeClass;

import java.net.URI;
import java.util.HashMap;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class InputClassWindow {
    static boolean answer;


    public static SomeClass display() {
        Stage window = new Stage(); // пустое окно (stage)
        String[] types = { "int", "double", "String", "char" };
        ObservableList<Integer> values = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5);

        window.initModality(Modality.APPLICATION_MODAL); // make stage modal (нельзя переключить обратно, не закрыв это)
        window.setTitle("Custom class constructor");
        window.setMinWidth(400);
        window.setMaxWidth(400);
        window.setMaxHeight(250);
        window.setMinHeight(250);

        HBox codeContainer = new HBox();
        codeContainer.setSpacing(10);
        codeContainer.setAlignment(Pos.CENTER_LEFT);


        VBox comboContainer = new VBox();
        HashMap<String, ComboBox> comboboxes = new HashMap<>();
        for(int i = 0; i < types.length; i++) {
            comboboxes.put(types[i], new ComboBox(values));
            comboboxes.get(types[i]).getSelectionModel().select(values.get(0));
        }
        HashMap<String, Label> labels = new HashMap<>();
        for(int i = 0; i < types.length; i++) {
            Label l = new Label("Number of " + types[i] + "s: ");
            l.setLabelFor(comboboxes.get(types[i]));
            labels.put(types[i], l);
        }
        for(int i = 0; i < types.length; i++) {
            comboContainer.getChildren().addAll(labels.get(types[i]), comboboxes.get(types[i]));
        }

        codeContainer.getChildren().addAll(comboContainer);
        codeContainer.setHgrow(comboContainer, Priority.ALWAYS);

        VBox buttons = new VBox();
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.BOTTOM_LEFT);

        Button setCustomClass = new Button("Set a custom class");
        setCustomClass.setMinWidth(150);
        setCustomClass.setOnAction(event -> {
            event.consume();
            window.close();
        });

        buttons.getChildren().addAll(setCustomClass);

        HBox layout = new HBox(10);
        layout.setSpacing(10);
        layout.getChildren().addAll(codeContainer, buttons);
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setPadding(new javafx.geometry.Insets(10));
        layout.setHgrow(codeContainer, Priority.ALWAYS);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // fn+f1 to see documentation | ждет пока окно закроется прежде чем показывать другу сцену

        return new SomeClass(Integer.parseInt(comboboxes.get(types[0]).getValue().toString()),
                             Integer.parseInt(comboboxes.get(types[1]).getValue().toString()),
                             Integer.parseInt(comboboxes.get(types[2]).getValue().toString()),
                             Integer.parseInt(comboboxes.get(types[3]).getValue().toString()));
    }
}

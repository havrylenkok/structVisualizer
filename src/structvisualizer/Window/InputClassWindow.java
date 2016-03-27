package structvisualizer.window;

 /*
 * InputClassWindow   3/22/16, 15:36
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import parser.SomeClass;
import structvisualizer.Main;
import structvisualizer.data.Types;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class InputClassWindow {
    private static final Logger logger = Logger.getLogger(InputClassWindow.class.getName());
    static boolean answer;
    static SomeClass sc = null;


    /**
     * @return
     */
    public static SomeClass display() {
        String[] userInput = new String[1];
        userInput[0] = "";
        Stage window = new Stage(); // пустое окно (stage)
        String[] types = { "int", "double", "String", "char" };
        ObservableList<Integer> values = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5);

        window.initModality(Modality.APPLICATION_MODAL); // make stage modal (нельзя переключить обратно, не закрыв это)
        window.setTitle("Custom class constructor");
        window.setMinWidth(420);
        window.setMaxWidth(420);
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
            if(types[i] == Types.STRING) {
                HBox containerInputString = new HBox();
                containerInputString.setSpacing(10);
                Button inputString = new Button("Create a custom String");
                inputString.setMinWidth(170);
                inputString.setOnAction(event -> {
                    event.consume();
                    userInput[0] = Main.showInput();
                });
                comboboxes.get((types[i])).getSelectionModel().select(values.get(0));
                containerInputString.getChildren().addAll(comboboxes.get(types[i]), inputString);
                comboContainer.getChildren().addAll(labels.get(types[i]), containerInputString);
            } else {
                comboContainer.getChildren().addAll(labels.get(types[i]), comboboxes.get(types[i]));
            }
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
            sc = new SomeClass(Integer.parseInt(comboboxes.get(types[0]).getValue().toString()),
                               Integer.parseInt(comboboxes.get(types[1]).getValue().toString()),
                               Integer.parseInt(comboboxes.get(types[2]).getValue().toString()),
                               Integer.parseInt(comboboxes.get(types[3]).getValue().toString()));
            if(!userInput[0].isEmpty()) {
                sc = new SomeClass(Integer.parseInt(comboboxes.get(types[0]).getValue().toString()),
                                   Integer.parseInt(comboboxes.get(types[1]).getValue().toString()),
                                   Integer.parseInt(comboboxes.get(types[2]).getValue().toString()),
                                   Integer.parseInt(comboboxes.get(types[3]).getValue().toString()),
                                   userInput[0]);
            }
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

        logger.log(Level.FINE, "User input is empty?" + userInput[0].isEmpty());
        return sc;
    }
}

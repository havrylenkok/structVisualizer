package structvisualizer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import parser.SomeClass;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller of javafx app
 */
public class Controller implements Initializable {

    @FXML
    Button animateButton;
    @FXML
    ComboBox collectionBox;
    @FXML
    ComboBox methodBox;
    @FXML
    ComboBox typeBox;
    @FXML
    Pane canvasPane;
    @FXML
    TextArea codeOutput;
    @FXML
    TextArea output;
    @FXML
    MenuItem menuItemClose;
    @FXML
    MenuItem menuItemAbout;
    SomeClass customClass = null;

    private boolean checkIfComboxesIsNotNull() {

        if (collectionBox.getSelectionModel().getSelectedItem() != null && methodBox.getSelectionModel()
                .getSelectedItem() != null && checkIfTypeNotNull()) {
            return true;
        } else return false;
    }

    private boolean checkIfTypeNotNull() {
        return typeBox.getSelectionModel().getSelectedItem() != null;
    }

    @FXML
    private void animate(ActionEvent event) {
        if (checkIfComboxesIsNotNull()) {

            canvasPane.getChildren().clear();

            String collection = collectionBox.getValue().toString();
            String method = methodBox.getValue().toString();
            String type = typeBox.getValue().toString();

            AnimateStructure animationStruct = AnimateStructureFactory.get(collection, method, type, canvasPane, customClass);
            animationStruct.animate(type);
        } else {
            ErrorWindow.display("You should pick collection, method and type before animating!");
        }

    }

    @FXML
    private void setCodeOutput(String text) {
        codeOutput.setText(text);
    }

    @FXML
    private void setOutput(String text) {
        output.setText(text);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        collectionBox.setItems(ListValuesFactory.getCollectionOptions());
        collectionBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                methodBox.setItems(ListValuesFactory.getMethodsValues(newValue.toString()));

            }
        });
        typeBox.setItems(ListValuesFactory.getTypesOptions());

        menuItemClose.setOnAction(event -> Main.askExit());
        menuItemAbout.setOnAction(event -> Main.showAbout());

        typeBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                output.clear();
                codeOutput.clear();
                customClass = null;

                if(checkIfTypeNotNull() && typeBox.getValue().toString() == Types.CUSTOM ) {
                    customClass = Main.showCustomClassDialog();
                }

                if(checkIfComboxesIsNotNull()) {
                    String collection = collectionBox.getValue().toString();
                    String method = methodBox.getValue().toString();
                    String type = typeBox.getValue().toString();

                    AnimateStructure animationStruct = AnimateStructureFactory.get(collection, method, type,
                                                                                   canvasPane, customClass);
                    setCodeOutput(animationStruct.getCode());
                    setOutput(animationStruct.getOutput());
                }
            }
        });

        methodBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                output.clear();
                codeOutput.clear();
                if(checkIfComboxesIsNotNull()) {
                    String collection = collectionBox.getValue().toString();
                    String method = methodBox.getValue().toString();
                    String type = typeBox.getValue().toString();

                    AnimateStructure animationStruct = AnimateStructureFactory.get(collection, method, type,
                                                                                   canvasPane, customClass);
                    setCodeOutput(animationStruct.getCode());
                    setOutput(animationStruct.getOutput());
                }
            }
        });

//        canvasPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
//                BorderWidths.DEFAULT)));
        canvasPane.setStyle("-fx-border-style: solid; -fx-border-color: #C1C1C1");


    }


}

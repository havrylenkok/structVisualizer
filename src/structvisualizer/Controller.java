package structvisualizer;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

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
    Circle circleOnCanvas;
    @FXML
    MenuItem menuItemClose;
    @FXML
    MenuItem menuItemAbout;

    @FXML
    private void animate(ActionEvent event) {


        StringBuilder codeOutput = new StringBuilder();
        if(collectionBox.getSelectionModel().getSelectedItem() != null) {

            codeOutput
                    .append(collectionBox.getSelectionModel().getSelectedItem().toString())
                    .append(".")
                    .append(methodBox.getValue())
                    .append(".")
                    .append(typeBox.getValue());
        } else {
            codeOutput.append("Pick your collection!");
        }

        setCodeOutput(codeOutput.toString());


    }

    @FXML
    private void setCodeOutput(String text) {
        codeOutput.setText(text);
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
//


    }


}

package structvisualizer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.animatecollections.AnimateStructure;
import structvisualizer.animatecollections.AnimateStructureFactory;
import structvisualizer.data.Types;
import structvisualizer.valuefactories.ListValuesFactory;
import structvisualizer.window.ErrorWindow;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller of javafx app
 */
public class Controller implements Initializable {
    private static final Logger logger = Logger.getLogger(SomeClass.class.getName());

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
        logger.log(Level.FINE, "Checking if comboboxes null");

        if(collectionBox.getSelectionModel().getSelectedItem() != null && 
                methodBox.getSelectionModel().getSelectedItem() != null && checkIfTypeNotNull()) {
            logger.log(Level.FINE, "Comboboxes is not null");
            return true;
        } else {
            logger.log(Level.FINE, "Comboboxes are null");
            return false;
        }
    }

    private boolean checkIfTypeNotNull() {
        logger.log(Level.FINE, "Checking if Type combobox !null");
        return typeBox.getSelectionModel().getSelectedItem() != null;
    }

    @FXML
    private void animate(ActionEvent event) {
        if(checkIfComboxesIsNotNull()) {
            logger.log(Level.FINE, "animating event" + event);
            canvasPane.getChildren().clear();

            String collection = collectionBox.getValue().toString();
            String method = methodBox.getValue().toString();
            String type = typeBox.getValue().toString();
            
            logger.log(Level.FINER, "Collection " + collection + " method" + method + " type" + type);

            AnimateStructure animationStruct = AnimateStructureFactory.get(collection, method, type, canvasPane, customClass);
            animationStruct.animate(type);
        } else {
            logger.log(Level.FINE, "User didnt picked any combobox and clicked Animate");
            ErrorWindow.display("You should pick collection, method and type before animating!");
        }

    }

    @FXML
    private void setCodeOutput(String text) {
        logger.log(Level.FINER, "setting Code ouput to " + text);
        codeOutput.setText(text);
    }

    @FXML
    private void setOutput(String text) {

        logger.log(Level.FINER, "setting output to " + text);
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
                logger.log(Level.FINE, "Setting code&output on type change");
                output.clear();
                codeOutput.clear();
                customClass = null;

                if(checkIfTypeNotNull() && typeBox.getValue().toString() == Types.CUSTOM) {
                    customClass = Main.showCustomClassDialog();
                }

                setCodeAndOutput();
            }
        });


        methodBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                logger.log(Level.FINE, "Setting code&output on method change");
                output.clear();
                codeOutput.clear();
                setCodeAndOutput();
            }
        });

        //        canvasPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
        //                BorderWidths.DEFAULT)));
        canvasPane.setStyle("-fx-border-style: solid; -fx-border-color: #C1C1C1");


    }

    private void setCodeAndOutput() {

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


}

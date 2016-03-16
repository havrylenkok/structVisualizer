package structvisualizer;

/*
 * Controller   3/13/16, 20:48
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Kyrylo Havrylenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;

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

    @FXML
    private void animate(ActionEvent event) {
        if (collectionBox.getSelectionModel().getSelectedItem() != null && methodBox.getSelectionModel()
                .getSelectedItem() != null && typeBox.getSelectionModel().getSelectedItem() != null) {

            canvasPane.getChildren().clear();

            String collection = collectionBox.getValue().toString();
            String method = methodBox.getValue().toString();
            String type = typeBox.getValue().toString();

            AnimateStructure animationStruct = AnimateStructureFactory.get(collection);
            animationStruct.animate(method, type, canvasPane);
            setCodeOutput(animationStruct.getCode());
            setOutput(animationStruct.getOutput());
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

//        canvasPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
//                BorderWidths.DEFAULT)));
        canvasPane.setStyle("-fx-border-style: solid; -fx-border-color: #C1C1C1");


    }


}

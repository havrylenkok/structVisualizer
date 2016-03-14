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

import javafx.animation.*;
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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
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
    MenuItem menuItemClose;
    @FXML
    MenuItem menuItemAbout;

    @FXML
    private void animate(ActionEvent event) {

        // TODO: NORMAL ARCHITECTURE!!!

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

//        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), circleOnCanvas);
//        fadeTransition.setFromValue(1.0f);
//        fadeTransition.setToValue(0.0f);
//        ParallelTransition parallelTransition = new ParallelTransition();
//        parallelTransition.getChildren().addAll(fadeTransition);
//        parallelTransition.setCycleCount(1);
//        parallelTransition.play();

        if(collectionBox.getValue() == "ArrayList<>" && methodBox.getValue() == "add(E e)" && typeBox.getValue()
                == "Integer") {
            ArrayList<StackPane> rectangles = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                StackPane stack = new StackPane();
                stack.setMinWidth(50);
                stack.setLayoutX(50 + i * 50);
                rectangles.add(i, stack);

                Rectangle r = new Rectangle();
                r.setWidth(50);
                r.setHeight(50);
                r.setFill(Color.TRANSPARENT);
                r.setStroke(Color.BLACK);

                Text text = new Text("" + i);

                rectangles.get(i).getChildren().addAll(r, text);
            }


            StackPane stack = new StackPane();
            stack.setLayoutX(200);
            stack.setLayoutY(200);
            rectangles.add(3, stack);
            Rectangle r = new Rectangle();
            r.setWidth(50);
            r.setHeight(50);
            r.setFill(Color.TRANSPARENT);
            r.setStroke(Color.BLACK);

            Text text = new Text("" + 3);

            rectangles.get(3).getChildren().addAll(r, text);
            canvasPane.getChildren().addAll(rectangles);

            FadeTransition ft = new FadeTransition(Duration.millis(1000), rectangles.get(3));
            ft.setFromValue(0.0f);
            ft.setToValue(1.0f);
            ft.play();

            TranslateTransition tt = new TranslateTransition(Duration.millis(3000), rectangles.get(3));
            tt.setByY(-200f);
            tt.play();

            output.setText(rectangles.toString());
        }

    }

    @FXML
    private void setCodeOutput(String text) {
        codeOutput.setText(text);
    }

    @FXML private void setOutput(String text) {
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

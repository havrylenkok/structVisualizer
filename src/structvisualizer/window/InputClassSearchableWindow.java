package structvisualizer.window;

 /*
 * InputClassSearchableWindow   4/13/16, 19:43
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import structvisualizer.data.DataForAnimation;
import structvisualizer.data.DataForValueFactory;
import structvisualizer.data.Methods;
import structvisualizer.data.Types;
import structvisualizer.valuefactories.TypeValueFactory;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Shows form for user input to MethodsForSearch and Arraylist.Sublist
 *
 * @author Kyrylo Havrylenko
 * @see structvisualizer.animatecollections.animatemethods.arraylist.MethodsForSearch
 * @see structvisualizer.animatecollections.animatemethods.arraylist.Sublist
 * @see structvisualizer.Main
 */
public class InputClassSearchableWindow {
    private static final Logger logger = Logger.getLogger(InputWindow.class.getName());
    static DataForAnimation data = new DataForAnimation();
    static DataForValueFactory answer;

    /**
     * @return
     */
    public static DataForValueFactory display(String method, String type) {
        Stage window = new Stage(); // пустое окно (stage)

        window.initModality(Modality.APPLICATION_MODAL); // make stage modal (нельзя переключить обратно, не закрыв это)
        window.setTitle("Input");
        window.setMinWidth(500);
        window.setMaxWidth(500);
        window.setMaxHeight(200);

        VBox container = new VBox();
        container.setSpacing(10);

        switch(method) {
            case Methods.CONTAINS:
                ComboBox comboContains = new ComboBox();
                ArrayList<String> valuesContains = new ArrayList<>();
                for(int i = 0; i < data.getMaxIteration(); i++) {
                    valuesContains.add(TypeValueFactory.get(type, i, false, null, true));
                }
                comboContains.getItems().addAll(valuesContains);
                comboContains.getSelectionModel().select(0);
                Label label = new Label();
                label.setText("Pick object which you wan't to check on contains in your structure:");
                label.setLabelFor(comboContains);
                Button okButtonContains = new Button("Set input");
                okButtonContains.setOnAction(event -> {
                    answer = new DataForValueFactory(comboContains.getSelectionModel().getSelectedIndex(), false, null,
                                                     false, null, null);
                    event.consume();
                    window.close();
                });
                container.getChildren().addAll(label, comboContains, okButtonContains);
                break;
            case Methods.GET:
                ComboBox comboGet = new ComboBox();
                ArrayList<String> valuesGet = new ArrayList<>();
                for(int i = 0; i < data.getNumOfStackPanes(); i++) {
                    valuesGet.add(TypeValueFactory.get(type, i, false, null, true));
                }
                comboGet.getItems().addAll(valuesGet);
                comboGet.getSelectionModel().select(0);
                Label labelGet = new Label();
                labelGet.setText("Pick an index of object you need");
                labelGet.setLabelFor(comboGet);
                Button okButtonGet = new Button("Set input");
                okButtonGet.setOnAction(event -> {
                    answer = new DataForValueFactory(comboGet.getSelectionModel().getSelectedIndex(), false, null,
                                                     false, null, null);
                    event.consume();
                    window.close();
                });
                container.getChildren().addAll(labelGet, comboGet, okButtonGet);
                break;
            case Methods.GET_INDEX:
                ComboBox comboGetIndex = new ComboBox();
                ArrayList<String> valuesGetIndex = new ArrayList<>();
                for(int i = 0; i < data.getNumOfStackPanes(); i++) {
                    valuesGetIndex.add(TypeValueFactory.get(type, i, false, null, true));
                }
                comboGetIndex.getItems().addAll(valuesGetIndex);
                comboGetIndex.getSelectionModel().select(0);
                Label labelGetIndex = new Label();
                labelGetIndex.setText("Pick an object what's index you looking for");
                labelGetIndex.setLabelFor(comboGetIndex);
                Button okButtonGetIndex = new Button("Set input");
                okButtonGetIndex.setOnAction(event -> {
                    answer = new DataForValueFactory(comboGetIndex.getSelectionModel().getSelectedIndex(), false, null,
                                                     false, null, null);
                    event.consume();
                    window.close();
                });
                container.getChildren().addAll(labelGetIndex, comboGetIndex, okButtonGetIndex);
                break;
            case Methods.SET:
                ComboBox comboSetWhere = new ComboBox();
                ArrayList<String> valuesSetWhere = new ArrayList<>();
                for(int i = 0; i < data.getNumOfStackPanes(); i++) {
                    valuesSetWhere.add(TypeValueFactory.get(Types.INT, i, false, null, true));
                }
                comboSetWhere.getItems().addAll(valuesSetWhere);
                comboSetWhere.getSelectionModel().select(0);
                Label labelSetWhere = new Label();
                labelSetWhere.setText("Pick an index to set");
                labelSetWhere.setLabelFor(comboSetWhere);
                ComboBox comboSetTo = new ComboBox();
                ArrayList<String> valuesSetTo = new ArrayList<>();
                for(int i = 0; i < data.getMaxIteration(); i++) {
                    valuesSetTo.add(TypeValueFactory.get(type, i, false, null, true));
                }
                comboSetTo.getItems().addAll(valuesSetTo);
                comboSetTo.getSelectionModel().select(0);
                Label labelSetTo = new Label();
                labelSetTo.setText("Pick value to set on index");
                labelSetTo.setLabelFor(comboSetTo);
                Button okButtonSet = new Button("Set input");
                okButtonSet.setOnAction(event -> {
                    answer = new DataForValueFactory(comboSetWhere.getSelectionModel().getSelectedIndex(), false, null,
                                                     true, comboSetWhere.getSelectionModel().getSelectedIndex(),
                                                     comboSetTo.getSelectionModel().getSelectedIndex());
                    event.consume();
                    window.close();
                });
                container.getChildren().addAll(labelSetWhere, comboSetWhere, labelSetTo, comboSetTo, okButtonSet);
                break;
            case Methods.REMOVE:
                ComboBox comboRemove = new ComboBox();
                ArrayList<String> valuesRemove = new ArrayList<>();
                for(int i = 0; i < data.getNumOfStackPanes(); i++) {
                    valuesRemove.add(TypeValueFactory.get(type, i, false, null, true));
                }
                comboRemove.getItems().addAll(valuesRemove);
                comboRemove.getSelectionModel().select(0);
                Label labelRemove = new Label();
                labelRemove.setText("Pick an object what's index you looking for");
                labelRemove.setLabelFor(comboRemove);
                Button okButtonRemove = new Button("Set input");
                okButtonRemove.setOnAction(event -> {
                    answer = new DataForValueFactory(comboRemove.getSelectionModel().getSelectedIndex(), false, null,
                                                     false, null, null);
                    event.consume();
                    window.close();
                });
                container.getChildren().addAll(labelRemove, comboRemove, okButtonRemove);
                break;
            case Methods.SUBLIST:
                ComboBox comboSublistFrom = new ComboBox();
                ArrayList<String> valuesSublistFrom = new ArrayList<>();
                for(int i = 0; i < data.getNumOfStackPanes(); i++) {
                    valuesSublistFrom.add(TypeValueFactory.get(Types.INT, i, false, null, true));
                }
                comboSublistFrom.getItems().addAll(valuesSublistFrom);
                comboSublistFrom.getSelectionModel().select(0);
                Label labelSublistFrom = new Label();
                labelSublistFrom.setText("Pick an index where your sublist starts");
                labelSublistFrom.setLabelFor(comboSublistFrom);
                ComboBox comboSublistTo = new ComboBox();
                ArrayList<String> valuesSublistTo = new ArrayList<>();
                for(int i = 0; i < data.getNumOfStackPanes(); i++) {
                    valuesSublistTo.add(TypeValueFactory.get(Types.INT, i, false, null, true));
                }
                comboSublistTo.getItems().addAll(valuesSublistTo);
                comboSublistTo.getSelectionModel().select(0);
                Label labelSublistTo = new Label();
                labelSublistTo.setText("Pick value to set on index");
                labelSublistTo.setLabelFor(comboSublistTo);
                Button okButtonSublist = new Button("Set input");
                okButtonSublist.setOnAction(event -> {
                    answer = new DataForValueFactory(null, false, null,
                                                     true, comboSublistFrom.getSelectionModel().getSelectedIndex(),
                                                     comboSublistTo.getSelectionModel().getSelectedIndex());
                    event.consume();
                    window.close();
                });
                container.getChildren().addAll(labelSublistFrom, comboSublistFrom, labelSublistTo, comboSublistTo,
                                               okButtonSublist);
                break;


            default:
                logger.log(Level.FINE,"called default InputClassSearchableWindow");
        }



        VBox layout = new VBox(10);
        layout.getChildren().addAll(container);
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setPadding(new javafx.geometry.Insets(10));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // fn+f1 to see documentation | ждет пока окно закроется прежде чем показывать другу сцену

        return answer;

    }
}

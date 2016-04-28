package structvisualizer.animatecollections.animatemethods.stack;

 /*
 * Stacks   4/27/16, 23:48
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.animatecollections.animatemethods.MethodsForSearch;
import structvisualizer.data.DataForAnimation;
import structvisualizer.valuefactories.TypeValueFactory;

import java.util.ArrayList;
import java.util.List;

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.createArrayList;
import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.newStackPane;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Stacks {
    static DataForAnimation data = new DataForAnimation();

    public static void searchForElement(MethodsForSearch method, String type, Pane canvasPane, SomeClass customClass,
                                        Object indexOf, int index) {
        ArrayList<StackPane> rectangles = createArrayList(type);
        VBox vBox = new VBox();
        vBox.setLayoutX(data.getStackPaneSize());
        vBox.getChildren().addAll(rectangles);
        canvasPane.getChildren().addAll(vBox);
        AnimateMethod.setTooltip(rectangles, type, customClass);

        StackPane sp = newStackPane(0, 0, canvasPane, data.getHightlightColor());

//        int y = (index + 1) * data.getWidth();
//        int anotherY = data.getNumOfStackPanes() * data.getWidth();

//        double finalY = (y < anotherY) ? y : anotherY;

        method.animateSearch(sp, data.getStackPaneSize(), 0, data.getStackPaneSize(), 0, canvasPane);
    }

}

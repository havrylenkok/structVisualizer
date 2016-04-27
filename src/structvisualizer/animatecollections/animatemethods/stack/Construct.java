package structvisualizer.animatecollections.animatemethods.stack;

 /*
 * Construct   4/10/16, 15:57
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

import java.util.ArrayList;

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.createArrayList;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Construct extends AnimateMethod {
    public Construct(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    @Override
    public void animate(String type) {
        ArrayList<StackPane> rectangles = createArrayList(type);
        VBox stack = new VBox();
        stack.setLayoutX(data.getStackPaneSize());
        stack.getChildren().addAll(rectangles);
        canvasPane.getChildren().addAll(stack);
        AnimateMethod.setTooltip(rectangles, type, customClass);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        return "WORK IN PROGRESS";
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "WORK IN PROGRESS";
    }
}

package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Sublist   4/9/16, 20:04
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

import java.util.ArrayList;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Sublist extends AnimateMethod {
    int elementFrom;
    int elementTo;
    int size;


    public Sublist(Pane canvasPane, String type, SomeClass obj, int elementFrom, int elementTo) {
        super(canvasPane, type, obj);
        this.elementFrom = elementFrom;
        this.elementTo = elementTo;
        this.size = elementTo - elementFrom + 1;
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        ArrayList<StackPane> origin = Construct.createArrayList(type);

        ArrayList<StackPane> clone = Construct.createArrayList(type, 3, 0, 0, 1);

        Clone.translateStackpanes(clone);


        canvasPane.getChildren().addAll(origin);
        canvasPane.getChildren().addAll(clone);
        AnimateMethod.setTooltip(origin, type, customClass);
        AnimateMethod.setTooltip(clone, type, customClass);
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

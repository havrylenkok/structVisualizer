package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Sort   4/9/16, 19:34
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
public class Sort extends AnimateMethod {
    public Sort(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        ArrayList<StackPane> origin = Arraylists.createArrayList(type, data.getNumOfStackPanes(), data.getWidth(), 0,
                                                                 0, true);

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

package structvisualizer.animatecollections.animatemethods.stack;

 /*
 * Push   4/28/16, 22:25
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Push extends AnimateMethod {

    public Push(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        super.animate(type);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        return "WORK IN PROGRESS";
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "inputted item";
    }
}

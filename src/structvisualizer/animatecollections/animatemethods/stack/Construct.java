package structvisualizer.animatecollections.animatemethods.stack;

 /*
 * Construct   4/10/16, 15:57
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
public class Construct extends AnimateMethod {
    public Construct(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        super.animate(type);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        return super.getCode(os);
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return super.getResults(os);
    }
}

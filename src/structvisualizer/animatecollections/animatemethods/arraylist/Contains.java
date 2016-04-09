package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Contains   4/5/16, 23:41
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
public class Contains extends AnimateMethod {
    Get animateObj;
    public Contains(Pane canvasPane, String type, SomeClass obj, Object indexOf, int index) {
        super(canvasPane, type, obj);
        animateObj = new Get(canvasPane, type, obj, indexOf, index);
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        // TODO: now don't work with false, make it
        animateObj.animate(type);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getCode() + "\n\ttmp.contains(" + animateObj.indexOf +")\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        boolean res = false;
        System.out.println(animateObj.index);
        if(animateObj.index < data.getNumOfStackPanes()) res = true;
        return "The result is " + res;
    }
}

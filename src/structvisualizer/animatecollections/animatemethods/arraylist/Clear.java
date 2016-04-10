package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Clear   3/28/16, 21:54
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

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.clearAnimation;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Clear extends AnimateMethod {


    /**
     * Constructor
     *
     * @param canvasPane
     * @param type       string with name of type
     * @param obj
     */
    public Clear(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }


    @Override
    public void animate(String type) throws UnsupportedOperationException {
        ArrayList<StackPane> stack = Arraylists.createArrayList(type);
        canvasPane.getChildren().addAll(stack);
        clearAnimation(stack);
    }

    /**
     * @param os Class with templates of result
     *
     * @return
     * @see AnimateMethod
     */
    @Override
    public String getCode(OutputStrings os) {

        String result = os.getCode() + "tmp.clear();\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        results = "Your data structure was cleared";
        return results;
    }
}

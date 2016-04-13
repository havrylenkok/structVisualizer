package structvisualizer.animatecollections.animatemethods.arraylist;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

import java.util.ArrayList;

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.createArrayList;

/**
 * Animates constructor of ArrayList with 3 elements
 *
 * @author Kyrylo Havrylenko
 * @see AnimateMethod
 */
public class Construct extends AnimateMethod {

    /**
     * @param canvasPane
     * @param type
     * @param obj
     *
     * @see AnimateMethod
     */
    public Construct(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }


    /**
     * @param type
     *
     * @see AnimateMethod
     */
    @Override
    public void animate(String type) {

        ArrayList<StackPane> rectangles = createArrayList(type);

        canvasPane.getChildren().addAll(rectangles);
        AnimateMethod.setTooltip(rectangles, type, customClass);
    }

    /**
     * @param os Class with templates of result
     *
     * @return
     * @see AnimateMethod
     */
    @Override
    public String getCode(OutputStrings os) {

        String result = os.getCode() + "\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        results = "Data structure was created";
        return results;
    }
}

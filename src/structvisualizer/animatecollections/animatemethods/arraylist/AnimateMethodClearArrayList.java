package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * AnimateMethodClearArrayList   3/28/16, 21:54
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
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
public class AnimateMethodClearArrayList extends AnimateMethod {


    /**
     * Constructor
     *
     * @param canvasPane
     * @param type       string with name of type
     * @param obj
     */
    public AnimateMethodClearArrayList(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    public static ArrayList<StackPane> clearAnimation(ArrayList<StackPane> stack) {
        int counter = 1000;
        for(StackPane s : stack) {
            FadeTransition fade = new FadeTransition(Duration.millis(data.getFade() + counter), s);
            fade.setFromValue(1);
            fade.setToValue(0);
            fade.play();
            counter -= 100;

        }
        return stack;
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        ArrayList<StackPane> stack = AnimateMethodConstructArrayList.createArrayList(type);
        canvasPane.getChildren().addAll(stack);
        clearAnimation(stack);
    }

    /**
     * @param os Class with templates of result
     * @return
     * @see AnimateMethod
     */
    @Override
    public String getCode(OutputStrings os) {

        String result = os.getCode() + "tmp.clear();\n\t}\n}";

        return result;
    }
}

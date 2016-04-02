package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * AnimateMethodCloneArrayList   4/2/16, 19:48
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.animation.TranslateTransition;
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
public class AnimateMethodCloneArrayList extends AnimateMethod {
    public AnimateMethodCloneArrayList(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        ArrayList<StackPane> origin = AnimateMethodConstructArrayList.createArrayList(type);
        ArrayList<StackPane> clone = AnimateMethodConstructArrayList.createArrayList(type, data.getNumOfStackPanes(),
                                                                                     data.getWidth(),
                                                                                     data.getyCoordForClone());

//        TranslateTransition tt = new TranslateTransition(Duration.ZERO, origin);

        canvasPane.getChildren().addAll(origin);
        canvasPane.getChildren().addAll(clone);
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

package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * AnimateMethodGetIndexArrayList   3/29/16, 16:30
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.animation.FillTransition;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
public class AnimateMethodGetIndexArrayList extends AnimateMethod {

    public AnimateMethodGetIndexArrayList(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    public static void highlightNode(Rectangle rectangle, Color colorFrom, Color colorTo) {

        FillTransition ft = new FillTransition(Duration.millis(data.getTransitionInvisible()), rectangle, colorFrom,
                                               colorTo);
        ft.play();
    }

    public static void hightlightSearch(ArrayList<StackPane> elements) {
        for(StackPane sp : elements) {
            sp.getChildren().get(0)

        }
    }


    @Override
    public void animate(String type) throws UnsupportedOperationException {
        super.animate(type);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        return super.getCode(os);
    }
}

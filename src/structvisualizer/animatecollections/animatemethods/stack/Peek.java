package structvisualizer.animatecollections.animatemethods.stack;

 /*
 * Peek   4/28/16, 21:02
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
import structvisualizer.animatecollections.animatemethods.MethodsForSearch;
import structvisualizer.animatecollections.animatemethods.arraylist.Arraylists;
import structvisualizer.data.OutputStrings;

/**
 * Animates Peek method in Stack
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Peek extends AnimateMethod implements MethodsForSearch {

    public Peek(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    @Override
    public void animateSearch(StackPane redRectangle, double fromX, double fromY, double toX, double toY, Pane canvas) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), redRectangle);
        tt.setFromX(fromX);
        tt.setFromY(fromY);
        tt.setToX(toX);
        tt.setToY(toY);
        tt.play();

        tt.setOnFinished(event -> {
            redRectangle.setVisible(false);

                redRectangle.setVisible(false);
                StackPane greenStackpane = Arraylists.newStackPane(toX, toY, canvas, data.getSuccessColor());

        });
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        Stacks.searchForElement(this, type, canvasPane, customClass, 0, 0);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        return "WORK IN PROGRESS";
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "You got the element on the top of the Stack";
    }
}

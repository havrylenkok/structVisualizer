package structvisualizer.animatecollections.animatemethods.stack;

 /*
 * Search   4/30/16, 15:18
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

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.newStackPane;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Search extends AnimateMethod implements MethodsForSearch {
    Object indexOf;
    int index;

    public Search(Pane canvasPane, String type, SomeClass obj, Object indexOf, int index) {
        super(canvasPane, type, obj);
        this.indexOf = indexOf;
        this.index = index;
        this.results = "";
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
            StackPane greenStackpane = newStackPane(toX, toY, canvas, data.getSuccessColor());
        });
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        Stacks.searchForElement(this, type, canvasPane, customClass, indexOf, index);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        return "WORK IN PROGRESS";
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "INDEX OF SEARCHED OBJECT (starting from 1, not 0)";
    }
}

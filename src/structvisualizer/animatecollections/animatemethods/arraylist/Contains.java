package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Contains   4/5/16, 23:41
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

/**
 * Animates ArrayList.contains
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Contains extends AnimateMethod implements MethodsForSearch {
    Object indexOf;
    int index;
    boolean contains = false;

    /**
     *
     * @param canvasPane
     * @param type
     * @param obj
     * @param indexOf
     * @param index
     */
    public Contains(Pane canvasPane, String type, SomeClass obj, Object indexOf, int index) {
        super(canvasPane, type, obj);
        this.index = index;
        this.indexOf = indexOf;
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {

        if(index < data.getNumOfStackPanes()) {
            contains = true;
        }
        Arraylists.searchForElement(this, type, canvasPane, customClass, indexOf, index);
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
            if(contains) {
                redRectangle.setVisible(false);
                StackPane greenStackpane = Arraylists.newStackPane(toX, toY, canvas, data.getSuccessColor());
            }
        });
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getCode() + "\n\ttmp.contains(" + indexOf + ")\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        boolean res = false;
        if(index < data.getNumOfStackPanes()) res = true;
        return "The result is " + res;
    }
}

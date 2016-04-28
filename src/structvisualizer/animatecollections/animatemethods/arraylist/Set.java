package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Set   4/3/16, 22:29
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
import structvisualizer.data.OutputStrings;
import structvisualizer.data.Types;

import java.util.ArrayList;
import java.util.logging.Logger;

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.newValStackpane;

/**
 * Animates ArrayList.set method
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Set extends AnimateMethod implements MethodsForSearch {
    private static final Logger logger = Logger.getLogger(Set.class.getName());
    Object indexOf;
    int index;
    int iterationNumOfNewVal;

    /**
     *
     * @param canvasPane
     * @param type
     * @param obj
     * @param indexOf
     * @param index
     * @param iterationNumOfNewVal
     */
    public Set(Pane canvasPane, String type, SomeClass obj, Object indexOf, int index, int
            iterationNumOfNewVal) {
        super(canvasPane, type, obj);
        this.indexOf = indexOf;
        this.index = index;
        this.iterationNumOfNewVal = iterationNumOfNewVal;
        if(type.equals(Types.SOME_CLASS)) {
            customClass = new SomeClass(iterationNumOfNewVal, iterationNumOfNewVal, iterationNumOfNewVal,
                                        iterationNumOfNewVal);
        }
    }


    /**
     * Animating search for this concrete {@code MethodsForSearch}
     * @param redRectangle
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @param canvas
     * @see MethodsForSearch
     */
    public void animateSearch(StackPane redRectangle, double fromX, double fromY, double toX, double toY, Pane canvas) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), redRectangle);
        tt.setFromX(fromX);
        tt.setFromY(fromY);
        tt.setToX(toX);
        tt.setToY(toY);
        tt.play();

        tt.setOnFinished(event -> {
            redRectangle.setVisible(false);
            StackPane setToThis = newValStackpane(type, (index + 1) * data.getWidth(), redRectangle.getLayoutY(),
                                                  null, iterationNumOfNewVal);
            canvas.getChildren().remove(index);
            canvas.getChildren().addAll(setToThis);
            ArrayList<StackPane> tmp = new ArrayList<>();
            tmp.add(setToThis);
            if(customClass == null) {
                AnimateMethod.setTooltip(tmp, indexOf.toString());
            } else {
                AnimateMethod.setTooltip(tmp, customClass.getThisToStringForIteration(index));
            }

        });
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        Arraylists.searchForElement(this, type, canvasPane, customClass, indexOf, index);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getCode() + "\n\ttmp.set(" + index + ", " + indexOf + ");" + "\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "You have set link on " + index + " spot of your structure to another object.";
    }
}

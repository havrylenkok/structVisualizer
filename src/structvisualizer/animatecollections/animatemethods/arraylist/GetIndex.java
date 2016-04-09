package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * GetIndex   3/29/16, 16:30
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

import static structvisualizer.animatecollections.animatemethods.arraylist.Construct.createArrayList;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class GetIndex extends AnimateMethod implements MethodsForSearch {
    Object indexOf;
    int index;

    public GetIndex(Pane canvasPane, String type, SomeClass obj, Object indexOf, int index) {
        super(canvasPane, type, obj);
        this.indexOf = indexOf;
        this.index = index;
        this.results = "";
    }

    public static void highlightNode(Rectangle rectangle, Color colorFrom, Color colorTo) {

        FillTransition ft = new FillTransition(Duration.millis(data.getTransitionInvisible()), rectangle, colorFrom,
                                               colorTo);
        ft.play();
    }

    public static StackPane newStackPane(double x, double y, Pane canvas, Color color) {
        StackPane stack = new StackPane();
        stack.setMinWidth(data.getWidth());
        stack.setLayoutX(x);
        stack.setLayoutY(y);

        Rectangle r = new Rectangle();
        r.setWidth(data.getWidth());
        r.setHeight(data.getHeight());
        r.setFill(color);
        r.setStroke(Color.BLACK);

        stack.getChildren().addAll(r);

        canvas.getChildren().addAll(stack);
        return stack;


    }

    public void animateSearch(StackPane redRectangle, double fromX, double fromY, double toX, double toY, Pane canvas) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), redRectangle);
        tt.setFromX(fromX);
        tt.setFromY(fromY);
        tt.setToX(toX);
        tt.setToY(toY);
        //        tt.setByY(1f * data.getStackPaneSize());
        tt.play();

        tt.setOnFinished(event -> {
            redRectangle.setVisible(false);
            StackPane greenStackpane = newStackPane(toX, toY, canvas, data.getSuccessColor());
        });
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {

        Set.searchForElement(this, type, canvasPane, customClass, indexOf, index);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getCode() + "\n\ttmp.indexOf(" + indexOf +")\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        results = "The index is " + index;
        return results;
    }
}

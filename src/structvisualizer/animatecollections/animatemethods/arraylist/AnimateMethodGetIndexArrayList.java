package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * AnimateMethodGetIndexArrayList   3/29/16, 16:30
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
import javafx.scene.text.Text;
import javafx.util.Duration;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.Collections;
import structvisualizer.data.OutputStrings;
import structvisualizer.data.Types;

import java.util.ArrayList;

import static structvisualizer.animatecollections.animatemethods.arraylist.AnimateMethodConstructArrayList.createArrayList;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateMethodGetIndexArrayList extends AnimateMethod {
    Object indexOf;
    int index;

    public AnimateMethodGetIndexArrayList(Pane canvasPane, String type, SomeClass obj, Object indexOf, int index) {
        super(canvasPane, type, obj);
        this.indexOf = indexOf;
        this.index = index;
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

    public static void animateSearch(StackPane redRectangle, double fromX, double fromY, double toX, double toY, Pane canvas) {
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

        ArrayList<StackPane> rectangles = createArrayList(type);
        canvasPane.getChildren().addAll(rectangles);
        AnimateMethod.setTooltip(rectangles, type, customClass);

        StackPane sp = newStackPane(0, 0, canvasPane, data.getHightlightColor());

        double finalX = 0;
        for(int i = 0; i < data.getNumOfStackPanes(); i++) {
            String text = rectangles.get(i).getChildren().get(1).toString();
            // indexOf - VALUE OF ELEMENT WHAT WE LOOKING FOR
            if(!text.substring(11, 12).equals(indexOf)) {
                finalX += data.getWidth();
            }
        }
        animateSearch(sp, 0, 0, finalX, 0, canvasPane);

        final Text result = new Text("The index is " + index);
        result.setLayoutX(data.getWidth() * 4);
        result.setLayoutY(data.getWidth() * 2);
        canvasPane.getChildren().addAll(result);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getCode() + "\n\ttmp.indexOf(" + indexOf +")\n\t}\n}";

        return result;
    }
}

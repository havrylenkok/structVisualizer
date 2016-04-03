package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * AnimateMethodSetArrayList   4/3/16, 22:29
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;
import structvisualizer.data.Types;
import structvisualizer.valuefactories.TypeValueFactory;

import java.util.ArrayList;

import static structvisualizer.animatecollections.animatemethods.arraylist.AnimateMethodConstructArrayList.createArrayList;
import static structvisualizer.animatecollections.animatemethods.arraylist.AnimateMethodGetIndexArrayList.newStackPane;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateMethodSetArrayList extends AnimateMethod {
    Object indexOf;
    int index;
    int iterationNumOfNewVal;

    public AnimateMethodSetArrayList(Pane canvasPane, String type, SomeClass obj, Object indexOf, int index, int
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

    public StackPane newValStackpane(double x, double y, String value, int iteration) {
        StackPane stack = new StackPane();
        stack.setMinWidth(data.getWidth());
        stack.setLayoutX(x);
        stack.setLayoutY(y);

        javafx.scene.shape.Rectangle r = new javafx.scene.shape.Rectangle();
        r.setWidth(data.getWidth());
        r.setHeight(data.getHeight());
        r.setFill(javafx.scene.paint.Color.TRANSPARENT);
        r.setStroke(javafx.scene.paint.Color.BLACK);

        Text text = new Text("no value");
        if(value == null) {
            text = new Text(TypeValueFactory.get(type, iteration));
        } else {
            text = new Text(value);
        }
        stack.getChildren().addAll(r, text);

        return stack;

    }

    public void animateSearch(StackPane redRectangle, double fromX, double fromY, double toX, double toY, Pane canvas) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), redRectangle);
        tt.setFromX(fromX);
        tt.setFromY(fromY);
        tt.setToX(toX);
        tt.setToY(toY);
        tt.play();

        tt.setOnFinished(event -> {
            redRectangle.setVisible(false);
            StackPane setToThis = newValStackpane((index + 1) * data.getWidth(), redRectangle.getLayoutY(),
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

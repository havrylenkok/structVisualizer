package structvisualizer.animatecollections.animatemethods.stack;

 /*
 * Push   4/28/16, 22:25
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

import java.util.ArrayList;

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.addToArrayList;
import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.createArrayList;
import static structvisualizer.animatecollections.animatemethods.stack.Stacks.createStack;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Push extends AnimateMethod {
    //    String newValue;

    public Push(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
        //        newValue = value;
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        ArrayList<StackPane> rectangles = createStack(type);

        canvasPane.getChildren().addAll(rectangles);
        AnimateMethod.setTooltip(rectangles, type, customClass);

        FadeTransition ft = new FadeTransition(Duration.millis(1), rectangles.get(0));
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
        double y = 0;
        for(StackPane sp : rectangles) {
            TranslateTransition tt = new TranslateTransition(Duration.millis(1), sp);
            tt.setFromX(0);
            tt.setFromY(sp.getLayoutY());
            tt.setToX(0);
            tt.setToY(y);
            tt.play();
            y += data.getHeight();
        }
        y = rectangles.get(1).getLayoutY();
//        for(StackPane sp : rectangles) {
//            TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), sp);
//            tt.setFromX(0);
//            tt.setFromY(y);
//            tt.setToX(0);
//            tt.setToY(y + data.getHeight());
//            tt.play();
//            y += data.getHeight();
//        }
        FadeTransition realFt = new FadeTransition(Duration.millis(data.getTimeTranslate()), rectangles.get(0));
        ft.setToValue(1);
        ft.play();



        //        final boolean[] flag = {true};
        //        for(StackPane sp : rectangles) {
        //            TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), sp);
        //            tt.setFromY(sp.getLayoutY());
        //            tt.setToY(sp.getLayoutY() + data.getHeight());
        //            tt.play();
        //            tt.setOnFinished(event -> {
        //                if(flag[0]) {
        //                    StackPane spNew = new StackPane();
        //                    Rectangle r = new Rectangle();
        //                    r.setWidth(data.getWidth());
        //                    r.setHeight(data.getHeight());
        //                    r.setFill(Color.TRANSPARENT);
        //                    r.setStroke(Color.BLACK);
        //
        //                    Text text = new Text(TypeValueFactory.get(type, data.getNumOfStackPanes(), false, null, true));
        //                    stack.getChildren().add(0, spNew);
        //                    flag[0] = false;
        //                }
        //            });
        //        }
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        return "WORK IN PROGRESS";
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "inputted item";
    }
}

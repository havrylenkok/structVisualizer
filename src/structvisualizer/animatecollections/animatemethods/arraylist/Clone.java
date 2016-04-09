package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Clone   4/2/16, 19:48
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
public class Clone extends AnimateMethod {
    public Clone(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    public static void translateStackpanes(ArrayList<StackPane> clone) {
        double x = 0;
        for(StackPane sp : clone) {
            //            translateStackpane(sp, 0, 0, sp.getLayoutX(), data.getyCoordForClone()); // прикольный эффект
            translateStackpane(sp, 0, 0, 0, data.getyCoordForClone());
        }
    }

    public static void translateStackpane(StackPane sp, double fromX, double fromY, double toX, double toY) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), sp);
        tt.setFromX(fromX);
        tt.setFromY(fromY);
        tt.setToX(toX);
        tt.setToY(toY);
        tt.play();
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        ArrayList<StackPane> origin = Construct.createArrayList(type);
        ArrayList<StackPane> clone = Construct.createArrayList(type);
        translateStackpanes(clone);
        //        TranslateTransition tt = new TranslateTransition(Duration.ZERO, origin);

        canvasPane.getChildren().addAll(origin);
        canvasPane.getChildren().addAll(clone);
        AnimateMethod.setTooltip(origin, type, customClass);
        AnimateMethod.setTooltip(clone, type, customClass);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getCode() + "\n\tArrayList<" + type + "> clone = tmp.clone();" + "\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "You now have 2 identical structures in memory.";
    }
}

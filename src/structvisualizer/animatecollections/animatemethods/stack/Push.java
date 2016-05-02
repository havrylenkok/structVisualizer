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
 * Animates Push method in Stack
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

        final boolean[] state = {true};
        for(StackPane sp : rectangles) {
            TranslateTransition tt = new TranslateTransition(Duration.millis(1), sp);
            tt.setFromX(0);
            tt.setFromY(0);
            tt.setToX(0);
            tt.setToY(-data.getHeight());
            tt.play();
            tt.setOnFinished(event -> {
                TranslateTransition ttp = new TranslateTransition(Duration.millis(data.getTimeTranslate()), sp);
                ttp.setFromX(0);
                ttp.setFromY(-data.getHeight());
                ttp.setToX(0);
                ttp.setToY(0);
                ttp.play();

                if(state[0]) {
                    FadeTransition realFt = new FadeTransition(Duration.millis(data.getTimeFade()), rectangles.get(0));
                    realFt.setFromValue(0);
                    realFt.setToValue(1);
                    realFt.play();
                    state[0] = false;
                }

            });
        }





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
        String result = os.getPackage() + os.getImportMain() + "{\n" + os.getCollection() + "\t\t" + "for(int i = " +
                "1; i < " + (data.getNumOfStackPanes()) + "; i++) {\n\t\t\t" + "tmp.push(i);\n\t\t}" + "" +
                "\n\ttmp.push(0);\n\t}\n}";
        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "You've inserted element to the head of the Stack. Method have returned value of element to you.";
    }
}

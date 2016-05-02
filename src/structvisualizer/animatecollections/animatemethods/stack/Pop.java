package structvisualizer.animatecollections.animatemethods.stack;

 /*
 * Pop   4/28/16, 21:15
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

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.createArrayList;

/**
 * Animates Pop method in Stack
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Pop extends AnimateMethod {
    public Pop(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        ArrayList<StackPane> rectangles = createArrayList(type);
        VBox stack = new VBox();
        stack.setLayoutX(data.getStackPaneSize());
        stack.getChildren().addAll(rectangles);
        canvasPane.getChildren().addAll(stack);
        AnimateMethod.setTooltip(rectangles, type, customClass);

        FadeTransition ft = new FadeTransition(Duration.millis(data.getTimeTranslate()), rectangles.get(0));
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
        rectangles.remove(rectangles.get(0));

        for(StackPane sp : rectangles) {
            TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), sp);
            tt.setFromX(0);
            tt.setFromY(sp.getLayoutY());
            tt.setToX(0);
            tt.setToY(sp.getLayoutY() - data.getHeight());
            tt.play();
        }
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getPackage() + os.getImportMain() + "{\n" + os.getCollection() + "\t\t" + "for(int i = " +
                "0; i < " + data.getNumOfStackPanes() + "; i++) {\n\t\t\t" + "tmp.push(i);\n\t\t}\n\t" +
                type + " tmpVar = tmp.pop();\n\t}\n}";
        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "You've poped top element of the Stack. It's value has been returned to you.";
    }
}

package structvisualizer.animatecollections.animatemethods.arraylist;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

import java.util.ArrayList;

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.addToArrayList;

/**
 * Animates ArrayList.add() on Pane
 *
 * @author Kyrylo Havrylenko
 * @see AnimateMethod
 */
public class Add extends AnimateMethod {

    /**
     * @param canvasPane
     * @param type
     * @param obj
     *
     * @see AnimateMethod
     */
    public Add(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);

    }


    /**
     * @param type string with type of values in ArrayList
     *
     * @see AnimateMethod
     */
    @Override
    public void animate(String type) {


        ArrayList<StackPane> rectangles = Arraylists.createArrayList(type);

        rectangles = addToArrayList(rectangles, type);

        canvasPane.getChildren().addAll(rectangles);
        AnimateMethod.setTooltip(rectangles, type, customClass);

        FadeTransition ft = new FadeTransition(Duration.millis(data.getTimeFade()), rectangles.get(data.getNumOfStackPanes()));
        ft.setFromValue(data.getTransitionInvisible());
        ft.setToValue(data.getTransitionVisible());
        ft.play();

        TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), rectangles.get
                (data.getNumOfStackPanes()));
        tt.setByY(-1f * data.getStackPaneSize());
        tt.play();

    }

    /**
     * @param os
     *
     * @return
     * @see AnimateMethod
     */
    @Override
    public String getCode(OutputStrings os) {

        StringBuilder addCode = new StringBuilder();
        addCode
                .append("tmp.add(").append(data.getNumOfStackPanes()).append(", ").append(data.getNumOfStackPanes())
                .append(");\n\t}\n}");
        os.setCode(os.getCode() + addCode.toString());

        return os.getCode();
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        results = "Element was added to your data structure";
        return results;
    }
}

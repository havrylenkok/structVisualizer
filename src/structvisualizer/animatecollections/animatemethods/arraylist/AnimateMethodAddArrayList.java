package structvisualizer.animatecollections.animatemethods.arraylist;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;
import structvisualizer.valuefactories.TypeValueFactory;

import java.util.ArrayList;

/**
 * Animates ArrayList.add() on Pane
 *
 * @author Kyrylo Havrylenko
 * @see AnimateMethod
 */
public class AnimateMethodAddArrayList extends AnimateMethod {

    /**
     * @param canvasPane
     * @param type
     * @param obj
     * @see AnimateMethod
     */
    public AnimateMethodAddArrayList(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);

    }

    /**
     * Static method to create ArrayList<StackPane> of elements to show on Pane (canvas)
     *
     * @param rectangles ArrayList where to add StackPane
     * @param type       Type of values in ArrayList
     * @return ArrayList<StackPane>
     */
    public static ArrayList<StackPane> addToArrayList(ArrayList<StackPane> rectangles, String type) {
        StackPane stack = new StackPane();
        stack.setLayoutX(data.getStackPaneSize());
        stack.setLayoutY(data.getStackPaneSize());

        rectangles.add(data.getNumOfStackPanes(), stack);
        Rectangle r = new Rectangle();
        r.setWidth(data.getWidth());
        r.setHeight(data.getHeight());
        r.setFill(Color.TRANSPARENT);
        r.setStroke(Color.BLACK);

        Text text = new Text(TypeValueFactory.get(type, data.getNumOfStackPanes()));

        rectangles.get(data.getNumOfStackPanes()).getChildren().addAll(r, text);
        return rectangles;
    }


    /**
     * @param type string with type of values in ArrayList
     * @see AnimateMethod
     */
    @Override
    public void animate(String type) {


        ArrayList<StackPane> rectangles = AnimateMethodConstructArrayList.createArrayList(type);

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

}

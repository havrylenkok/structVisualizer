package structvisualizer;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import parser.SomeClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Animates constructor of ArrayList with 3 elements
 *
 * @author Kyrylo Havrylenko
 * @see structvisualizer.AnimateMethod
 */
public class AnimateMethodConstructArrayList extends AnimateMethod {

    /**
     * @param canvasPane
     * @param type
     * @see structvisualizer.AnimateMethod
     */
    AnimateMethodConstructArrayList(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    /**
     * Static method to create ArrayList with StackPane elements which will be next added to Pane (canvas) in app
     *
     * @param type String
     * @return ArrayList<StackPane>
     */
    public static ArrayList<StackPane> createArrayList(String type) {

        ArrayList<StackPane> rectangles = new ArrayList<>();
        for (int i = 0; i < data.getNumOfStackPanes(); i++) {
            StackPane stack = new StackPane();
            stack.setMinWidth(data.getWidth());
            stack.setLayoutX(data.getWidth() + i * data.getWidth());
            rectangles.add(i, stack);

            Rectangle r = new Rectangle();
            r.setWidth(data.getWidth());
            r.setHeight(data.getHeight());
            r.setFill(Color.TRANSPARENT);
            r.setStroke(Color.BLACK);

            Text text = new Text(TypeValueFactory.get(type, i));

            rectangles.get(i).getChildren().addAll(r, text);
        }
        return rectangles;
    }

    /**
     * @param type
     * @see structvisualizer.AnimateMethod
     */
    @Override
    void animate(String type) {

        ArrayList<StackPane> rectangles = createArrayList(type);

        canvasPane.getChildren().addAll(rectangles);
        AnimateMethod.setTooltip(rectangles, type, customClass);
    }

    /**
     * @param os Class with templates of result
     * @return
     * @see structvisualizer.AnimateMethod
     */
    @Override
    String getCode(OutputStrings os) {

        String result = os.getCode() + "\n\t}\n}";

        return result;
    }

    /**
     * static method to form string with output
     *
     * @return String
     */
    public static String formOutput() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < data.getNumOfStackPanes(); i++) {
            if(i < data.getNumOfStackPanes() - 1) {
                sb.append("valueAtIndex(").append(i).append("), ");
            } else {
                sb.append("valueAtIndex(").append(i).append(") ");
            }
        }

        return sb.toString();
    }

    /**
     * @param os Class with templates of result
     * @return
     * @see structvisualizer.AnimateMethod
     */
    @Override
    String getOutput(OutputStrings os) {
        return formOutput() + "]";
    }
}

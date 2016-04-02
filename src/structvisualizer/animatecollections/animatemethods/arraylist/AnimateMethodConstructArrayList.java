package structvisualizer.animatecollections.animatemethods.arraylist;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;
import structvisualizer.valuefactories.TypeValueFactory;

import java.util.ArrayList;

/**
 * Animates constructor of ArrayList with 3 elements
 *
 * @author Kyrylo Havrylenko
 * @see AnimateMethod
 */
public class AnimateMethodConstructArrayList extends AnimateMethod {

    /**
     * @param canvasPane
     * @param type
     * @param obj
     * @see AnimateMethod
     */
    public AnimateMethodConstructArrayList(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }

    /**
     * Static method to create ArrayList with StackPane elements which will be next added to Pane (canvas) in app
     *
     * @param type String
     * @return ArrayList<StackPane>
     */
    public static ArrayList<StackPane> createArrayList(String type) {
        return createArrayList(type, data.getNumOfStackPanes());
    }

    public static ArrayList<StackPane> createArrayList(String type, int size) {
        return createArrayList(type, size, data.getWidth(), 0);
    }

    public static ArrayList<StackPane> createArrayList(String type, int size, int posX, int posY) {
        ArrayList<StackPane> rectangles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            StackPane stack = new StackPane();
            stack.setMinWidth(data.getWidth());
            stack.setLayoutX(posX + i * data.getWidth());
            stack.setLayoutY(posY);
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
     * @see AnimateMethod
     */
    @Override
    public void animate(String type) {

        ArrayList<StackPane> rectangles = createArrayList(type);

        canvasPane.getChildren().addAll(rectangles);
        AnimateMethod.setTooltip(rectangles, type, customClass);
    }

    /**
     * @param os Class with templates of result
     * @return
     * @see AnimateMethod
     */
    @Override
    public String getCode(OutputStrings os) {

        String result = os.getCode() + "\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        results = "Data structure was created";
        return results;
    }
}

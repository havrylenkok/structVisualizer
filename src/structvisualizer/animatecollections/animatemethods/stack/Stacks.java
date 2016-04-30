package structvisualizer.animatecollections.animatemethods.stack;

 /*
 * Stacks   4/27/16, 23:48
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.animatecollections.animatemethods.MethodsForSearch;
import structvisualizer.animatecollections.animatemethods.arraylist.Arraylists;
import structvisualizer.data.DataForAnimation;
import structvisualizer.valuefactories.TypeValueFactory;

import java.util.ArrayList;
import java.util.List;

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.createArrayList;
import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.newStackPane;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Stacks {
    static DataForAnimation data = new DataForAnimation();

    public static void searchForElement(MethodsForSearch method, String type, Pane canvasPane, SomeClass customClass,
                                        Object indexOf, int index) {
        ArrayList<StackPane> rectangles = createArrayList(type);
        VBox vBox = new VBox();
        vBox.setLayoutX(data.getStackPaneSize());
        vBox.getChildren().addAll(rectangles);
        canvasPane.getChildren().addAll(vBox);
        AnimateMethod.setTooltip(rectangles, type, customClass);

        StackPane sp = newStackPane(0, 0, canvasPane, data.getHightlightColor());

        int y = ((index > 0) ? index : 1) * data.getHeight();
        int anotherY = data.getNumOfStackPanes() * data.getHeight();

        double finalY = (y < anotherY) ? y : anotherY;

        method.animateSearch(sp, data.getStackPaneSize(), 0, data.getStackPaneSize(), finalY, canvasPane);
    }

    public static ArrayList<StackPane> createStack(String type, int size, double posX, double posY, int
            iteration, boolean rand, List<Integer> iterations, boolean write) {

        ArrayList<StackPane> rectangles = new ArrayList<>();
        int index = 0;
        for(; iteration < size; iteration++) {
            StackPane stack = new StackPane();
            stack.setMinWidth(data.getWidth());
            stack.setLayoutX(posX);
            stack.setLayoutY(posY + iteration * data.getHeight());
            rectangles.add(index, stack);

            Rectangle r = new Rectangle();
            r.setWidth(data.getWidth());
            r.setHeight(data.getHeight());
            r.setFill(Color.TRANSPARENT);
            r.setStroke(Color.BLACK);

            Text text = new Text(TypeValueFactory.get(type, iteration, rand, iterations, write));


            rectangles.get(index).getChildren().addAll(r, text);
            index++;
        }
        return rectangles;
    }

    /**
     * Static method to create ArrayList with StackPane elements which will be next added to Pane (canvas) in app
     *
     * @param type String
     *
     * @return ArrayList<StackPane>
     */
    public static ArrayList<StackPane> createStack(String type) {
        return createStack(type, data.getNumOfStackPanes());
    }

    /**
     *
     * @param type
     * @param size
     * @return
     */
    public static ArrayList<StackPane> createStack(String type, int size) {
        return createStack(type, size, data.getWidth(), 0);
    }

    /**
     *
     * @param type
     * @param size
     * @param posX
     * @param posY
     * @return
     */
    public static ArrayList<StackPane> createStack(String type, int size, double posX, double posY) {
        return createStack(type, size, posX, posY, 0);
    }

    /**
     *
     * @param type
     * @param size
     * @param posX
     * @param posY
     * @param iteration
     * @return
     */
    public static ArrayList<StackPane> createStack(String type, int size, double posX, double posY, int iteration) {
        return createStack(type, size, posX, posY, iteration, false, null, false);
    }



}

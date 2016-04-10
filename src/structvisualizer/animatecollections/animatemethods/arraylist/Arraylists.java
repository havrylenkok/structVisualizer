package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Arraylists   4/10/16, 13:23
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.DataForAnimation;
import structvisualizer.valuefactories.TypeValueFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Arraylists {
    static DataForAnimation data = new DataForAnimation();

    /**
     * Static method to create ArrayList with StackPane elements which will be next added to Pane (canvas) in app
     *
     * @param type String
     *
     * @return ArrayList<StackPane>
     */
    public static ArrayList<StackPane> createArrayList(String type) {
        return createArrayList(type, data.getNumOfStackPanes());
    }

    public static ArrayList<StackPane> createArrayList(String type, int size) {
        return createArrayList(type, size, data.getWidth(), 0);
    }

    public static ArrayList<StackPane> createArrayList(String type, int size, double posX, double posY) {
        return createArrayList(type, size, posX, posY, 0);
    }

    public static ArrayList<StackPane> createArrayList(String type, int size, double posX, double posY, int iteration) {
        return createArrayList(type, size, posX, posY, iteration, false, null, false);
    }

    public static ArrayList<StackPane> createArrayList(String type, int size, double posX, double posY, int
            iteration, boolean rand, List<Integer> iterations, boolean write) {
        //        List<String> values = new ArrayList<>();
        //        for(; iteration < size; iteration++) {
        //            values.add(TypeValueFactory.get(type, iteration));
        //        }
        //
        //        return createArrayList(type, size, posX, posY, iteration, values);
        ArrayList<StackPane> rectangles = new ArrayList<>();
        int index = 0;
        for(; iteration < size; iteration++) {
            StackPane stack = new StackPane();
            stack.setMinWidth(data.getWidth());
            stack.setLayoutX(posX + iteration * data.getWidth());
            stack.setLayoutY(posY);
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

    //    public static ArrayList<StackPane> createArrayList(String type, int size, double posX, double posY, int
    //            iteration, List<String> values) {
    //        ArrayList<StackPane> rectangles = new ArrayList<>();
    //        int index = 0;
    //        for(; iteration < size; iteration++) {
    //            StackPane stack = new StackPane();
    //            stack.setMinWidth(data.getWidth());
    //            stack.setLayoutX(posX + iteration * data.getWidth());
    //            stack.setLayoutY(posY);
    //            rectangles.add(index, stack);
    //
    //            Rectangle r = new Rectangle();
    //            r.setWidth(data.getWidth());
    //            r.setHeight(data.getHeight());
    //            r.setFill(Color.TRANSPARENT);
    //            r.setStroke(Color.BLACK);
    //
    //            Text text = new Text(values.get(index));
    //
    //            rectangles.get(index).getChildren().addAll(r, text);
    //            index++;
    //        }
    //        return rectangles;
    //    }

    /**
     * Static method to create ArrayList<StackPane> of elements to show on Pane (canvas)
     *
     * @param rectangles ArrayList where to add StackPane
     * @param type       Type of values in ArrayList
     *
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

        Text text = new Text(TypeValueFactory.get(type, data.getNumOfStackPanes(), false, null, true));

        rectangles.get(data.getNumOfStackPanes()).getChildren().addAll(r, text);
        return rectangles;
    }

    public static ArrayList<StackPane> clearAnimation(ArrayList<StackPane> stack) {
        int counter = 1000;
        for(StackPane s : stack) {
            FadeTransition fade = new FadeTransition(Duration.millis(data.getFade() + counter), s);
            fade.setFromValue(1);
            fade.setToValue(0);
            fade.play();
            counter -= 100;

        }
        return stack;
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

    public static void highlightNode(Rectangle rectangle, Color colorFrom, Color colorTo) {

        FillTransition ft = new FillTransition(Duration.millis(data.getTransitionInvisible()), rectangle, colorFrom,
                                               colorTo);
        ft.play();
    }

    public static StackPane newStackPane(double x, double y, Pane canvas, Color color) {
        StackPane stack = new StackPane();
        stack.setMinWidth(data.getWidth());
        stack.setLayoutX(x);
        stack.setLayoutY(y);

        Rectangle r = new Rectangle();
        r.setWidth(data.getWidth());
        r.setHeight(data.getHeight());
        r.setFill(color);
        r.setStroke(Color.BLACK);

        stack.getChildren().addAll(r);

        canvas.getChildren().addAll(stack);
        return stack;


    }

    public static void searchForElement(MethodsForSearch method, String type, Pane canvasPane, SomeClass customClass,
                                        Object indexOf, int index) {
        ArrayList<StackPane> rectangles = createArrayList(type);
        canvasPane.getChildren().addAll(rectangles);
        AnimateMethod.setTooltip(rectangles, type, customClass);

        StackPane sp = newStackPane(0, 0, canvasPane, data.getHightlightColor());

        int x = (index + 1) * data.getWidth();
        int anotherX = data.getNumOfStackPanes() * data.getWidth();

        double finalX = (x < anotherX) ? x : anotherX;

        //        for(int i = 0; i < data.getNumOfStackPanes(); i++) {
        //            String text = rectangles.get(i).getChildren().get(1).toString();
        //            // indexOf - VALUE OF ELEMENT WHAT WE LOOKING FOR
        //            if(!text.substring(11, 12).equals(indexOf)) {
        //                System.out.println(text.substring(11, 12) + " " + indexOf);
        //                finalX += data.getWidth();
        //            }
        //        }
        method.animateSearch(sp, 0, 0, finalX, 0, canvasPane);
    }

    public static StackPane newValStackpane(String type, double x, double y, String value, int iteration) {
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
            text = new Text(TypeValueFactory.get(type, iteration, false, null, true));
        } else {
            text = new Text(value);
        }
        stack.getChildren().addAll(r, text);

        return stack;

    }

    public static void fadeAndShowTransition(ArrayList<StackPane> origin, ArrayList<StackPane> sorted) {
        int counter = 1000;

        for(StackPane s : origin) {
            FadeTransition fade = new FadeTransition(Duration.millis(data.getFade() + counter), s);
            fade.setFromValue(1);
            fade.setToValue(0);
            fade.play();
            counter -= 100;

            fade.setOnFinished(event -> {
                for(StackPane z : sorted) {
                    z.setVisible(true);
                }
            });

        }
    }
}

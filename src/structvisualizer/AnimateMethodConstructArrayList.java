package structvisualizer;
 /*
 * AnimateMethodConstructArrayList   3/15/16, 17:39
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Kyrylo Havrylenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

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
    AnimateMethodConstructArrayList(Pane canvasPane, String type) {
        super(canvasPane, type);
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
    }

    /**
     * @param os Class with templates of result
     * @return
     * @see structvisualizer.AnimateMethod
     */
    @Override
    String getCode(OutputStrings os) {

        String result = os.getCode() + "\n\t\t}\n}";

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

package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Sort   4/9/16, 19:34
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.clearAnimation;
import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.fadeAndShowTransition;

/**
 * Animates ArrayList.sort() method (and other type of sort in Java)
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Sort extends AnimateMethod {
    public Sort(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }



    @Override
    public void animate(String type) throws UnsupportedOperationException {
        List<Integer> iterations = new ArrayList<>();
        ArrayList<StackPane> origin = Arraylists.createArrayList(type, data.getNumOfStackPanes(), data.getWidth(), 0,
                                                                 0, true, iterations, true);
        canvasPane.getChildren().addAll(origin);
        AnimateMethod.setTooltip(origin, type, customClass, iterations);

        Collections.sort(iterations);
        ArrayList<StackPane> sorted = Arraylists.createArrayList(type, data.getNumOfStackPanes(), data.getWidth(), 0,
                                                                 0, true, iterations, false);
        for(StackPane s : sorted) {
            s.setVisible(false);
        }

        canvasPane.getChildren().addAll(sorted);
        AnimateMethod.setTooltip(sorted, type, customClass, iterations);
        fadeAndShowTransition(origin, sorted);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getPackage();
        result += os.getImportMain();
        result += os.getCollection();
        result += "/* Use Random.nextInt() (or else) to fill structure,\nthen Collection.sort(structureName)" +
                ";*/";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "You now have sorted in ascending order data structure.\nIf you need another type of order in your " +
                "sorted structure look up for Comparator class and it's Java 8 version.";
    }
}

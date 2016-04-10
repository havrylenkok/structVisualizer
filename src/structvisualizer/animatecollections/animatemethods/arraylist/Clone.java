package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Clone   4/2/16, 19:48
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.data.OutputStrings;

import java.util.ArrayList;

import static structvisualizer.animatecollections.animatemethods.arraylist.Arraylists.translateStackpanes;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Clone extends AnimateMethod {
    public Clone(Pane canvasPane, String type, SomeClass obj) {
        super(canvasPane, type, obj);
    }


    @Override
    public void animate(String type) throws UnsupportedOperationException {
        ArrayList<StackPane> origin = Arraylists.createArrayList(type);
        ArrayList<StackPane> clone = Arraylists.createArrayList(type);
        translateStackpanes(clone);
        //        TranslateTransition tt = new TranslateTransition(Duration.ZERO, origin);

        canvasPane.getChildren().addAll(origin);
        canvasPane.getChildren().addAll(clone);
        AnimateMethod.setTooltip(origin, type, customClass);
        AnimateMethod.setTooltip(clone, type, customClass);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getCode() + "\n\tArrayList<" + type + "> clone = tmp.clone();" + "\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "You now have 2 identical structures in memory.";
    }
}

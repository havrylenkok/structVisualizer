package structvisualizer.animatecollections;

 /*
 * AnimateStack   4/27/16, 23:57
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.animatecollections.AnimateStructure;
import structvisualizer.data.Collections;
import structvisualizer.data.DataForValueFactory;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateStack extends AnimateStructure {

    public AnimateStack(String method, String type, Pane canvasPane, SomeClass obj, DataForValueFactory input) {
        super(Collections.STACK, method, type, canvasPane, obj, input);
    }


}

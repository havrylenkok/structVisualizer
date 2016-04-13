package structvisualizer.animatecollections;

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.data.Collections;
import structvisualizer.data.DataForValueFactory;

/**
 * Animates ArrayList
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateArrayList extends AnimateStructure {

    /**
     * @see AnimateStructure
     * @param method
     * @param type
     * @param canvasPane
     */
    public AnimateArrayList(String method, String type, Pane canvasPane, SomeClass obj, DataForValueFactory input) {
        super(Collections.ARRAY_LIST, method, type, canvasPane, obj, input);
    }
}

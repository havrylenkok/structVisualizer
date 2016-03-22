package structvisualizer;

import javafx.scene.layout.Pane;
import parser.SomeClass;

import java.util.ArrayList;

/**
 * Animates ArrayList
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateArrayList extends AnimateStructure {

    /**
     * @see structvisualizer.AnimateStructure
     * @param method
     * @param type
     * @param canvasPane
     */
    public AnimateArrayList(String method, String type, Pane canvasPane, SomeClass obj) {
        super(Collections.ARRAY_LIST, method, type, canvasPane, obj);
    }
}

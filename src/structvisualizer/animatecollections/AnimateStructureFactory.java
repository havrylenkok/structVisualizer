package structvisualizer.animatecollections;

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.animatecollections.AnimateArrayList;
import structvisualizer.animatecollections.AnimateNothing;
import structvisualizer.animatecollections.AnimateStructure;
import structvisualizer.data.Collections;

/**
 * Factory to pick right AnimateClass for input structure of data type
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateStructureFactory {
    /**
     * getter
     *
     * @param structName
     * @param methodName
     * @param typeName
     * @param canvas
     * @param obj
     * @return object of right type for input structure of data name
     */
    public static AnimateStructure get(String structName, String methodName, String typeName, Pane canvas, SomeClass
            obj) {

        switch (structName) {
            case Collections.ARRAY_LIST:
                return new AnimateArrayList(methodName, typeName, canvas, obj);
            case Collections.HASH_MAP:
                return new AnimateNothing(methodName, typeName, canvas, obj);
            case Collections.STACK:
                return new AnimateNothing(methodName, typeName, canvas, obj);
            case Collections.SET:
                return new AnimateNothing(methodName, typeName, canvas, obj);
            default:
                return new AnimateNothing(methodName, typeName, canvas, obj);
        }
    }
}

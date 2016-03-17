package structvisualizer;

import javafx.scene.layout.Pane;

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
     * @return object of right type for input structure of data name
     */
    static AnimateStructure get(String structName, String methodName, String typeName, Pane canvas) {

        switch (structName) {
            case Collections.ARRAY_LIST:
                return new AnimateArrayList(methodName, typeName, canvas);
            case Collections.HASH_MAP:
                return new AnimateNothing(methodName, typeName, canvas);
            case Collections.STACK:
                return new AnimateNothing(methodName, typeName, canvas);
            case Collections.SET:
                return new AnimateNothing(methodName, typeName, canvas);
            default:
                return new AnimateNothing(methodName, typeName, canvas);
        }
    }
}

package structvisualizer.animatecollections.animatemethods;

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.arraylist.AnimateMethodAddArrayList;
import structvisualizer.animatecollections.animatemethods.arraylist.AnimateMethodClearArrayList;
import structvisualizer.animatecollections.animatemethods.arraylist.AnimateMethodConstructArrayList;
import structvisualizer.data.Collections;
import structvisualizer.data.Methods;

/**
 * Factory of methods which select needed class of <T extends AnimateMethod>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateMethodFactory {
    /**
     * Factory of methods which select needed class of <T extends AnimateMethod>
     *
     * @param methodName
     * @param canvas         Pane where to draw
     * @param collectionName
     * @param type           typeName
     * @param obj
     * @return object of needed animation class
     * @see AnimateMethod
     */
    public static AnimateMethod get(String methodName, Pane canvas, String collectionName, String type, SomeClass obj) {
        switch (methodName) {
            case Methods.ADD:
                switch (collectionName) {
                    case Collections.ARRAY_LIST:
                        return new AnimateMethodAddArrayList(canvas, type, obj);
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.CONSTRUCT:
                switch (collectionName) {
                    case Collections.ARRAY_LIST:
                        return new AnimateMethodConstructArrayList(canvas, type, obj);
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.CLEAR:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
                        return new AnimateMethodClearArrayList(canvas, type, obj);
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.CONTAINS:
            case Methods.EQUALS:
            case Methods.IS_EMPTY:
            case Methods.REMOVE:
            case Methods.SIZE:
            case Methods.CLONE:
            case Methods.GET:
            case Methods.SET:
            case Methods.GET_INDEX:
            case Methods.SORT:
            case Methods.SUBLIST:
            case Methods.PEEK:
            case Methods.POP:
            case Methods.PUSH:
            case Methods.SEARCH:
            case Methods.CONTAINS_KEY:
            case Methods.CONTAINS_VALUE:
            case Methods.PUT:
            case Methods.VALUES:
            case Methods.REPLACE:
            default:
                return new AnimateMethod(canvas, type, obj);
        }
    }
}

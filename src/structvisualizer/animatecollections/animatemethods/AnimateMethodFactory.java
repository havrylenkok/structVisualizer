package structvisualizer.animatecollections.animatemethods;

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.Main;
import structvisualizer.animatecollections.animatemethods.arraylist.*;
import structvisualizer.data.Collections;
import structvisualizer.data.Methods;
import structvisualizer.data.DataForValueFactory;
import structvisualizer.valuefactories.TypeValueFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Factory of methods which select needed class of <T extends AnimateMethod>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateMethodFactory {
    private static final Logger logger = Logger.getLogger(AnimateMethodFactory.class.getName());
    /**
     * Factory of methods which select needed class of <T extends AnimateMethod>
     *
     * @param methodName
     * @param canvas         Pane where to draw
     * @param collectionName
     * @param type           typeName
     * @param obj
     * @param input
     * @return object of needed animation class
     * @see AnimateMethod
     */
    public static AnimateMethod get(String methodName, Pane canvas, String collectionName, String type, SomeClass
            obj, DataForValueFactory input) {
        if(input == null) {
            input = new DataForValueFactory(2, false, null, true, 1, 2);
        }
        switch (methodName) {
            case Methods.ADD:
                switch (collectionName) {
                    case Collections.ARRAY_LIST:
                        return new Add(canvas, type, obj);
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.CONSTRUCT:
                switch (collectionName) {
                    case Collections.ARRAY_LIST:
                        return new Construct(canvas, type, obj);
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.CLEAR:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
                        return new Clear(canvas, type, obj);
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.GET_INDEX:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
//                        return new GetIndex(canvas, type, obj, TypeValueFactory.get(type, 2, false, null, true), 2);
                        return new GetIndex(canvas, type, obj, TypeValueFactory.get(type, input), input.getIteration());
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.GET:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
                        return new Get(canvas, type, obj, TypeValueFactory.get(type, input), input.getIteration());
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.SET:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
                        return new Set(canvas, type, obj, TypeValueFactory.get(type, input), input.getSetWhat(),
                                       input.getSetToWhat());
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.CLONE:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
                        return new Clone(canvas, type, obj);
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.REMOVE:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
                        return new Remove(canvas, type, obj, TypeValueFactory.get(type, input), input.getIteration());
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.CONTAINS:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
//                        return new Contains(canvas, type, obj, TypeValueFactory.get(type, 20, false, null, true),
//                                            20);
                        logger.log(Level.FINE, input + " " + input.getIteration());
                        return new Contains(canvas, type, obj, TypeValueFactory.get(type, input), input.getIteration());
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.SUBLIST:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
                        return new Sublist(canvas, type, obj, input.getSetWhat(), input.getSetToWhat());
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.SORT:
                switch(collectionName) {
                    case Collections.ARRAY_LIST:
                        return new Sort(canvas, type, obj);
                    default:
                        return new AnimateMethod(canvas, type, obj);
                }
            case Methods.EQUALS:
            case Methods.IS_EMPTY:
            case Methods.SIZE:
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

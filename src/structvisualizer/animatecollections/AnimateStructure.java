package structvisualizer.animatecollections;

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.data.OutputStrings;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.animatecollections.animatemethods.AnimateMethodFactory;

/**
 * Interface for classes to draw COLLECTION's methods
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateStructure {
    private AnimateMethod am;
    private OutputStrings os;
    private String collectionType;

    /**
     * Constructor
     *
     * @param collection collectionName
     * @param method     methodName
     * @param type       typeName
     * @param canvasPane Pane where to draw
     */
    public AnimateStructure(String collection, String method, String type, Pane canvasPane, SomeClass obj) {
        collectionType = collection;
        am = AnimateMethodFactory.get(method, canvasPane, collectionType, type, obj);
        os = new OutputStrings(collectionType, method, type);
    }


    /**
     * animate method
     *
     * @param type typeName
     */
    public void animate(String type) {
        am.animate(type);
    }

    /**
     * get code to recreate process in animation
     *
     * @return Strng
     */
    public String getCode() {
        return am.getCode(os);
    }

}

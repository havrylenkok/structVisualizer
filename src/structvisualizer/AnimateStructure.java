package structvisualizer;

import javafx.scene.layout.Pane;
import parser.SomeClass;

import java.util.Collection;

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
     * @param collection collectionName
     * @param method methodName
     * @param type typeName
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
     * @param type       typeName
     */
    void animate(String type) {
        am.animate(type);
    }

    /**
     * get code to recreate process in animation
     *
     * @return Strng
     */
    String getCode() {
        return am.getCode(os);
    }

    /**
     * get output of {@link AnimateStructure#getCode()} method's execution
     *
     * @return String
     */
    String getOutput() {
        return am.getOutput(os);
    }
}

package structvisualizer.animatecollections;

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.data.Collections;

/**
 * method with nothing to draw for unsupported collection or set
 *
 * @author Kyrylo Havrylenko
 * @see AnimateStructure
 */
public class AnimateNothing extends AnimateStructure {

    public AnimateNothing(String method, String type, Pane canvasPane, SomeClass obj) {
        super(Collections.ARRAY_LIST, method, type, canvasPane, obj);
    }

    /**
     * @param method
     * @param type
     * @param canvasPane
     * @throws UnsupportedOperationException
     * @see AnimateStructure
     */
    @Override
    public void animate(String type) throws UnsupportedOperationException {
        System.err.println("UnsupportedOperation animate(" + type + ") -> AnimateNothig.java(51)"); // TODO: log
        throw new UnsupportedOperationException();
    }

    /**
     * @return
     * @throws UnsupportedOperationException
     * @see AnimateStructure
     */
    @Override
    public String getCode() throws UnsupportedOperationException {
        System.err.println("UnsupportedOperation on getCode(AnimateNothing->57)"); // TODO: log
        throw new UnsupportedOperationException();
    }

    /**
     * @return
     * @throws UnsupportedOperationException
     * @see AnimateStructure
     */
    @Override
    public String getOutput() throws UnsupportedOperationException {
        System.err.println("UnsupportedOperation on getOutput(AnimateNothing->68)"); // TODO: log
        throw new UnsupportedOperationException();
    }
}

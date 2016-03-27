package structvisualizer.animatecollections;

import javafx.scene.layout.Pane;
import parser.SomeClass;
import structvisualizer.data.Collections;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * method with nothing to draw for unsupported collection or set
 *
 * @author Kyrylo Havrylenko
 * @see AnimateStructure
 */
public class AnimateNothing extends AnimateStructure {
    private static final Logger logger = Logger.getLogger(AnimateNothing.class.getName());

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
        logger.log(Level.INFO, "UnsupportedOperation animate(" + type + ")");
        throw new UnsupportedOperationException();
    }

    /**
     * @return
     * @throws UnsupportedOperationException
     * @see AnimateStructure
     */
    @Override
    public String getCode() throws UnsupportedOperationException {
        logger.log(Level.INFO, "UnsupportedOperation on getCode()");
        throw new UnsupportedOperationException();
    }

    /**
     * @return
     * @throws UnsupportedOperationException
     * @see AnimateStructure
     */
    @Override
    public String getOutput() throws UnsupportedOperationException {
        logger.log(Level.INFO, "UnsupportedOperation on getOutput(AnimateNothing->68)");
        throw new UnsupportedOperationException();
    }
}

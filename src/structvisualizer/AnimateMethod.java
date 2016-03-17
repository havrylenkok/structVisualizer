package structvisualizer;

import javafx.scene.layout.Pane;

/**
 * Parent class for concrete animation classes
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateMethod {
    Pane canvasPane;
    String type;
    static DataForMethodAnimate data;

    /**
     * Constructor
     *
     * @param canvasPane
     * @param type       string with name of type
     */
    AnimateMethod(Pane canvasPane, String type) {
        this.canvasPane = canvasPane;
        this.type = type;
        this.data = new DataForMethodAnimate();
    }

    /**
     * Animates stated method with stated values of type
     *
     * @param type
     * @throws UnsupportedOperationException
     */
    void animate(String type) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Forms String with code to recreate process in animation
     *
     * @param os Class with templates of result
     * @return String with code to recreate process in animation
     * @throws UnsupportedOperationException
     */
    String getCode(OutputStrings os) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Forms string with supposed output of getCode()
     *
     * @param os Class with templates of result
     * @return string
     * @throws UnsupportedOperationException
     */
    String getOutput(OutputStrings os) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}

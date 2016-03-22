package structvisualizer;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import parser.SomeClass;

import java.util.ArrayList;

/**
 * Parent class for concrete animation classes
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateMethod {
    Pane canvasPane;
    String type;
    SomeClass customClass = null;
    static DataForMethodAnimate data;

    /**
     * Constructor
     *
     * @param canvasPane
     * @param type       string with name of type
     */
    AnimateMethod(Pane canvasPane, String type, SomeClass obj) {
        this.canvasPane = canvasPane;
        this.type = type;
        this.customClass = obj;
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

    public static void setTooltip(ArrayList<StackPane> where, String type, SomeClass obj) {
        int i = 0;
        for(StackPane s : where) {
            Tooltip.install(s, new Tooltip(TooltipValueFactory.get(type, i, obj)));
            i++;
        }
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

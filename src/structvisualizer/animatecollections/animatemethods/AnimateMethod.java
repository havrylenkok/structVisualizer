package structvisualizer.animatecollections.animatemethods;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import parser.SomeClass;
import structvisualizer.data.DataForMethodAnimate;
import structvisualizer.data.OutputStrings;
import structvisualizer.valuefactories.TooltipValueFactory;

import java.util.ArrayList;

/**
 * Parent class for concrete animation classes
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateMethod {
    public Pane canvasPane;
    public String type;
    public SomeClass customClass = null;
    public static DataForMethodAnimate data;
    public String results = "";

    /**
     * Constructor
     *
     * @param canvasPane
     * @param type       string with name of type
     * @param obj
     */
    public AnimateMethod(Pane canvasPane, String type, SomeClass obj) {
        this.canvasPane = canvasPane;
        this.type = type;
        this.customClass = obj;
        this.data = new DataForMethodAnimate();
        this.results = "";
    }

    /**
     * Animates stated method with stated values of type
     *
     * @param type
     * @throws UnsupportedOperationException
     */
    public void animate(String type) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public static void setTooltip(ArrayList<StackPane> where, String type, SomeClass obj) {
        int i = 0;
        for(StackPane s : where) {
            Tooltip.install(s, new Tooltip(TooltipValueFactory.get(type, i, obj)));
            i++;
        }
    }

    public static void setTooltip(ArrayList<StackPane> where, String value) {
        int i = 0;
        for(StackPane s : where) {
            Tooltip.install(s, new Tooltip(value));
        }
    }

    /**
     * Forms String with code to recreate process in animation
     *
     * @param os Class with templates of result
     * @return String with code to recreate process in animation
     * @throws UnsupportedOperationException
     */
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }


}

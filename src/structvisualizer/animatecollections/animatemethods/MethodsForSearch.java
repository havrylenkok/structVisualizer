package structvisualizer.animatecollections.animatemethods;

 /*
 * MethodsForSearch   4/9/16, 18:58
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Interface for animation of methods where needed search of element
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public interface MethodsForSearch {
    /**
     *
     * @param redRectangle
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @param canvas
     */
    public void animateSearch(StackPane redRectangle, double fromX, double fromY, double toX, double toY, Pane canvas);
}

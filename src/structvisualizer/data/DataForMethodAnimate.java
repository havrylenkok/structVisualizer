package structvisualizer.data;

import javafx.scene.paint.Color;

/**
 * Magic constants for app
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class DataForMethodAnimate {
    private int numOfStackPanes = 3;
    private int width = 50;
    private int height = 50;
    private int stackPaneSize = 200;
    private float transitionInvisible = 0.0f;
    private float transitionVisible = 1.0f;
    private int timeFade = 1000;
    private int timeTranslate = 3000;
    private int fade = 2000;
    private Color normalColor = Color.BLACK;
    private Color hightlightColor = Color.RED;
    private Color successColor = Color.GREEN;
    private int yCoordForClone = 100;

    public int getyCoordForClone() {
        return yCoordForClone;
    }

    public Color getNormalColor() {
        return normalColor;
    }

    public Color getHightlightColor() {
        return hightlightColor;
    }

    public Color getSuccessColor() {
        return successColor;
    }

    public int getFade() {
        return fade;
    }

    public void setFade(int fade) {
        this.fade = fade;
    }

    public int getNumOfStackPanes() {
        return numOfStackPanes;
    }

    public void setNumOfStackPanes(int numOfStackPanes) {
        this.numOfStackPanes = numOfStackPanes;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStackPaneSize() {
        return stackPaneSize;
    }

    public void setStackPaneSize(int stackPaneSize) {
        this.stackPaneSize = stackPaneSize;
    }

    public float getTransitionInvisible() {
        return transitionInvisible;
    }

    public void setTransitionInvisible(float transitionInvisible) {
        this.transitionInvisible = transitionInvisible;
    }

    public float getTransitionVisible() {
        return transitionVisible;
    }

    public void setTransitionVisible(float transitionVisible) {
        this.transitionVisible = transitionVisible;
    }

    public int getTimeFade() {
        return timeFade;
    }

    public void setTimeFade(int timeFade) {
        this.timeFade = timeFade;
    }

    public int getTimeTranslate() {
        return timeTranslate;
    }

    public void setTimeTranslate(int timeTranslate) {
        this.timeTranslate = timeTranslate;
    }
}

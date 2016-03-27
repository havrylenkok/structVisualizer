package structvisualizer.data;

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

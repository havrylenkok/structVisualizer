package structvisualizer;
 /*
 * DataForAddMethodAnimate   3/15/16, 16:50
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Kyrylo Havrylenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
class DataForAddMethodAnimate {
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

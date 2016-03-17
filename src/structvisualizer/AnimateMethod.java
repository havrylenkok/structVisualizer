package structvisualizer;
 /*
 * AnimateMethod   3/15/16, 15:41
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
        System.err.println("UnsupportedOperation" + type); // TODO: log
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
        System.err.println("UnsupportedOperation" + type); // TODO: log
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
        System.err.println("UnsupportedOperation" + type); // TODO: log
        throw new UnsupportedOperationException();
    }
}

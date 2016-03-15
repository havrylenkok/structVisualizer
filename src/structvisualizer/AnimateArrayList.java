package structvisualizer;
 /*
 * AnimateArrayList   3/15/16, 15:25
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

import java.util.ArrayList;

/**
 * Animates ArrayList
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateArrayList implements AnimateStructure {
    private String collectionType = Collections.ARRAY_LIST;
    private AnimateMethod am;
    private OutputStrings os;

    /**
     * Draws animation of method from ArrayList interface with stated type on stated Pane
     *
     * @param method     name of method
     * @param type       name of type
     * @param canvasPane link to Pane where to draw
     */
    @Override
    public void animate(String method, String type, Pane canvasPane) {

        am = AnimateMethodFactory.get(method, canvasPane, collectionType, type);
        os = new OutputStrings(collectionType, method, type);
        am.animate(type);
    }

    /**
     * @return string with code to write in your program to recreate animation's process
     */
    @Override
    public String getCode() {
        return am.getCode(os);
    }

    /**
     * @return string with supposed output of getCode()
     * @see {@link #getCode() getCode} method
     */
    @Override
    public String getOutput() {
        return am.getOutput(os);
    }
}

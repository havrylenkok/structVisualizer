package structvisualizer;
 /*
 * AnimateStructure   3/15/16, 15:21
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

import java.util.Collection;

/**
 * Interface for classes to draw COLLECTION's methods
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateStructure {
    private AnimateMethod am;
    private OutputStrings os;
    private String collectionType;

    public AnimateStructure(String collection, String method, String type, Pane canvasPane) {
        collectionType = collection;
        am = AnimateMethodFactory.get(method, canvasPane, collectionType, type);
        os = new OutputStrings(collectionType, method, type);
    }


    /**
     * animate method
     *
     * @param method     methodName
     * @param type       typeName
     * @param canvasPane Pane where to draw
     */
    void animate(String type) {
        am.animate(type);
    }

    /**
     * get code to recreate process in animation
     *
     * @return Strng
     */
    String getCode() {
        return am.getCode(os);
    }

    /**
     * get output of {@link AnimateStructure#getCode()} method's execution
     *
     * @return String
     */
    String getOutput() {
        return am.getOutput(os);
    }
}

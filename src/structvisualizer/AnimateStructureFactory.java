package structvisualizer;
 /*
 * AnimateStructureFactory   3/15/16, 15:27
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
 * Factory to pick right AnimateClass for input structure of data type
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateStructureFactory {
    /**
     * getter
     *
     * @param structName
     * @return object of right type for input structure of data name
     */
    static AnimateStructure get(String structName, String methodName, String typeName, Pane canvas) {

        switch (structName) {
            case Collections.ARRAY_LIST:
                return new AnimateArrayList(methodName, typeName, canvas);
            case Collections.HASH_MAP:
                return new AnimateNothing(methodName, typeName, canvas);
            case Collections.STACK:
                return new AnimateNothing(methodName, typeName, canvas);
            case Collections.SET:
                return new AnimateNothing(methodName, typeName, canvas);
            default:
                return new AnimateNothing(methodName, typeName, canvas);
        }
    }
}

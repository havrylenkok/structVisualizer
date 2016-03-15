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

import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
class AnimateMethod {
    Pane canvasPane;
    String type;
    DataForAddMethodAnimate data;

    AnimateMethod(Pane canvasPane, String type) {
        this.canvasPane = canvasPane;
        this.type = type;
        this.data = new DataForAddMethodAnimate();
    }

    void animate(String type) {
        throw new UnsupportedOperationException();
    }
    String getCode() {
        throw new UnsupportedOperationException();
    }
    String getOutput() {
        throw new UnsupportedOperationException();
    }
}

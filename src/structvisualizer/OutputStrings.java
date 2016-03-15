package structvisualizer;
 /*
 * OutputStrings   3/15/16, 17:47
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

import java.util.List;

/**
 * Base class to create text for codeOutput and output TextAreas in javafx GUI
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class OutputStrings {
    private String code;
    private String output;

    OutputStrings(String collectionType, String method, String type) {
        DataForMethodAnimate data = new DataForMethodAnimate();
        StringBuilder codeBuilder = new StringBuilder();
        codeBuilder
                .append("package ").append(collectionType).append(";\n\n")
                .append("import java.util.*;\n\n")
                .append("public class").append(collectionType).append(" {\n")
                .append("\tpublic static void main(String[] args) {\n\t\t").append(collectionType).append("<")
                .append(type).append(">").append(" tmp = new ").append(collectionType).append("<").append(">();\n\t\t")
                .append("for(int i = 0; i < ").append(data.getNumOfStackPanes()).append("; i++) {\n\t\t\t")
                .append("tmp.add(i, i);\n\t\t}\n\t\t");
        code = codeBuilder.toString();
        output = "";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}

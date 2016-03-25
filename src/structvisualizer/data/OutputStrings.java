package structvisualizer.data;

import structvisualizer.data.DataForMethodAnimate;

/**
 * Base class to create text for codeOutput and output TextAreas in javafx GUI
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class OutputStrings {
    private String code;
    private String output;

    public OutputStrings(String collectionType, String method, String type) {
        DataForMethodAnimate data = new DataForMethodAnimate();
        StringBuilder codeBuilder = new StringBuilder();
        codeBuilder
                .append("package ").append(collectionType).append(";\n\n")
                .append("import java.util.*;\n\n")
                .append("public class Main").append(" {\n")
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
    } // // TODO: 3/25/16 update functionality to something meanful 

    public void setOutput(String output) {
        this.output = output;
    }
}

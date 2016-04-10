package structvisualizer.data;

/**
 * Base class to create text for codeOutput and output TextAreas in javafx GUI
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class OutputStrings {
    private String code;
    private String collectionType;
    private String type;

    public OutputStrings(String collectionType, String method, String type) {
        DataForAnimation data = new DataForAnimation();
        this.collectionType = collectionType;
        this.type = type;
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

    }

    public String getPackage() {
        return "package " + collectionType + ";\n\n";
    }

    public String getImportMain() {
        return "public class Main\n\tpublic static void main(String[] args) {\n";
    }

    public String getCollection() {
        return "\t\t" + collectionType + "<" + type + ">" + " tmp = new " + collectionType + "<>()\n";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}

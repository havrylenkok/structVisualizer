package structvisualizer;

/**
 * Factory for values in output TextArea and in StackPane (animation) which returns value of the right type
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class TypeValueFactory {

    static String get(String type, int iteration) {

        switch (type) {
            case Types.INT:
                int intRes = 0;
                for (; intRes < iteration; intRes++) ;
                return "" + intRes;
            case Types.STRING:
                char strRes = 'a';
                for (int i = 0; i < iteration; i++) {
                    strRes++;
                }
                return "" + strRes;
            default:
                return "";
        }

    }
}

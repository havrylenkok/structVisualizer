package structvisualizer;

 /*
 * TooltipValueFactory   3/22/16, 20:52
 *
 * By Kyrylo Havrylenko
 *
 */

import parser.SomeClass;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class TooltipValueFactory {
    public static String getStringValue(int iteration) {
        char strRes = 'a';
        for (int i = 0; i < iteration; i++) {
            strRes++;
        }
        StringBuilder sb = new StringBuilder(strRes);
        for(int i = 0; i < iteration; i++) {
            sb.append(strRes);
        }
        return sb.toString();
    }

    public static String get(String type, int iteration, SomeClass obj) {
        switch(type) {
            case Types.INT:
                return "" + iteration;
            case Types.STRING:
                return getStringValue(iteration);
            case Types.CUSTOM:
                return obj.getOneInstanceString(iteration);
            case Types.SOME_CLASS:
                obj = new SomeClass(1, 2, 3, 4);
                return obj.getOneInstanceString(iteration);
            default:
                return "";
        }
    }
}

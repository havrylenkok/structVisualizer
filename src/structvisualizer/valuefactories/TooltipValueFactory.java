package structvisualizer.valuefactories;

 /*
 * TooltipValueFactory   3/22/16, 20:52
 *
 * By Kyrylo Havrylenko
 *
 */

import parser.SomeClass;
import structvisualizer.data.Types;

import java.util.Random;

/**
 * Generates tooltip values for animation objects
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class TooltipValueFactory {
    /**
     * @param iteration step of multipling base input
     *
     * @return
     */
    public static String getStringValue(int iteration) {

        char strRes = 'a';
        for(int i = 0; i < iteration; i++) {
            strRes++;
        }
        StringBuilder sb = new StringBuilder(strRes);
        sb.append(strRes);
        for(int i = 0; i < iteration; i++) {
            sb.append(strRes);
        }
        return sb.toString();

    }

    /**
     * Generetaes tooltip for SomeClass
     * @see SomeClass
     * @param type
     * @param iteration
     * @param obj
     * @return
     */
    public static String get(String type, int iteration, SomeClass obj) {

        switch(type) {
            case Types.INT:
                return "" + iteration;
            case Types.STRING:
                return getStringValue(iteration);
            case Types.CUSTOM:
                return obj.getThisToStringForIteration(iteration);
            case Types.SOME_CLASS:
                obj = new SomeClass(3, 3, 3, 3);
                return obj.getThisToStringForIteration(iteration);
            default:
                return "";
        }
    }
}

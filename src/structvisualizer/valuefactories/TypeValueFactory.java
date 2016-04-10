package structvisualizer.valuefactories;

import structvisualizer.data.Types;
import structvisualizer.valuefactories.TooltipValueFactory;

import java.util.Random;

/**
 * Factory for values in output TextArea and in StackPane (animation) which returns value of the right type
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class TypeValueFactory {

    /**
     * @param type
     * @param iteration
     *
     * @return
     */
    public static String get(String type, int iteration, boolean rand) {

        if(rand) {
            Random random = new Random();
            iteration = random.nextInt();
        }

        switch (type) {
            case Types.INT:
                return "" + iteration;
            case Types.STRING:
                return TooltipValueFactory.getStringValue(iteration);
            case Types.SOME_CLASS:
                StringBuilder scRes = new StringBuilder("obj").append(iteration);
                return scRes.toString();
            case Types.CUSTOM:
                StringBuilder cRes = new StringBuilder("obj").append(iteration);
                return cRes.toString();
            default:
                return "";
        }

    }
}

package parser;

 /*
 * SomeClass   3/22/16, 17:52
 *
 * By Kyrylo Havrylenko
 *
 */

import structvisualizer.data.Types;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class SomeClass {
    private static final Logger logger = Logger.getLogger(SomeClass.class.getName());
    public Integer[] intFields;
    public Double[] doubleFields;
    public String[] stringFields;
    public Character[] charFields;

    public SomeClass(int ints, int doubles, int strings, int chars) {
        this(ints, doubles, strings, chars, "a");
        logger.log(Level.FINE, "Args:\tint " + ints + " double" + doubles + " String" + strings + " char" + chars);
    }

    public SomeClass(int ints, int doubles, int strings, int chars, String inp) {
        logger.log(Level.FINE, "New SomeClass object");
        if(ints > 0) {
            logger.log(Level.FINER, "Number of ints in object: " + ints);
            intFields = new Integer[ints];
            for(int i = 0; i < intFields.length; i++) {
                intFields[i] = i + 1;
            }
        }
        if(doubles > 0) {
            logger.log(Level.FINER, "Number of doubles in object: " + doubles);
            doubleFields = new Double[doubles];
            for(int i = 0; i < doubleFields.length; i++) {
                doubleFields[i] = 0.0 + i + 1;
            }
        }
        if(strings > 0) {
            logger.log(Level.FINER, "Number of strings in object: " + strings);
            stringFields = new String[strings];
            Arrays.fill(stringFields, inp);
            int str = 1;
            for(int i = 0; i < stringFields.length; i++) {
                for(int j = 0; j < i; j++) {
                    stringFields[i] += str;
                    str++;
                }
            }
            logger.log(Level.FINER, "First strings: " + stringFields[0] + ", " + stringFields[1]);

        }
        if(chars > 0) {
            logger.log(Level.FINER, "Number of chars in object: " + chars);
            charFields = new Character[chars];
            char ch = 'a';
            for(int i = 0; i < charFields.length; i++) {
                charFields[i] = ch;
                ch++;
            }
        }
    }

    private SomeClass(SomeClass obj, int iteration) {
        logger.log(Level.FINE, "New SomeClass with iteration: " + iteration);
        this.intFields = obj.intFields;
        this.doubleFields = obj.doubleFields;
        this.charFields = obj.charFields;
        this.stringFields = obj.stringFields;

        if(intFields != null) {
            for(Integer i : this.intFields) {
                i = i + iteration;
            }
        }
        if(doubleFields != null) {
            for(Double d : this.doubleFields) {
                d = d + iteration;
            }
        }
        if(charFields != null) {
            for(char c : charFields) {
                for(int i = 0; i < iteration; i++) {
                    c++;
                }
            }
        }
        if(stringFields != null) {
            for(String s : stringFields) {
                for(int i = 0; i < iteration; i++) {
                    s += s;
                }
            }
        }
    }

    public SomeClass(int[] args) {
        this(args[0], args[1], args[2], args[3]);
        logger.log(Level.FINE, "New SomeClass obj via int[] args: " + this);
    }

    public String getThisToStringForIteration(int index) {
        SomeClass tmp = new SomeClass(this, index);
        logger.log(Level.FINE, "Get toString for iteration" + index + "in " + this);
        return tmp.toString();
    }

    private String iterateForToString(Object[] arr, String type) {
        StringBuilder sb = new StringBuilder();
        logger.log(Level.FINE, "Iterating SomeClass strings");
        for(int i = 0; i < arr.length; i++) {
            sb.append("\t").append(type).append(" : ").append(arr[i]).append("\n");
        }
        logger.log(Level.FINE, "Iterated string: " + sb.toString());
        return sb.toString();
    }

    @Override
    public String toString() {
        logger.log(Level.FINE, "Called SomeClass toString " + this);
        StringBuilder sb = new StringBuilder();
        if(intFields != null) {
            sb.append("Int fields:\n").append(iterateForToString(intFields, Types.INT));
        }
        if(doubleFields != null) {
            sb.append("Double fields:\n").append(iterateForToString(doubleFields, Types.DOUBLE));
        }
        if(stringFields != null) {
            sb.append("String fields:\n").append(iterateForToString(stringFields, Types.STRING));
        }
        if(charFields != null) {
            sb.append("Char fields:\n").append(iterateForToString(charFields, Types.CHAR));
        }
        return sb.toString();
    }
}

package test.parser;

import org.junit.Assert;
import org.junit.Test;
import parser.SomeClass;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;


 /*
 * SomeClassTest   4/3/16, 23:32
 *
 * By Kyrylo Havrylenko
 *
 */

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class SomeClassTest {

    private static final Logger logger = Logger.getLogger(SomeClassTest.class.getName());

    @Test
    public void incrementDoubleValues() {
        SomeClass sc = new SomeClass(2, 2, 2, 2);
        Double[] actuals = { 1.0, 2.0 };
        Assert.assertArrayEquals(sc.doubleFields, actuals);
    }

    @Test
    public void stringShouldBeInputPlusIncrementValue() {
        String inp = "string";
        SomeClass sc = new SomeClass(0, 0, 2, 0, inp);

        String[] strings = { inp, inp + 1 };
        logger.log(Level.FINE, sc.stringFields[0] + ", " + sc.stringFields[1]);

        Assert.assertArrayEquals(sc.stringFields, strings);
    }
}
package parser.Tests;

import org.junit.*;
import parser.SomeClass;

import static org.junit.Assert.assertEquals;

 /*
 * TestSomeClass   3/25/16, 18:17
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
public class TestSomeClass {

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
        System.out.println(sc.stringFields[0] + ", " + sc.stringFields[1]); // // TODO: 3/25/16 log

        Assert.assertArrayEquals(sc.stringFields, strings);
    }


}

package test.structvisualizer.valuefactories;

import org.junit.Assert;
import org.junit.Test;
import structvisualizer.valuefactories.TooltipValueFactory;

import static org.junit.Assert.*;


 /*
 * TooltipValueFactoryTest   4/3/16, 23:33
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
public class TooltipValueFactoryTest {
    @Test
    public void getStringValueShouldReturn() {
        Character c = 'a';
        Assert.assertEquals(TooltipValueFactory.getStringValue(0), c.toString());
        c++;
        String actual = "" + c + c;
        Assert.assertEquals(TooltipValueFactory.getStringValue(1), actual);
    }

}
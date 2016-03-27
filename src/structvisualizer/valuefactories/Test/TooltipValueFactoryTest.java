package structvisualizer.valuefactories.Test;

 /*
 * TooltipValueFactoryTest   3/25/16, 19:00
 *
 * By Kyrylo Havrylenko
 *
 */

import org.junit.Assert;
import org.junit.Test;
import structvisualizer.valuefactories.TooltipValueFactory;

/**
 * Tests for TooltipValueFactory
 *
 * @author Kyrylo Havrylenko
 * @see TooltipValueFactory
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

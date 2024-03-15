package ai;

import org.junit.Assert;
import org.junit.Test;
import static ai.Fibonachi.fibonachi;

public class TestFibonachi {


    @Test
    public void testFibonachi() {

        Assert.assertEquals(0, fibonachi(0));
        Assert.assertEquals(1, fibonachi(1));
        Assert.assertEquals(1, fibonachi(2));
        Assert.assertEquals(13, fibonachi(7));
        Assert.assertEquals(4181, fibonachi(19));
        Assert.assertEquals(267914296, fibonachi(42));
        Assert.assertEquals(806515533049393L, fibonachi(73));


    }


}
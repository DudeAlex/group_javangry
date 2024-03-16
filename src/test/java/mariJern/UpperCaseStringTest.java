package mariJern;

import org.junit.Assert;
import org.junit.Test;

import static Utils.CustomStringFormat.getUpperCaseString;
import static mariJern.Main.happy;

public class UpperCaseStringTest {

    @Test
    public void test() {


        Assert.assertEquals("""
                IN EVERY LIFE WE HAVE SOME TROUBLE
                BUT WHEN YOU WORRY YOU MAKE IT DOUBLE
                DON'T WORRY
                BE HAPPY =)""", getUpperCaseString(happy));


    }
}


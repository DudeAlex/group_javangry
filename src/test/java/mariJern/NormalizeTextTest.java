package mariJern;

import org.junit.Assert;
import org.junit.Test;

import static mariJern.Main.normalizeText;

public class NormalizeTextTest {

    @Test
    public void test() {
        Assert.assertEquals("Martins Engelis", normalizeText("Mārtiņš Eņģelis"));
    }
}

package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LAB006 {
    @Test
    public void testCase1(){
        Assert.assertEquals(true, true);
    }

    @Test
    public void testCase2(){
        Assert.assertEquals(false, true);
    }
}

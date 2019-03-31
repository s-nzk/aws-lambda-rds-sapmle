package com.nzk;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


/**
 * Unit test for simple App.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({ System.class })
public class AppTest {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    @org.junit.Test
    public void testApp() {
        App app = new App();
        Response reponse = app.handleRequest(new Request(), null);
        Assert.assertEquals(reponse.body, "OOOKKK");

    }
}

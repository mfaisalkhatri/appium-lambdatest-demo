package io.github.mfaisalkhatri.proverbialapp.ios.tests;

import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.proverbialapp.ios.pages.realdevice.HomePage;
import org.testng.annotations.Test;

public class IOSRealDeviceTests extends BaseTestRealDevice {

    @Test
    public void testTextOnHomePage() {
        HomePage homePage = new HomePage (iosDriver);
        assertEquals (homePage.getText (), "Hello! Welcome to lambdatest Sample App called Proverbial");
        homePage.tapOnTextBtn ();
        assertEquals (homePage.getText (), "Proverbial");
        this.status = "passed";
    }
}

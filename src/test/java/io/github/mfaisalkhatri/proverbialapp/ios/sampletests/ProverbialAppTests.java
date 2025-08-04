package io.github.mfaisalkhatri.proverbialapp.ios.sampletests;

import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.proverbialapp.ios.pages.realdevice.HomePage;
import org.testng.annotations.Test;

public class ProverbialAppTests extends BaseTest {
    @Test
    public void testTextOnHomePage () {
        final HomePage homePage = new HomePage (this.iosDriver);
        assertEquals (homePage.getText (), "Hello! Welcome to lambdatest Sample App called Proverbial");
        homePage.tapOnTextBtn ();
        assertEquals (homePage.getText (), "Proverbial");
        this.status = "passed";
    }
}
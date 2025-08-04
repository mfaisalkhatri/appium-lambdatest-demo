package io.github.mfaisalkhatri.proverbialapp.ios.tests;

import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.proverbialapp.ios.pages.simulator.HomePage;
import org.testng.annotations.Test;

public class IOSSimulatorTests extends BaseTestSimulator {

    @Test
    public void testTextOnHomePage () {
        final HomePage homePage = new HomePage (this.iosDriver);
        assertEquals (homePage.getText (), "Hello! Welcome to lambdatest Sample App called Proverbial");
        homePage.tapOnTextBtn ();
        assertEquals (homePage.getText (), "Proverbial");
    }
}
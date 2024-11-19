package io.github.mfaisalkhatri.proverbialapp.ios.tests;

import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.proverbialapp.ios.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IOSRealDeviceTests extends BaseTestRealDevice {

    private HomePage homePage;

    @BeforeClass
    public void setupTest() {
        this.homePage = new HomePage(iosDriver);
    }

    @Test
    public void testTextOnHomePage() {
        assertEquals(this.homePage.getText(), "Hello! Welcome to lambdatest Sample App called Proverbial");
        this.homePage.tapOnTextBtn();
        assertEquals(this.homePage.getText(), "Proverbial");
        this.status = "passed";
    }
}

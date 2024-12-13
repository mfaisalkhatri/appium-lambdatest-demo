package io.github.mfaisalkhatri.proverbialapp.android.sampletests.tests;

import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.proverbialapp.android.sampletests.pages.HomePage;
import org.testng.annotations.Test;

public class ProverbialAppTests extends BaseTest {

    @Test
    public void testTextOnHomePage () {
        final HomePage homePage = new HomePage (this.androidDriver);
        assertEquals (homePage.getText (), "Hello! Welcome to lambdatest Sample App called Proverbial");
        homePage.tapOnTextBtn ();
        assertEquals (homePage.getText (), "Proverbial");
        this.status = "passed";
    }

}

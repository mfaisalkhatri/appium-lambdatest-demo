package io.github.mfaisalkhatri.proverbialapp.android.sampletests.tests;

import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.proverbialapp.android.sampletests.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

public class ProverbialAppTests extends BaseTest {

    @Description ("Check that the text on Home page changes on clicking Text Button")
    @Test
    @Tag ("Android")
    public void testTextOnHomePage () {
        verifyHomePageTextOnAppLoad ();
        verifyTextChangeOnTappingTextButton ();
        this.status = "passed";
    }

    @Step ("Checking the Home page text when the app loads")
    public void verifyHomePageTextOnAppLoad () {
        final HomePage homePage = new HomePage (this.androidDriver);
        assertEquals (homePage.getText (), "Hello! Welcome to lambdatest Sample App called Proverbial");
    }

    @Step ("Checking the text after tapping on Text button")
    public void verifyTextChangeOnTappingTextButton () {
        final HomePage homePage = new HomePage (this.androidDriver);
        homePage.tapOnTextBtn ();
        assertEquals (homePage.getText (), "Proverbial");
    }
}
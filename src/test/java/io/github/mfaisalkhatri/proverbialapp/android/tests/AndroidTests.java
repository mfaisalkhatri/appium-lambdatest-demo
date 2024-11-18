package io.github.mfaisalkhatri.proverbialapp.android.tests;

import io.github.mfaisalkhatri.proverbialapp.android.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AndroidTests extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void setupTest() {
        this.homePage = new HomePage(this.androidDriverManager);
    }

    @Test
    public void textTests() {
        assertEquals(this.homePage.getText(), "Hello! Welcome to lambdatest Sample App called Proverbial");
        this.homePage.tapOnTextBtn();
        assertEquals(this.homePage.getText(), "Proverbial");
    }

    @Test
    public void notificationTest() {
        this.homePage.tapOnNotificationBtn();
        assertTrue(this.homePage.notificationBar().isDisplayed());
        this.homePage.notificationBar().click();
    }

    @Test
    public void toastMessageTest() {
        this.homePage.tapOnToastBtn();
        assertEquals(this.homePage.toastMessage(), "Toast should be visible");
    }
}

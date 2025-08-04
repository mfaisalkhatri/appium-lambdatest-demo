package io.github.mfaisalkhatri.proverbialapp.android.sampletests.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final AndroidDriver androidDriver;

    public HomePage (final AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public String getText () {
        return this.androidDriver.findElement (AppiumBy.id ("Textbox"))
            .getText ();
    }

    public void tapOnTextBtn () {
        textBtn ().click ();
    }

    private WebElement textBtn () {
        return this.androidDriver.findElement (AppiumBy.id ("Text"));
    }
}
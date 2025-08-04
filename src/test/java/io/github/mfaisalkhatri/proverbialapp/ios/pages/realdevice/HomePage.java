package io.github.mfaisalkhatri.proverbialapp.ios.pages.realdevice;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final IOSDriver iosDriver;

    public HomePage (final IOSDriver iosDriver) {
        this.iosDriver = iosDriver;
    }

    public String getText () {
        return this.iosDriver.findElement (AppiumBy.accessibilityId ("Textbox"))
            .getText ();
    }

    public void tapOnTextBtn () {
        textBtn ().click ();
    }

    private WebElement textBtn () {
        return this.iosDriver.findElement (AppiumBy.iOSClassChain ("**/XCUIElementTypeButton[`name == 'Text'`]"));
    }
}
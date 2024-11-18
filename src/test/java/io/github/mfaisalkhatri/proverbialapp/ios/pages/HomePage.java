package io.github.mfaisalkhatri.proverbialapp.ios.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private IOSDriver iosDriver;

    public HomePage (IOSDriver iosDriver) {
        this.iosDriver = iosDriver;
    }

    private WebElement textBtn () {
        return iosDriver.findElement (AppiumBy.iOSClassChain ("**/XCUIElementTypeButton[`name == 'Text'`]"));
    }

    public void tapOnTextBtn () {
        textBtn ().click ();
    }

    public String getText () {
        return iosDriver.findElement (AppiumBy.accessibilityId ("Textbox"))
            .getText ();
    }

}

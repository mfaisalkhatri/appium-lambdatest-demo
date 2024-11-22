package io.github.mfaisalkhatri.proverbialapp.android.pages;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    AndroidDriverManager androidDriverManager;
    WebDriverWait wait;

    public HomePage(final AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
        wait = new WebDriverWait(androidDriverManager.getAndroidDriver(), Duration.ofSeconds(20));
    }

    private WebElement textBtn() {
        return androidDriverManager.getAndroidDriver()
                .findElement(AppiumBy.id("Text"));
    }

    public void tapOnTextBtn() {
        textBtn().click();
    }

    public String getText() {
        return androidDriverManager.getAndroidDriver()
                .findElement(AppiumBy.id("Textbox"))
                .getText();
    }

    private WebElement notificationBtn() {
        return androidDriverManager.getAndroidDriver()
                .findElement(AppiumBy.id("notification"));
    }

    public void tapOnNotificationBtn() {
        notificationBtn().click();
    }

    public WebElement notificationBar() {
        return androidDriverManager.getAndroidDriver()
                .findElement(AppiumBy.id("action_bar"));
    }

    private WebElement toastBtn() {
        return androidDriverManager.getAndroidDriver()
                .findElement(AppiumBy.id("toast"));
    }

    public void tapOnToastBtn() {
        toastBtn().click();
    }

    public String toastMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Toast[1]")))
                .getText();
    }


}

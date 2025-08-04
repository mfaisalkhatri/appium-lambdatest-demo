package io.github.mfaisalkhatri.proverbialapp.android.pages;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    AndroidDriverManager androidDriverManager;
    WebDriverWait        wait;

    public HomePage (final AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
        this.wait = new WebDriverWait (androidDriverManager.getAndroidDriver (), Duration.ofSeconds (20));
    }

    public String getText () {
        return this.androidDriverManager.getAndroidDriver ()
            .findElement (AppiumBy.id ("Textbox"))
            .getText ();
    }

    public WebElement notificationBar () {
        return this.androidDriverManager.getAndroidDriver ()
            .findElement (AppiumBy.id ("action_bar"));
    }

    public void tapOnNotificationBtn () {
        notificationBtn ().click ();
    }

    public void tapOnTextBtn () {
        textBtn ().click ();
    }

    public void tapOnToastBtn () {
        toastBtn ().click ();
    }

    public String toastMessage () {
        return this.wait.until (
                ExpectedConditions.presenceOfElementLocated (AppiumBy.xpath ("//android.widget.Toast[1]")))
            .getText ();
    }

    private WebElement notificationBtn () {
        return this.androidDriverManager.getAndroidDriver ()
            .findElement (AppiumBy.id ("notification"));
    }

    private WebElement textBtn () {
        return this.androidDriverManager.getAndroidDriver ()
            .findElement (AppiumBy.id ("Text"));
    }

    private WebElement toastBtn () {
        return this.androidDriverManager.getAndroidDriver ()
            .findElement (AppiumBy.id ("toast"));
    }
}
package io.github.mfaisalkhatri.proverbialapp.android.sampletests.tests;

import static java.text.MessageFormat.format;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private static final String        GRID_URL      = "@mobile-hub.lambdatest.com/wd/hub";
    private static final String        LT_ACCESS_KEY = System.getenv ("LT_ACCESS_KEY");
    private static final String        LT_USERNAME   = System.getenv ("LT_USERNAME");
    protected            AndroidDriver androidDriver;
    protected            String        status        = "failed";

    @BeforeClass (alwaysRun = true)
    public void setupTest () {
        try {
            this.androidDriver = new AndroidDriver (
                new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_KEY, GRID_URL)), uiAutomator2Options ());
            setupBrowserTimeouts ();

        } catch (final MalformedURLException e) {
            throw new Error ("Error while creating Android Driver Session on LambdaTest cloud grid");
        }
    }

    @AfterClass (alwaysRun = true)
    public void tearDown () {
        this.androidDriver.executeScript ("lambda-status=" + this.status);
        this.androidDriver.quit ();
    }

    private HashMap<String, Object> ltOptions () {
        final var ltOptions = new HashMap<String, Object> ();
        ltOptions.put ("platformName", "android");
        ltOptions.put ("deviceName", "Galaxy S24 Ultra");
        ltOptions.put ("platformVersion", "14");
        ltOptions.put ("app", "lt://APP10160571441732309641425926");
        ltOptions.put ("build", "Proverbial Android App");
        ltOptions.put ("name", "Proverbial Android HomePage test");
        ltOptions.put ("w3c", true);
        ltOptions.put ("isRealMobile", true);
        ltOptions.put ("autoGrantPermissions", true);
        ltOptions.put ("autoAcceptAlerts", true);
        ltOptions.put ("plugin", "java-testNG");
        ltOptions.put ("visual", true);
        ltOptions.put ("console", true);
        ltOptions.put ("devicelog", true);
        return ltOptions;
    }

    private void setupBrowserTimeouts () {
        this.androidDriver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (20));
    }

    private UiAutomator2Options uiAutomator2Options () {
        final UiAutomator2Options uiAutomator2Options = new UiAutomator2Options ();
        uiAutomator2Options.setCapability ("lt:options", ltOptions ());
        return uiAutomator2Options;
    }

}

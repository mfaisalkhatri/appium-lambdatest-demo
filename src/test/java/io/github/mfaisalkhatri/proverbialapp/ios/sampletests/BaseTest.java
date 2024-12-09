package io.github.mfaisalkhatri.proverbialapp.ios.sampletests;

import static java.text.MessageFormat.format;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private static final String    GRID_URL      = "@mobile-hub.lambdatest.com/wd/hub";
    private static final String    LT_ACCESS_KEY = System.getenv ("LT_ACCESS_KEY");
    private static final String    LT_USERNAME   = System.getenv ("LT_USERNAME");
    protected            IOSDriver iosDriver;
    protected            String    status        = "failed";

    @BeforeClass (alwaysRun = true)
    public void setupTest () {
        try {
            this.iosDriver = new IOSDriver (
                new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_KEY, GRID_URL)), xcuiTestOptions ());
            setupBrowserTimeouts ();

        } catch (final MalformedURLException e) {
            throw new Error ("Error while creating IOS Driver Session on LambdaTest cloud grid");
        }
    }

    @AfterClass (alwaysRun = true)
    public void tearDown () {
        this.iosDriver.executeScript ("lambda-status=" + this.status);
        this.iosDriver.quit ();
    }

    private HashMap<String, Object> ltOptions () {
        final var ltOptions = new HashMap<String, Object> ();
        ltOptions.put ("platformName", "ios");
        ltOptions.put ("deviceName", "iPhone 16 Pro");
        ltOptions.put ("platformVersion", "18");
        ltOptions.put ("app", "lt://APP10160351951731874234459103");
        ltOptions.put ("build", "Provervial ios app");
        ltOptions.put ("name", "Proverbial ios HomePage test");
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
        this.iosDriver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (20));
    }

    private XCUITestOptions xcuiTestOptions () {
        final XCUITestOptions xcuiTestOptions = new XCUITestOptions ();
        xcuiTestOptions.setCapability ("lt:options", ltOptions ());
        return xcuiTestOptions;
    }
}

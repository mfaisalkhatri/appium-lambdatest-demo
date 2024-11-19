package io.github.mfaisalkhatri.proverbialapp.ios.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTestSimulator {

    protected IOSDriver iosDriver;

    @BeforeClass (alwaysRun = true)
    public void setupTest () {
        try {
            this.iosDriver = new IOSDriver (new URL ("http://127.0.0.1:4723/"), xcuiTestOptions ());
            setupBrowserTimeouts ();

        } catch (MalformedURLException e) {
            throw new Error ("Error while creating IOS Driver Session");
        }
    }

    private static XCUITestOptions xcuiTestOptions () {
        final String appPath = String.valueOf (
            Path.of (System.getProperty ("user.dir"), "/src/test/resources/ios_app", "Proverbial-Simulator.zip"));
        return new XCUITestOptions ().setDeviceName ("iPhone 16 Pro")
            .setAutomationName (AutomationName.IOS_XCUI_TEST)
            .setNewCommandTimeout (Duration.ofSeconds (60))
            .setPlatformVersion ("18.1")
            .setApp (appPath)
            .autoAcceptAlerts ()
            .setNoReset (false);
    }

    private void setupBrowserTimeouts () {
        this.iosDriver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (20));
    }

    @AfterClass (alwaysRun = true)
    public void tearDown () throws IOException {
        this.iosDriver.quit ();
    }
}

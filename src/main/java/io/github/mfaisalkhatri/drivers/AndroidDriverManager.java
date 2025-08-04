package io.github.mfaisalkhatri.drivers;

import static java.text.MessageFormat.format;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import io.appium.java_client.android.AndroidDriver;
import lombok.Builder;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

@Builder
public class AndroidDriverManager {

    private static final ThreadLocal<AndroidDriver> DRIVER        = new ThreadLocal<> ();
    private static final String                     GRID_URL      = "@mobile-hub.lambdatest.com/wd/hub";
    private static final String                     LT_ACCESS_KEY = System.getenv ("LT_ACCESS_KEY");
    private static final String                     LT_USERNAME   = System.getenv ("LT_USERNAME");
    private              String                     app;
    private              String                     buildName;
    private              String                     deviceName;
    private              Platform                   platform;
    private              String                     platformVersion;
    private              String                     testName;

    public AndroidDriverManager createAndroidDriver () {
        try {
            setDriver (new AndroidDriver (new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_KEY, GRID_URL)),
                setCapabilities ()));
            setupBrowserTimeouts ();

        } catch (final MalformedURLException e) {
            throw new Error ("Error while creating Android Driver Session");
        }
        return this;
    }

    public AndroidDriver getAndroidDriver () {
        return AndroidDriverManager.DRIVER.get ();
    }

    public void quitDriver () {
        if (null != DRIVER.get ()) {
            getAndroidDriver ().quit ();
            DRIVER.remove ();
        }
    }

    private HashMap<String, Object> ltOptions () {
        final var ltOptions = new HashMap<String, Object> ();
        ltOptions.put ("username", LT_USERNAME);
        ltOptions.put ("accessKey", LT_ACCESS_KEY);
        ltOptions.put ("platformName", this.platform);
        ltOptions.put ("deviceName", this.deviceName);
        ltOptions.put ("platformVersion", this.platformVersion);
        ltOptions.put ("app", this.app);
        ltOptions.put ("build", this.buildName);
        ltOptions.put ("name", this.testName);
        ltOptions.put ("w3c", true);
        ltOptions.put ("isRealMobile", true);
        ltOptions.put ("autoGrantPermissions", true);
        ltOptions.put ("plugin", "java-testNG");
        ltOptions.put ("visual", true);
        ltOptions.put ("console", true);
        ltOptions.put ("devicelog", true);
        return ltOptions;
    }

    private DesiredCapabilities setCapabilities () {
        final DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability ("lt:options", ltOptions ());
        return capabilities;
    }

    private void setDriver (final AndroidDriver driver) {
        AndroidDriverManager.DRIVER.set (driver);
    }

    private void setupBrowserTimeouts () {
        getAndroidDriver ().manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (20));
    }
}
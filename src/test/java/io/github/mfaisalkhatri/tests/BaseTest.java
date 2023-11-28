package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.Platform;
import org.testng.annotations.*;

public class BaseTest {

    protected AndroidDriverManager androidDriverManager;

    @Parameters({"buildName", "testName", "app", "platformName", "version", "device"})
    @BeforeClass(alwaysRun = true)
    public void setupTest(final String buildName, final String testName, @Optional("app") final String app, final Platform platform, final String platformVersion,
                          final String deviceName) {
        this.androidDriverManager = AndroidDriverManager.builder()
                .buildName(buildName)
                .testName(testName)
                .app(app)
                .platform(platform)
                .platformVersion(platformVersion)
                .deviceName(deviceName)
                .build()
                .createAndroidDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        this.androidDriverManager.quitDriver();
    }
}

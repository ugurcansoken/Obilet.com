package com.testinium;

import com.testinium.selector.Selector;
import com.testinium.selector.SelectorFactory;
import com.testinium.selector.SelectorType;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterStep;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HookImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static FluentWait<AppiumDriver> appiumFluentWait;
    public static boolean localAndroid = true;
    protected static Selector selector;
    DesiredCapabilities capabilities;
    URL localUrl;
    URL hubUrl;


    @BeforeScenario
    public void beforeScenario(ExecutionContext executionContext) {
        try {
            logger.info("************************************  BeforeScenario  ************************************");
            logger.info("SCENARIO NAME: " + executionContext.getCurrentScenario().getName());
            logger.info(executionContext.getAllTags().toString());

            localUrl = new URL("http://127.0.0.1:4723/wd/hub");
            hubUrl = new URL("http://hub.testinium.io/wd/hub");

            if (StringUtils.isEmpty(System.getenv("key"))) {
                if (localAndroid) {
                    logger.info("Local cihazda Android ortamında test ayağa kalkacak");
                    appiumDriver = new AndroidDriver(localUrl, androidCapabilities(true));
                } else {
                    logger.info("Local cihazda Android ortamında test ayağa kalkacak");
                    appiumDriver = new IOSDriver<>(localUrl, iosCapabilities(true));
                }
            } else {
                if (System.getenv("platform").equals("ANDROID")) {
                    logger.info("Testiniumda Android ortamında test ayağa kalkacak");
                    appiumDriver = new AndroidDriver(hubUrl, androidCapabilities(false));

                    localAndroid = true;
                } else {

                    logger.info("Testiniumda IOS ortamında test ayağa kalkacak");
                    appiumDriver = new IOSDriver(hubUrl, iosCapabilities(false));
                    localAndroid = false;
                }
            }
            selector = SelectorFactory
                    .createElementHelper(localAndroid ? SelectorType.ANDROID : SelectorType.IOS);

            appiumFluentWait = new FluentWait(appiumDriver);
            appiumFluentWait.withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(250))
                    .ignoring(NoSuchElementException.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public DesiredCapabilities androidCapabilities(boolean isLocal) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("unicodeKeyboard", false);
        capabilities.setCapability("resetKeyboard", false);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");


        if (isLocal) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        } else {
            //capabilities.setCapability("key", System.getenv("key"));
            capabilities.setCapability("testinium:takesScreenshot", true);
            capabilities.setCapability("testinium:recordsVideo", true);
            capabilities.setCapability("testinium:key", "mehmetaksahin:66e85f66c902b99253229b608203e5e2");
            capabilities.setCapability("testinium:testID", System.getenv("testID"));
        }
        return capabilities;
    }


    public DesiredCapabilities iosCapabilities(boolean islocal) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities
                .setCapability("bundleId", "com.ozdilek.ozdilekteyim");
        if (!islocal) {
            capabilities.setCapability("key", System.getenv("key"));
            capabilities.setCapability("waitForAppScript", "$.delay(1000);");
            capabilities.setCapability("usePrebuiltWDA", true);
            capabilities.setCapability("useNewWDA", true);
        } else {
            capabilities
                    .setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.IOS);
            capabilities
                    .setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

            capabilities.setCapability(MobileCapabilityType.UDID, "1e5cdbbadc4a7dc3e4389298330bad5c587904d5");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone SE");

            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.5");

            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
            capabilities.setCapability("sendKeyStrategy", "setValue");
        }

        return capabilities;

    }

    @AfterScenario
    public void afterScenario() {

        if (appiumDriver != null) {
            appiumDriver.quit();
        }

        logger.info("*************************************************************************" + "\r\n");
    }

    @AfterStep
    public void afterStep(ExecutionContext executionContext) {

        if (executionContext.getCurrentStep().getIsFailing()) {
            logger.info(executionContext.getCurrentStep().getErrorMessage());
            logger.info(executionContext.getCurrentStep().getStackTrace());
        }
    }


}

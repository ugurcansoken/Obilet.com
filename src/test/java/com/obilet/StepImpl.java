package com.obilet;

import com.obilet.helper.RandomString;
import com.obilet.helper.StoreHelper;
import com.obilet.model.SelectorInfo;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

public class StepImpl extends HookImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private  List<Integer> integerList=new ArrayList<>();
    private  List<String> stringList=new ArrayList<>();
    private static HashMap<String, String> userVariableHashMap = new HashMap<>();
    private static String kaydedilmisNumara;


    public StepImpl() {

    }


    public List<MobileElement> findElements(By by) throws Exception {
        List<MobileElement> webElementList = null;
        try {
            webElementList = appiumFluentWait.until(new ExpectedCondition<List<MobileElement>>() {
                @Nullable
                @Override
                public List<MobileElement> apply(@Nullable WebDriver driver) {
                    List<MobileElement> elements = driver.findElements(by);
                    return elements.size() > 0 ? elements : null;
                }
            });
            if (webElementList == null) {
                throw new NullPointerException(String.format("by = %s Web element list not found", by.toString()));
            }
        } catch (Exception e) {
            throw e;
        }
        return webElementList;
    }

    public List<MobileElement> findElementsWithoutAssert(By by) {

        List<MobileElement> mobileElements = null;
        try {
            mobileElements = findElements(by);
        } catch (Exception e) {
        }
        return mobileElements;
    }

    public List<MobileElement> findElementsWithAssert(By by) {

        List<MobileElement> mobileElements = null;
        try {
            mobileElements = findElements(by);
        } catch (Exception e) {
            Assertions.fail("by = %s Elements not found ", by.toString());
            e.printStackTrace();
        }
        return mobileElements;
    }


    public MobileElement findElement(By by) throws Exception {
        MobileElement mobileElement;
        try {
            mobileElement = findElements(by).get(0);
        } catch (Exception e) {
            throw e;
        }
        return mobileElement;
    }

    public MobileElement findElementWithoutAssert(By by) {
        MobileElement mobileElement = null;
        try {
            mobileElement = findElement(by);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobileElement;
    }

    public MobileElement findElementWithAssertion(By by) {
        MobileElement mobileElement = null;
        try {
            mobileElement = findElement(by);
        } catch (Exception e) {
            Assertions.fail(mobileElement.getAttribute("value") + " " + "by = %s Element not found ", by.toString());
            e.printStackTrace();
        }
        return mobileElement;
    }

    public MobileElement findElementByKeyWithoutAssert(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        MobileElement mobileElement = null;
        try {
            mobileElement = selectorInfo.getIndex() > 0 ? findElements(selectorInfo.getBy())
                    .get(selectorInfo.getIndex()) : findElement(selectorInfo.getBy());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobileElement;
    }

    public MobileElement findElementByKey(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);

        MobileElement mobileElement = null;
        try {
            mobileElement = selectorInfo.getIndex() > 0 ? findElements(selectorInfo.getBy())
                    .get(selectorInfo.getIndex()) : findElement(selectorInfo.getBy());
        } catch (Exception e) {
            Assertions.fail("key = %s by = %s Element not found ", key, selectorInfo.getBy().toString());
            e.printStackTrace();
        }
        return mobileElement;
    }


    public List<MobileElement> findElemenstByKeyWithoutAssert(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        List<MobileElement> mobileElements = null;
        try {
            mobileElements = findElements(selectorInfo.getBy());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobileElements;
    }

    public List<MobileElement> findElemenstByKey(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        List<MobileElement> mobileElements = null;
        try {
            mobileElements = findElements(selectorInfo.getBy());
        } catch (Exception e) {
            Assertions.fail("key = %s by = %s Elements not found ", key, selectorInfo.getBy().toString());
            e.printStackTrace();
        }
        return mobileElements;
    }

    @Step({"<str> elementine <str2> degerini gir", "<str> element write <str2> text"})
    public void sendK(String str, String str2) {
        findElementWithAssertion(By.id(str)).sendKeys(str2);
    }


    @Step({"Değeri <text> e eşit olan elementli bul ve tıkla",
            "Find element text equals <text> and click"})
    public void clickByText(String text) {
        findElementWithAssertion(By.xpath(".//*[contains(@text,'"+text+"')]")).click();
    }

    @Step({"İçeriği <value> e eşit olan elementli bul ve tıkla",
            "Find element value equals <value> and click"})
    public void clickByValue(String value) {
        findElementWithAssertion(MobileBy.xpath(".//*[contains(@value,'" + value + "')]")).click();
    }

    @Step({"Değeri <text> e eşit olan <index>. elementi bul ve tıkla"})
    public void clickByText(String text, int index) {
        findElementWithAssertion(By.xpath("(.//*[contains(@text,'" + text + "')])[" + index + "]")).click();
    }

    @Step({"İçeriği <value> e eşit olan <index>. elementi bul ve tıkla"})
    public void clickByValue(String value, int index) {
        findElementWithAssertion(MobileBy.xpath("(.//*[contains(@value,'" + value + "')])[" + index + "]")).click();
    }

    @Step("<key> elementinin <index> .li elementi bul ve tıkla")
    public void clickByKeyIndex(String key, int index) {
        findElementsWithoutAssert(selector.getSelectorInfo(key).getBy()).get(index).click();
    }


    @Step({"Elementine tıkla <key>", "Click element by <key>"})
    public void clickByKey(String key) {
        doesElementExistByKey(key, 5);
        findElementByKey(key).click();
        logger.info(key + " elementine tıkladı");
        System.out.println("-----------------------------------------------------------------");

    }

    @Step("<key> elementine tiklayamadigi dogrulanir")
    public void unableToClick(String key){
        MobileElement element = findElementByKey(key);
        if(!element.isDisplayed()){
            logger.info(key + " elementine tiklanamadigi dogrulandi");
        }
        else {

            fail(key + " elementine tiklanabiliyor");
        }
    }

    @Step({"<key> elementinin <value> attirbute degeri <check> iceriyor mu"})
    public void clickByKey(String key, String value, String check) {
        doesElementExistByKey(key, 5);
        logger.info(key + "elementinin " + value + " degeri:" + findElementByKey(key).getAttribute(value));
        System.out.println("-----------------------------------------------------------------");

        assertTrue(findElementByKey(key).getAttribute(value).contains(check), "Veriler Eşleşmiyor");
        System.out.println("-----------------------------------------------------------------");

    }

    @Step({"<key> elementinin görünürlüğü kontrol edilir"})
    public void existElement(String key) {
        assertTrue(findElementByKey(key).isDisplayed(), "Element sayfada bulunamadı !");
        logger.info(key + " elementi göründü");
        System.out.println("-----------------------------------------------------------------");

    }
    @Step("<key> elementinin olmadigi kontrol edilir")
    public void notExistElement(String key) {
        assertFalse(doesElementExistByKey(key,10), "Element mevcut !");
        logger.info("Elementin olmadığı doğrulandı");
    }

    @Step("<key> elementinin <text> textini içerdiği kontrol edilir")
    public void checkTextByKey(String key, String text) {
        try {
            Thread.sleep(3000);
            assertTrue(findElementByKey(key).getText().contains(text), "Element beklenen değeri taşımıyor !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step({"<key> li elementi bul ve varsa tıkla", "Click element by <key> if exist"})
    public void existClickByKey(String key) throws InterruptedException {
        MobileElement element;
        element = findElementByKeyWithoutAssert(key);
        if (element != null) {
            //System.out.println("  varsa tıklaya girdi");
            Point elementPoint = ((MobileElement) element).getCenter();
            TouchAction action = new TouchAction(appiumDriver);
            action.tap(PointOption.point(elementPoint.x, elementPoint.y)).perform();
            logger.info(key + " elementi bulundu");
            System.out.println("-----------------------------------------------------------------");

        }
        waitBySecond(2);
    }


    @Step({"<key> li elementi bul ve varsa dokun", "Click element by <key> if exist"})
    public void existTapByKey(String key) {
        if (findElementByKey(key).isDisplayed()) {
            findElementByKey(key).click();
        }
    }

    @Step({"sayfadaki <X> <Y>  alana dokun"})
    public void coordinateTap(int X, int Y) {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int width = dimension.width;
        int height = dimension.height;

        TouchAction action = new TouchAction(appiumDriver);
        action.tap(PointOption.point((width * X) / 100, (height * Y) / 100))
                .release().perform();

    }

    @Step({"<key> li elementi bul, temizle ve <text> değerini yaz",
            "Find element by <key> clear and send keys <text>"})
    public void sendKeysByKey(String key, String text) {
        MobileElement webElement = findElementByKey(key);
        webElement.clear();
        webElement.setValue(text);
    }
   @Step({"<key> li elementi bul ve temizle",
            "Find element by <key> clear"})
    public void clearKeysByKey(String key) {
        MobileElement webElement = findElementByKey(key);
        webElement.clear();
    }


    @Step({"<t> textini <k> elementine yaz",
            "Find element by <key> and send keys <text>"})
    public void sendKeysByKeyNotClear(String t, String k) {
        doesElementExistByKey(k, 5);
        findElementByKey(k).sendKeys(t);
        logger.info(t + " texti yazildi.");
        System.out.println("-----------------------------------------------------------------");


    }

    @Step({"<key> li elementi bul ve değerini <saveKey> olarak sakla",
            "Find element by <key> and save text <saveKey>"})
    public void saveTextByKey(String key, String saveKey) {
        StoreHelper.INSTANCE.saveValue(saveKey, findElementByKey(key).getText());
        logger.info("Video " + StoreHelper.INSTANCE.getValue(saveKey) + "saniyesinde durduruldu.");
    }

    @Step({"<key> li ve değeri <text> e eşit olan elementi bul ve tıkla",
            "Find element by <key> text equals <text> and click"})
    public void clickByIdWithContains(String key, String text) {
        List<MobileElement> elements = findElemenstByKey(key);
        for (MobileElement element : elements) {
            logger.info("Text !!!" + element.getText());
            if (element.getText().toLowerCase().contains(text.toLowerCase())) {
                element.click();
                break;
            }
        }
    }

    @Step({"<key> li ve değeri <text> e eşit olan elementli bulana kadar swipe et ve tıkla",
            "Find element by <key> text equals <text> swipe and click"})
    public void clickByKeyWithSwipe(String key, String text) throws InterruptedException {
        boolean find = false;
        int maxRetryCount = 10;
        while (!find && maxRetryCount > 0) {
            List<MobileElement> elements = findElemenstByKey(key);
            for (MobileElement element : elements) {
                if (element.getText().contains(text)) {
                    element.click();
                    find = true;
                    break;
                }
            }
            if (!find) {
                maxRetryCount--;
                if (appiumDriver instanceof AndroidDriver) {
                    swipeUpAccordingToPhoneSize();
                    waitBySecond(1);
                } else {
                    swipeDownAccordingToPhoneSize();
                    waitBySecond(1);
                }
            }
        }
    }

    @Step({"<key> li elementi bulana kadar swipe et ve tıkla",
            "Find element by <key>  swipe and click"})
    public void clickByKeyWithSwipe(String key) throws InterruptedException {
        int maxRetryCount = 10;
        while (maxRetryCount > 0) {
            List<MobileElement> elements = findElemenstByKey(key);
            if (elements.size() > 0) {
                if (elements.get(0).isDisplayed() == false) {
                    maxRetryCount--;
                    swipeDownAccordingToPhoneSize();
                    waitBySecond(1);

                } else {
                    elements.get(0).click();
                    logger.info(key + " elementine tıklandı");
                    System.out.println("-----------------------------------------------------------------");

                    break;
                }
            } else {
                maxRetryCount--;
                swipeDownAccordingToPhoneSize();
                waitBySecond(1);
            }

        }
    }


    private int getScreenWidth() {
        return appiumDriver.manage().window().getSize().width;
    }

    private int getScreenHeight() {
        return appiumDriver.manage().window().getSize().height;
    }

    private int getScreenWithRateToPercent(int percent) {
        return getScreenWidth() * percent / 100;
    }

    private int getScreenHeightRateToPercent(int percent) {
        return getScreenHeight() * percent / 100;
    }


    public void swipeDownAccordingToPhoneSize(int startXLocation, int startYLocation, int endXLocation, int endYLocation) {
        startXLocation = getScreenWithRateToPercent(startXLocation);
        startYLocation = getScreenHeightRateToPercent(startYLocation);
        endXLocation = getScreenWithRateToPercent(endXLocation);
        endYLocation = getScreenHeightRateToPercent(endYLocation);

        new TouchAction(appiumDriver)
                .press(PointOption.point(startXLocation, startYLocation))
                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(endXLocation, endYLocation))
                .release()
                .perform();
    }

    @Step({"<key> id'li elementi bulana kadar <times> swipe yap ",
            "Find element by <key>  <times> swipe "})
    public void swipeDownUntilSeeTheElement(String element, int limit) throws InterruptedException {
        for (int i = 0; i < limit; i++) {
            List<MobileElement> meList = findElementsWithoutAssert(By.id(element));
            meList = meList != null ? meList : new ArrayList<MobileElement>();
            logger.info(i + ". swipe yapiliyor");
            if (meList.size() > 0 &&
                    meList.get(0).getLocation().x <= getScreenWidth() &&
                    meList.get(0).getLocation().y <= getScreenHeight()) {
                break;
            } else {
                swipeDownAccordingToPhoneSize(50, 80, 50, 30);
                waitBySecond(1);

                break;
            }
        }
    }


    @Step({"<key> li elementi bulana kadar swipe et",
            "Find element by <key>  swipe "})
    public void findByKeyWithSwipe(String key) {

        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                if (findElementByKey(key) != null) {
                    swipeDownAccordingToPhoneSize();
                } else {
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void justSwipe() {
        TouchAction action = new TouchAction(appiumDriver);
        action.press(PointOption.point(500, 2000)).moveTo(PointOption.point(500, 500)).release().perform();
    }


    @Step("<yon> yönüne swipe et")
    public void swipe(String yon) {

        Dimension d = appiumDriver.manage().window().getSize();
        int height = d.height;
        int width = d.width;

        if (yon.equals("SAĞ")) {

            int swipeStartWidth = (width * 80) / 100;
            int swipeEndWidth = (width * 30) / 100;

            int swipeStartHeight = height / 2;
            int swipeEndHeight = height / 2;

            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();
        } else if (yon.equals("SOL")) {

            int swipeStartWidth = (width * 30) / 100;
            int swipeEndWidth = (width * 80) / 100;

            int swipeStartHeight = height / 2;
            int swipeEndHeight = height / 2;

            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);

            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();

        }
    }




    @Step({"<key> li elementin değeri <text> e içerdiğini kontrol et",
            "Find element by <key> and text contains <text>"})
    public void containsTextByKey(String key, String text) {
        By by = selector.getElementInfoToBy(key);
        assertTrue(appiumFluentWait.until(new ExpectedCondition<Boolean>() {
            private String currentValue = null;

            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    currentValue = driver.findElement(by).getText();
                    return currentValue.contains(text);
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public String toString() {
                return String.format("text contains be \"%s\". Current text: \"%s\"", text, currentValue);
            }
        }));
    }

    @Step({"<key> li elementin değeri <text> e eşitliğini kontrol et",
            "Find element by <key> and text equals <text>"})
    public void equalsTextByKey(String key, String text) {
        assertTrue(appiumFluentWait.until(
                ExpectedConditions.textToBe(selector.getElementInfoToBy(key), text)));
    }

    @Step({"<seconds> saniye bekle", "Wait <second> seconds"})
    public void waitBySecond(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
            logger.info(seconds + " saniye beklendi");
            System.out.println("-----------------------------------------------------------------");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void swipeUpAccordingToPhoneSize() {
        if (appiumDriver instanceof AndroidDriver) {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;
            System.out.println(width + "  " + height);

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 20) / 100;
            int swipeEndHeight = (height * 80) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction((AndroidDriver) appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        } else {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 35) / 100;
            int swipeEndHeight = (height * 75) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        }
    }

  public void swipeTwoUpAccordingToPhoneSize() {
        if (appiumDriver instanceof AndroidDriver) {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;
            System.out.println(width + "  " + height);

            int swipeStartWidth = width / 4, swipeEndWidth = width / 6;
            int swipeStartHeight = (height * 10) / 100;
            int swipeEndHeight = (height * 36) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction((AndroidDriver) appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        } else {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 25) / 100;
            int swipeEndHeight = (height * 60) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        }
    }


    public void swipeDownAccordingToPhoneSize() {
        if (appiumDriver instanceof AndroidDriver) {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 90) / 100;
            int swipeEndHeight = (height * 50) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();
        } else {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 90) / 100;
            int swipeEndHeight = (height * 40) / 100;
            // appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();
        }
    }

    public boolean isElementPresent(By by) {
        return findElementWithoutAssert(by) != null;
    }


    @Step({"<times> kere aşağıya kaydır", "Swipe times <times>"})
    public void swipe(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            swipeDownAccordingToPhoneSize();
            waitBySecond(3);

            System.out.println("-----------------------------------------------------------------");
            System.out.println("SWİPE EDİLDİ");
            System.out.println("-----------------------------------------------------------------");

        }
    }


    @Step({"<times> kere yukarı doğru kaydır", "Swipe up times <times>"})
    public void swipeUP(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            swipeUpAccordingToPhoneSize();
            waitBySecond(1);

            System.out.println("-----------------------------------------------------------------");
            System.out.println("SWİPE EDİLDİ");
            System.out.println("-----------------------------------------------------------------");

        }
    }

  @Step({"<times> kere hafif yukarı doğru kaydır", "Swipe up times <times>"})
    public void swipeUPTwo(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            swipeTwoUpAccordingToPhoneSize();
            waitBySecond(1);

            System.out.println("-----------------------------------------------------------------");
            System.out.println("SWİPE EDİLDİ");
            System.out.println("-----------------------------------------------------------------");

        }
    }


    @Step({"Klavyeyi kapat", "Hide keyboard"})
    public void hideAndroidKeyboard() {
        try {

            if (localAndroid == false) {
                findElementWithoutAssert(By.xpath("//XCUIElementTypeButton[@name='Toolbar Done Button']")).click();
            } else {
                appiumDriver.hideKeyboard();
            }

        } catch (Exception ex) {
            logger.error("Klavye kapatılamadı " + ex.getMessage());
        }
    }

    @Step({"<text> değerini sayfa üzerinde olup olmadığını kontrol et."})
    public void getPageSourceFindWord(String text) {
        assertTrue(appiumDriver.getPageSource().contains(text), text + " sayfa üzerinde bulunamadı."
        );

        logger.info(text + " sayfa üzerinde bulundu");
    }



    @Step("geri butonuna bas")
    public void clickBybackButton() {
        if (!localAndroid) {
            backPage();
        } else {
            ((AndroidDriver) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
        }

    }


    @Step("<StartX>,<StartY> oranlarından <EndX>,<EndY> oranlarına <times> kere swipe et")
    public void pointToPointSwipe(int startX, int startY, int endX, int endY, int count) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();

        int height = d.height;
        int width = d.width;
        startX = (width * startX) / 100;
        startY = (height * startY) / 100;
        endX = (width * endX) / 100;
        endY = (height * endY) / 100;
        for (int i = 0; i < count; i++) {
            waitBySecond(1);
            TouchAction action = new TouchAction(appiumDriver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release().perform();
        }


    }


    @Step("<key> elementinin hizasından sağdan sola <times> kere kaydır")
    public void swipeFromLeftToRightAligned(String key, int times) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();

        int height = d.height;
        int width = d.width;
        Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();
        pointToPointSwipeWithCoordinats(width - 50, elementLocation.getY(), 40, elementLocation.getY(), times);
    }
    @Step("<key> elementinin adres bilgilerini <times> kere kaydırarak temizle")
    public void adresTemizleme(String key, int times) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();
        int height = d.height;
        int width = d.width;
        boolean ifExist2 = doesElementExistByKey(key, 5);
        if(ifExist2){
            Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();
            for (int i =0; i<key.length();i++){
                boolean ifExist = doesElementExistByKey(key, 5);
                if(ifExist){
                    pointToPointSwipeWithCoordinats(width - 50, elementLocation.getY(), 40, elementLocation.getY(), times);
                    waitBySecond(1);
                    clickByKey("adresBilgisiniSilmeyiOnaylamaButonuOD");
                }
                else {break;}}}}
    @Step("<key> elementinin adres bilgilerini <times> kere kaydırarak temizle iOS")
    public void adresTemizlemeIOS(String key, int times) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();
        int height = d.height;
        int width = d.width;
        boolean ifExist2 = doesElementExistByKey(key, 5);
        if(ifExist2){
            Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();
            for (int i =0; i<key.length();i++){
                boolean ifExist = doesElementExistByKey(key, 5);
                if(ifExist){
                    pointToPointSwipeWithCoordinats(width - 50, elementLocation.getY(), 40, elementLocation.getY(), times);
                    waitBySecond(1);
                }
                else {break;}}}}




        @Step("<key> elementinin kart bilgisini <times> kere kaydırarak temizle")
    public void kartBilgisiTemizleme(String key, int times) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();
        int height = d.height;
        int width = d.width;
            boolean ifExist2 = doesElementExistByKey(key, 5);
            if(ifExist2){
                Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();
                for (int i = 0; i< key.length(); i++){
                    boolean ifExist = doesElementExistByKey(key, 5);
                    if(ifExist){
                        pointToPointSwipeWithCoordinats(width - 50, elementLocation.getY(), 40, elementLocation.getY(), times);
                        waitBySecond(1);}
                    else{break;}
                }
            }
          }
    @Step("<key> elementinin favori urunlerini <times> kere kaydırarak temizle")
    public void favoriUrunSilme(String key, int times) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();

        int height = d.height;
        int width = d.width;
        boolean ifExisttwo = doesElementExistByKey(key, 5);

        if(ifExisttwo){
            Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();

            for (int i = 0; i< key.length(); i++){
                boolean ifExist = doesElementExistByKey(key, 5);
                if(ifExist){
                    pointToPointSwipeWithCoordinats(width - 50, elementLocation.getY(), 40, elementLocation.getY(), times);
                    waitBySecond(1);
                    clickByKey("favoriUrunSilmeyiOnaylamaButonuOD");
                }
                else{break;}
            }
        }
          }

    @Step("<key> li elementi hizala ve sagdan sola kaydır <times> kere y cordinatına <number> ekle")
    public void horizontalSwipeWithElement(String key, int times, int number) throws InterruptedException {

        Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();
        logger.info("x==" + elementLocation.getX() + " y==" + elementLocation.getY() + "----------");

        pointToPointSwipeWithCoordinats(900, elementLocation.getY(), 40, elementLocation.getY(), times);
        logger.info("-----horizonal kaydırma işlemi tamamlandı-----");
    }

    @Step("<StartX>,<StartY> coordinatından <EndX>,<EndY> coordinatına <times> kere swipe et")
    public void pointToPointSwipeWithCoordinats(int startX, int startY, int endX, int endY, int count) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();


        for (int i = 0; i < count; i++) {
            waitBySecond(1);
            TouchAction action = new TouchAction(appiumDriver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release().perform();
            logger.info("SWİPE EDİLDİ");
            logger.info("-----------------------------------------------------------");
        }


    }

    public void pointToPointSwipeForDayAndYear(int startX, int startY, int endX, int endY, int count) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();
        int height = d.height;
        int width = d.width;
        if (count > 200) {
            startX = (width * startX) / 100;
            startY = (height * startY) / 100;
            endX = (width * endX) / 100;
            endY = (height * endY) / 100;
            count = count - 2019;

        } else
            count--;
        for (int i = 0; i < count; i++) {
            waitBySecond(1);
            TouchAction action = new TouchAction(appiumDriver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release().perform();
        }
    }

    @Step("uygulamayı yeniden başlat")
    public void restart() throws InterruptedException {
        appiumDriver.closeApp();
        appiumDriver.launchApp();
        logger.info("uygulama yeniden başlatıldı");
        waitBySecond(5);

    }

    private void backPage() {
        appiumDriver.navigate().back();
    }


    private String getCapability(String text) {
        return appiumDriver.getCapabilities().getCapability(text).toString();

    }

    public boolean doesElementExistByKey(String key, int time) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        try {
            WebDriverWait elementExist = new WebDriverWait(appiumDriver, time);
            elementExist.until(ExpectedConditions.visibilityOfElementLocated(selectorInfo.getBy()));
            return true;
        } catch (Exception e) {
            logger.info(key + " elementi araniyor");
            System.out.println("-----------------------------------------------------------------");

            return false;
        }

    }


    public void tapElementWithCoordinate(int x, int y) {
        TouchAction a2 = new TouchAction(appiumDriver);
        a2.tap(PointOption.point(x, y)).perform();
    }

    @Step("<key> li elementin  merkezine tıkla ")
    public void tapElementWithKey(String key) {

        Point point = findElementByKey(key).getCenter();
        TouchAction a2 = new TouchAction(appiumDriver);
        a2.tap(PointOption.point(point.x, point.y)).perform();
    }

    @Step("<key> li element varsa  <x> <y> koordinatına tıkla ")
    public void tapElementWithKeyCoordinate(String key, int x, int y) {

        logger.info("element varsa verilen koordinata tıkla ya girdi");
        MobileElement mobileElement;

        mobileElement = findElementByKeyWithoutAssert(key);

        if (mobileElement != null) {

            System.out.println("pakachu");
            Point point = mobileElement.getLocation();
            logger.info(point.x + "  " + point.y);
            Dimension dimension = mobileElement.getSize();
            logger.info(dimension.width + "  " + dimension.height);
            TouchAction a2 = new TouchAction(appiumDriver);
            a2.tap(PointOption.point(point.x + (dimension.width * x) / 100, point.y + (dimension.height * y) / 100)).perform();
        }
    }

    @Step("<key> li elementin  merkezine  press ile çift tıkla ")
    public void pressElementWithKey(String key) {

        Point point = findElementByKey(key).getCenter();
        TouchAction a2 = new TouchAction(appiumDriver);
        a2.press(PointOption.point(point.x, point.y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .press(PointOption.point(point.x, point.y)).release().perform();

    }


    @Step("<key> li elementin  merkezine double tıkla ")
    public void pressElementWithKey2(String key) {
        Actions actions = new Actions(appiumDriver);
        actions.moveToElement(findElementByKey(key));
        actions.doubleClick();
        actions.perform();
        appiumDriver.getKeyboard();

    }

    @Step("<key> li elementi rasgele sec")
    public void chooseRandomProduct(String key) {

        List<MobileElement> productList = new ArrayList<>();
        List<MobileElement> elements = findElemenstByKey(key);
        int elementsSize = elements.size();
        int height = appiumDriver.manage().window().getSize().height;
        for (int i = 0; i < elementsSize; i++) {
            MobileElement element = elements.get(i);
            int y = element.getCenter().getY();
            if (y > 0 && y < (height - 100)) {
                productList.add(element);
            }
        }
        Random random = new Random();
        int randomNumber = random.nextInt(productList.size());
        productList.get(randomNumber).click();
        logger.info(randomNumber + ". elemente tiklandi");
    }


    @Step("<key> li elemente kadar <text> textine sahip değilse ve <timeout> saniyede bulamazsa swipe yappp")
    public void swipeAndFindwithKey(String key, String text, int timeout) {
        MobileElement sktYil1 = null;
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        WebDriverWait wait = new WebDriverWait(appiumDriver, timeout);
        int count = 0;
        while (true) {
            count++;
            try {
                sktYil1 = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(selectorInfo.getBy()));
                if (text.equals("") || sktYil1.getText().trim().equals(text)) {
                    break;
                }
            } catch (Exception e) {
                logger.info("Bulamadı");

            }
            if (count == 8) {

                Assertions.fail("Element bulunamadı");
            }

            Dimension dimension = appiumDriver.manage().window().getSize();
            int startX1 = dimension.width / 2;
            int startY1 = (dimension.height * 75) / 100;
            int secondX1 = dimension.width / 2;
            int secondY1 = (dimension.height * 30) / 100;

            TouchAction action2 = new TouchAction(appiumDriver);

            action2
                    .press(PointOption.point(startX1, startY1))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(secondX1, secondY1))
                    .release()
                    .perform();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    @Step("<key>li elementi bulana kadar <limit> kere swipe yap ve elementi bul")
    public void swipeKeyy(String key, int limit) throws InterruptedException {


        boolean isAppear = false;

        int windowHeight = this.getScreenHeight();
        for (int i = 0; i < limit; ++i) {
            try {

                Dimension phoneSize = appiumDriver.manage().window().getSize();
                Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();
                logger.info(elementLocation.x + "  " + elementLocation.y);
                Dimension elementDimension = findElementByKeyWithoutAssert(key).getSize();
                logger.info(elementDimension.width + "  " + elementDimension.height);
                // logger.info(appiumDriver.getPageSource());
                if ((0 < elementLocation.y) && (elementLocation.y <= phoneSize.height - 30)) {
                    isAppear = true;
                    logger.info("aranan elementi buldu");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Element ekranda görülmedi. Tekrar swipe ediliyor");
            }
            System.out.println("Element ekranda görülmedi. Tekrar swipe ediliyor");

            swipeUpAccordingToPhoneSize();
            waitBySecond(1);
        }

    }


    @Step("<key> li  telefonun  <x> ve elementin <y> kordinatına göre tıkla")
    public void elementFindwithXandYcoordinate(String key, int x, int y) {

        WebElement element = findElementByKey(key);
        int height = element.getLocation().y + (element.getSize().height * y) / 100;
        int width = (appiumDriver.manage().window().getSize().width * x) / 100;
        System.out.println(height + "  " + width + "   ");
        TouchAction action = new TouchAction(appiumDriver);
        action.tap(PointOption.point(width, height)).perform();
    }

    @Step("<key> elementinin koordinatlarına x=<x> y=<y> degerlerini ekleyerek tıkla")
    public void coordinatClickWithAdds(String key, int x, int y) {
        MobileElement me = findElementByKey(key);
        tapElementWithCoordinate(me.getLocation().x + x, me.getLocation().y + y);
    }

    @Step("<x>,<y> koordinatlarına tıkla")
    public void koordinataTikla(int x, int y) {
        TouchAction a2 = new TouchAction(appiumDriver);
        a2.tap(PointOption.point(x, y)).perform();
        logger.info("tıklama yapıldı");
    }

    // --------------------------------------------------------------------------------------------------

    @Step("<key> elementin integer degerini bir dizine at")
    public void getIntFromElement(String key){
        String text = findElementByKey(key).getText();
        integerList.add(Integer.valueOf(text));
        logger.info(text+" degeri dizine atıldı");
        System.out.println("-----------------------------------------------");
    }

    @Step("<key> elementin text degeri bir dizine at")
    public void getTextList(String key){
        String text = findElementByKey(key).getText();
        stringList.add(text);
        logger.info(text+" texti dizine atıldı");
        System.out.println("-----------------------------------------------");

    }
    @Step("Bellekte kaydedilen liste ve mapleri temizle")
    public void clearListsFromRam() {
        stringList.clear();
        integerList.clear();
        userVariableHashMap.clear();
    }
    @Step("<key> elementinden TL harflerini sil ve Integer dizine kaydet")
    public void revomeTLFromPriceAndSave(String key){
        String value=findElementByKey(key).getText();
        value = value.replaceAll(" TL", "");
        value = value.replaceAll("\\,", "");
        int sayi=(Integer.parseInt(value));
        integerList.add(sayi);
        logger.info(sayi +" degerini dizine atıldı");
    }
    @Step("Integer listenin <index1>. elemaninin <index2>. elemanina gore <condition> olup olmadigini karsilastir")
   //* Integer listenin "2". elemaninin "1". elemanina gore "küçük" olup olmadigini karsilastir
    public void compareTwoInteger(int index1, int index2, String condition) {
        if(condition.equals("büyük")) {
            assertTrue(integerList.get(index1-1) > integerList.get(index2-1),index1+". eleman, "+index2+". elemandan büyük değil.Elemanlar: "+integerList.get(index1-1)+" ve "+integerList.get(index2-1));
            logger.info(index1+". eleman, "+index2+". elemandan büyük.Elemanlar: "+integerList.get(index1-1)+" ve "+integerList.get(index2-1));
            System.out.println("-----------------------------------------------");

        }
        else if(condition.equals("küçük")) {
            assertTrue(integerList.get(index1-1) < integerList.get(index2-1),index1+". eleman, "+index2+". elemandan küçük değil.Elemanlar: "+integerList.get(index1-1)+" ve "+integerList.get(index2-1));
            logger.info(index1+". eleman, "+index2+". elemandan küçük.Elemanlar: "+integerList.get(index1-1)+" ve "+integerList.get(index2-1));
            System.out.println("-----------------------------------------------");

        }
        else if(condition.equals("eşit değil")) {
            assertTrue(integerList.get(index1-1) == integerList.get(index2-1),index1+". eleman, "+index2+". elemana eşit değil.Elemanlar: "+integerList.get(index1-1)+" ve "+integerList.get(index2-1));
            logger.info(index1+". eleman, "+index2+". elemana eşit değil.Elemanlar: "+integerList.get(index1-1)+" ve "+integerList.get(index2-1));
            System.out.println("-----------------------------------------------");

        }
        else if(condition.equals("eşit")) {
            assertTrue(integerList.get(index1-1) != integerList.get(index2-1),index1+". eleman, "+index2+". elemana eşit.Elemanlar: "+integerList.get(index1-1)+" ve "+integerList.get(index2-1));
            logger.info(index1+". eleman, "+index2+". elemana eşit.Elemanlar: "+integerList.get(index1-1)+" ve "+integerList.get(index2-1));
            System.out.println("-----------------------------------------------");

        }
        else {
            Assertions.fail("Hatali koşul girişi yapılmıştır");
        }
    }

    @Step("String listenin <index1>. elemaninin <index2>. elemanina gore <condition> olup olmadigini karsilastir")
    public void compareTwoString(int index1, int index2, String condition) {
        if(condition.equals("büyük")) {
            assertTrue(stringList.get(index1-1).compareTo(stringList.get(index2-1)) > 0,index1+". eleman, "+index2+". elemandan büyük değil.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
            logger.info(index1+". eleman, "+index2+". elemandan büyük.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
        }
        else if(condition.equals("küçük")) {
            assertTrue(stringList.get(index1-1).compareTo(stringList.get(index2-1)) < 0,index1+". eleman, "+index2+". elemandan küçük değil.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
            logger.info(index1+". eleman, "+index2+". elemandan küçük.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
        }
        else if(condition.equals("eşit")) {
            assertTrue(stringList.get(index1-1).compareTo(stringList.get(index2-1)) == 0,index1+". eleman, "+index2+". elemana eşit değil.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
            logger.info(index1+". eleman, "+index2+". elemana eşit.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
        }
        else if(condition.equals("eşit değil")) {
            assertTrue(stringList.get(index1-1).compareTo(stringList.get(index2-1)) != 0,index1+". eleman, "+index2+". elemana eşit.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
            logger.info(index1+". eleman, "+index2+". elemana eşit değil.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
        }
        else if(condition.equals("içerir")) {
            assertTrue(stringList.get(index1-1).contains(stringList.get(index2-1)),index1+". eleman, "+index2+". elemanı içermiyor.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
            logger.info(index1+". eleman, "+index2+". elemanı içeriyor.Elemanlar: "+stringList.get(index1-1)+" ve "+stringList.get(index2-1));
        }
        else {
            Assertions.fail("Hatali koşul girişi yapılmıştır");
        }
    }


    @Step("<text> textini içeren elemente kadar aşağı kaydır")
    public void swipeToElementContainsText(String text) {
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("name", text);
        appiumDriver.executeScript("mobile:scroll", scrollObject);
        appiumDriver.findElementByXPath("//*[@label='"+text+"']").click();
    }
    @Step({"<length> uzunlugunda random bir kelime üret ve <saveKey> olarak sakla"})
    public void createRandomNumber(int length, String saveKey) {
        StoreHelper.INSTANCE.saveValue(saveKey, new RandomString(length).nextString());
    }

    @Step("<key> li element varsa tıkla")
    public void tapElementWithKeyControl(String key) {
        for (int i = 0; i < key.length(); i++) {
        boolean ifExist = doesElementExistByKey(key, 5);



        if (ifExist) {

            findElementByKey(key).click();
            logger.info(key + "elemente tıkladı");
            System.out.println("-----------------------------------------------------------------");
        }
                else
                    return;
            }
        }





    @Step("<key> li element varsa tek tıkla")
    public void tapElementWithKeyControlTwo(String key) {

     //   logger.info("element varsa tıkla yoksa devam et başladı");
        boolean ifExist = doesElementExistByKey(key, 5);

        if (ifExist) {
            findElementByKey(key).click();
            logger.info(key + " elemente tıkladı");
            System.out.println("-----------------------------------------------------------------");

        }

        else {
           // logger.info(key + " element bulunamadı");

    }

    }
    @Step("Rastgele date numara uret")
    public void generateRandomDateNumber() {
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyHHmmss");
        String date = DATE_FORMAT.format(today);
        kaydedilmisNumara = "5127" + date;
        logger.info(kaydedilmisNumara);
    }

    @Step("<key> li elementi bul, temizle ve random numara değerini yaz")
    public void sendRandomNumber(String key) {
        MobileElement webElement = findElementByKey(key);
        webElement.clear();
        webElement.setValue(kaydedilmisNumara);
    }

    @Step("<index> li <key> içeren elementin bulunduğu yeri <times> kere <yön> tarafa kaydır")
    public void swipeDirectionTimes(int index, String key, int times, String yön) {
        Dimension dimensions = appiumDriver.manage().window().getSize();
        Point center = null;
        if (index==1) {
            center = findElementByKey(key).getCenter();
        }
        else if (index>1) {
            center = findElemenstByKey(key).get(index).getCenter();
        }
        else {
            Assertions.fail("hatalı index girişi");
        }

        TouchAction action = new TouchAction(appiumDriver);
        int startPoint = 0;
        if (yön.equals("sol")) {
            startPoint = (int) (dimensions.getWidth() * 0.9);
        }
        else if(yön.equals("sag")){
            startPoint = (int) (dimensions.getWidth() * 0.1);
        }
        for (int i = 0; i < times; i++) {
            action.longPress(PointOption.point(startPoint, (center.y)));
            action.moveTo(PointOption.point(center.x, (center.y)));
            action.release();
            action.perform();
        }
    }




    @Step("Adreslerim sayfasinda tüm adresleri temizle <key>")
    public void checkAndDeleteAdress(String key){
        for(int i = 0 ; i < 5 ; i++){
            boolean isThreeAdressExist = doesElementExistByKey(key,3);
            if(isThreeAdressExist){
                clickByKeyIndex("adresDuzenlemeButonu", 3);
                System.out.println("adresDuzenlemeButonu" + " elementine tikladi");

                tapElementWithKeyControl("adresGuncellemeBuAdresiSilButonu");
                waitBySecond(4);
                tapElementWithKeyControl("adresGuncellemeSilmeSilButonu");
            }else{
                System.out.println("Mevcut durumda 3 veya daha az adres bulunmakta");
            }
        }
    }

    @Step("<key> yoksa cikis Yapilir")
    public void logout(String key){
        boolean logout = doesElementExistByKey(key,5);
        if(!logout){
            appiumDriver.findElement(By.id("com.clickme.clickmelive.debug:id/layout_logout")).click();
            appiumDriver.findElement(By.id("com.clickme.clickmelive.debug:id/button_primary")).click();
            appiumDriver.findElement(By.id("com.clickme.clickmelive.debug:id/profile")).click();
        }
        else {
            logger.info("Uygulamaya Login Olunuyor");
            logger.info("----------------------------------------------------");
        }

    }
    @Step("<key> yoksa cikis Yapilir iOS")
    public void logoutIOS(String key){
        boolean logout = doesElementExistByKey(key,5);
        if(!logout){
           // appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Çıkış Yap']")).click();
           // appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='Çıkış Yap']")).click();
            // appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name='TabBar.Profile']")).click();
            clickByKey("cikisYapButonuPS");
            clickByKey("cikisYapButonuOnaylamaPS");
            clickByKey("ProfilimMenuButonuPS");
        }
        else {
            logger.info("Uygulamaya Login Olunuyor");
            logger.info("----------------------------------------------------");
        }



    }



}
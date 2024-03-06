/**
 *
 *  Created by furkanbicer@testinium.com
 *
 *  Projenin çalışması için Chromedriver'ın projeye eklenmesi gerekmez.
 *  Pom.xml'de yer alan io.github.bonigarcia ile kullanılan makinenin chrome driverın versiyonu otomatik olarak algılanarak test koşumu sağlanmaktadır.
 *  İstenilen senaryo 5 adım olarak verildiği için 5 adet page + 1 adet Base page kullanıldı.
 *  Senaryoları tek bir run ile çalıştırmak yerine 5 farklı adım ile yazdıldı ve her run için @TestMethodOrder annotationu ile runlara order ataması yapıldı.
 *  Test_Check_Insider_Apply java classında yer alan her adım dökümanda verilen adıma göre sırayla yazıldı.
 *  Projede statik bekleme kullanılmadı ve tüm beklemeler dinamik olarak yazıldı.
 *
 * */

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }
    public void isUrlEqual(String url) {
        Assertions.assertTrue(driver.getCurrentUrl().equals(url), "Url's not equal");
    }
    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        webElement.click();
    }
    public void checkElementClickable(By locator) {
        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
    }
    public void checkElementClickableThenClick(By locator) {
        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Locator= " + locator + " Element is clickable");
            click(locator);
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
    }
    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void hoverElementAction(By locator) {
        WebElement webElement = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
    }

    public void scrollElementWithJs(By locator) throws InterruptedException {
        WebElement webElement = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        Thread.sleep(500);
    }


    public boolean checkElementInVisible(By locator) {

        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(locator));
            logger.info("true");
            return true;
        } catch (Exception e) {
            logger.info("false" + " " + e.getMessage());
            return false;
        }
    }

    public boolean checkElementVisible(By locator) {

        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("true");
            return true;
        } catch (Exception e) {
            logger.info("false" + " " + e.getMessage());
            return false;
        }
    }
    public void switchTab(int tabNumber){

        driver.switchTo().window(listTabs().get(tabNumber));
    }
    public List<String> listTabs(){
        List<String> list = new ArrayList<String>();
        for (String window: driver.getWindowHandles()){
            list.add(window);
        }
        return list;
    }


}


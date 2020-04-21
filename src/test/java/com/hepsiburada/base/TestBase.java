package com.hepsiburada.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

public class TestBase {

    public JavascriptExecutor javascriptExecutor(WebDriver driver) {
        return (JavascriptExecutor) driver;
    }

    public void clickElementWithJS(WebDriver driver, WebElement element) {

        javascriptExecutor(driver).executeScript("arguments[0].click();", element);
    }


    public void moveElement(WebDriver driver, WebElement webElement) throws InterruptedException {
        Actions actions = new Actions(driver);
        try {
            scrollToOfset(driver, webElement.getLocation().x, webElement.getLocation().y);
            Thread.sleep(500);
            actions.moveToElement(webElement).build().perform();
        } catch (MoveTargetOutOfBoundsException me) {
            scrollToElement(driver, webElement);
            Thread.sleep(500);
            actions.moveByOffset(webElement.getLocation().x, webElement.getLocation().y).build().perform();
        }
        Thread.sleep(1000);
    }

    public void scrollToElement(WebDriver driver, WebElement webElement) {
        javascriptExecutor(driver).executeScript("window.scrollTo(" + webElement.getLocation().x + "," + webElement.getLocation().y + ");");
    }

    public void scrollToOfset(WebDriver driver, int x, int y) {
        javascriptExecutor(driver).executeScript("window.scrollTo(" + x + "," + y + ");");
    }

    public static void waitForDOMLoad(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Boolean readyState;
            Boolean jqueryDefined;
            for (int i = 0; i <= 60; i++) {
                readyState = js.executeScript("return document.readyState").toString() != "complete";
                jqueryDefined = js.executeScript("return typeof jQuery").toString() != "function";

                if (readyState && jqueryDefined) {
                    break;
                } else {
                    Thread.sleep(100);
                }
            }

        } catch (Exception e) {
            try {
                throw e;
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

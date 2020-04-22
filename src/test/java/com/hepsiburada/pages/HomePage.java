package com.hepsiburada.pages;

import com.hepsiburada.base.TestBase;
import com.thoughtworks.gauge.Gauge;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.hepsiburada.base.BaseTest.WAIT_TIME;

public class HomePage extends TestBase {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
    }

    @FindBy(css = ".logo-hepsiburada")
    private WebElement logoHepsiburada;

    @FindBy(id = "myAccount")
    private WebElement myAccount;

    @FindBy(id = "login")
    private WebElement login;

    @FindBy(id = "myAccount")
    private WebElement userName;

    public HomePage assertHomeIsLoaded() {
        Gauge.captureScreenshot();
        Assert.assertTrue("logo is not displayed on homepage", logoHepsiburada.isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.hepsiburada.com/"));
        return this;
    }

    public HomePage moveToMyAccount() throws InterruptedException {
        Gauge.captureScreenshot();
        moveElement(driver, myAccount);
        return this;
    }

    public SignInPage clickLogin() {
        Gauge.captureScreenshot();
        clickElementWithJS(driver, login);
        return new SignInPage(driver);
    }

    public HomePage assertIsLoggedIn(String _userName) throws InterruptedException {
        Gauge.captureScreenshot();
        waitForDOMLoad(driver);
        String name = new String();
        for (int i = 0; i < 150; i++) {
            Thread.sleep(100);
            name = userName.getText().split("\n")[1];
            if (name != null && !name.equals("")) {
                break;
            }
        }
        Assert.assertEquals(_userName,name);
        return this;
    }

}

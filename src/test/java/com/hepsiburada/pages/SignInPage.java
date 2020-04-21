package com.hepsiburada.pages;

import com.hepsiburada.base.TestBase;
import com.thoughtworks.gauge.Gauge;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static com.hepsiburada.base.BaseTest.WAIT_TIME;

public class SignInPage extends TestBase {
    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
    }

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = ".btn-login-submit")
    private List<WebElement> btnLoginSubmit;


    @FindBy(id = "email")
    private WebElement emailInput;

    public SignInPage assertLoginPageIsLoaded() {
        Gauge.captureScreenshot();
        Assert.assertTrue("email input is not displayed", emailInput.isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("giris"));
        return this;
    }

    public SignInPage typeEmail(String mail) {
        Gauge.captureScreenshot();
        emailInput.sendKeys(mail);
        return this;
    }

    public SignInPage typePassword(String password) {
        Gauge.captureScreenshot();
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage clickBtnLoginSubmit() {
        Gauge.captureScreenshot();
        clickElementWithJS(driver, btnLoginSubmit.get(0));
        return new HomePage(driver);
    }

}

package com.hepsiburada.steps;

import com.hepsiburada.base.BaseTest;
import com.hepsiburada.pages.HomePage;
import com.hepsiburada.pages.SignInPage;
import com.thoughtworks.gauge.Step;

import java.io.IOException;

public class StepImplementation extends BaseTest {
    SignInPage signInPage = new SignInPage(driver);
    HomePage homePage = new HomePage(driver);

    @Step("<sec> saniye bekle")
    public void sleep(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @Step("hepsiburada girişe tıkladı")
    public void clickLogin() throws IOException {

        homePage.assertHomeIsLoaded()
                .clickLogin();
    }

    @Step("kullanıcı adı kısmına <userName> girildi")
    public void typeEmail(String userName) {
        signInPage.typeEmail(userName);
    }


    @Step("giriş sayfası açıldı")
    public void assertLoginPage() {
        signInPage.assertLoginPageIsLoaded();
    }

    @Step("şifre <userPassword> girildi")
    public void typePassword(String userPassword) {
        signInPage.typePassword(userPassword);
    }

    @Step("giriş yap tıklandı")
    public void clickSubmit() {
        signInPage.clickBtnLoginSubmit();
    }

    @Step("<userName> ile giriş yapıldı")
    public void assertIsLogged(String userName) throws InterruptedException {
        homePage.assertHomeIsLoaded()
                .assertIsLoggedIn(userName);
    }
}

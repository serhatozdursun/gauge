package com.hepsiburada.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.hepsiburada.util.Configuration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    public static WebDriver driver;
    public static int WAIT_TIME = 15;

    @BeforeScenario
    public void setup() {
        Configuration configuration = new Configuration();

        String USER_AGENT = "Mozilla/5.0 (WghrXkuMnF) AppleWebKit/5.0 Chrome/8.0 Safari/5.0";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + configuration.getProperty("driver.url.for.mac"));
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certifcate-errors");
        chromeOptions.addArguments("--user-agent=" + USER_AGENT);
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-plugins");
        chromeOptions.addArguments("--disable-plugins-discovery");
        chromeOptions.addArguments("--always-authorize-plugins");
        chromeOptions.addArguments("--disable-preconnect");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.merge(desiredCapabilities);
        driver = new ChromeDriver(chromeOptions);
        driver.get(configuration.getProperty("base.url"));
    }

    @AfterScenario
    public void close() {
        driver.quit();
    }
}

package com.ericsson.de.taf.ui;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessTest {

    @Test
    public void testChromeExecution() throws IOException {

        //FIXME driver can be downloaded from here: https://chromedriver.storage.googleapis.com/index.html
        System.setProperty("webdriver.chrome.driver", "/home/ethomev/Work/selenium/drivers/chrome/chrome-linux-x64");

        // Add options to Google Chrome. The window-size is important for responsive sites

        ChromeOptions options = new ChromeOptions();

        options.addArguments("headless");

        options.addArguments("window-size=1200x600");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://seleniumhq.org");

        // a guarantee that the test was really executed

        assertThat(driver.findElement(By.id("q")).isDisplayed()).isTrue();


        driver.quit();

    }

    @Test
    public void testFirefoxExecution() throws IOException {
        FirefoxBinary binary  = new FirefoxBinary();
        binary.addCommandLineOptions("--headless");

        //FIXME driver can be downloaded from here: https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver", "/home/ethomev/Work/selenium/drivers/gecko/0.15/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(binary);
        FirefoxDriver driver = new FirefoxDriver(options);
        try {
            driver.get("http://www.google.com");
            driver.manage().timeouts().implicitlyWait(4,
                    TimeUnit.SECONDS);
            WebElement queryBox = driver.findElement(By.name("q"));
            queryBox.sendKeys("headless firefox");
            WebElement searchBtn = driver.findElement(By.name("btnK"));
            searchBtn.click();
            WebElement iresDiv = driver.findElement(By.id("ires"));
            iresDiv.findElements(By.tagName("a")).get(0).click();
            System.out.println(driver.getPageSource());
        } finally {
            driver.quit();
        }
    }
}

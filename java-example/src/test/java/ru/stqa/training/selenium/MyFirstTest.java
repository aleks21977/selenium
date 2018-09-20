package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary(new FirefoxBinary(new File("c:\\Program Files\\Mozilla Firefox\\firefox.exe")));
//        WebDriver driver = new FirefoxDriver(options);

//        FirefoxBinary bin = new FirefoxBinary(new File("c:\\Program Files\\Mozilla Firefox\\firefox.exe"));
//        WebDriver driver = new FirefoxDriver(bin, new FirefoxProfile());

        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
        driver.get("http://www.google.com/");
        driver.findElement(By.id("gs_ok0")).click();
        driver.findElement(By.id("K32")).click();
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
package com.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTest {

    protected WebDriver driver;
    protected final static String PASTE_FROM_CLIPBOARD = Keys.CONTROL + "v";

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    protected void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    protected void switchToTab(String handle) {
        driver.switchTo().window(handle);
    }

    protected String getCurrentTabHandle() {
        return driver.getWindowHandle();
    }
}

package com.example.entities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTest {

    protected static WebDriver driver;
    protected final static String PASTE_FROM_CLIPBOARD = Keys.CONTROL + "v";

    @BeforeClass(alwaysRun = true)
    public void BrowserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
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

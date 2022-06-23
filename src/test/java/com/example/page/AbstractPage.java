package com.example.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected static final Duration TIMEOUT = Duration.ofSeconds(30);

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected WebElement waitUntilElementIsClickable(WebElement webElement) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitUntilElementIsVisible(By by) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitUntilElementIsVisible(WebElement webElement) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected boolean elementExists(By by) {
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}

package com.example.entities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected Duration timeOutDuration = Duration.ofSeconds(60);

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitUntilElementIsClickable(WebElement webElement) {
        return new WebDriverWait(driver, timeOutDuration)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitUntilElementIsVisible(By by) {
        return new WebDriverWait(driver, timeOutDuration)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitUntilElementIsVisible(WebElement webElement) {
        return new WebDriverWait(driver, timeOutDuration)
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

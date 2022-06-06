package com.example.page.yopmail;

import com.example.entities.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InboxPage extends AbstractPage {

    private static final By ESTIMATED_MONTHLY_COST_LOCATOR = By.xpath("//*[contains(text(),'Estimated Monthly Cost:')]");

    public InboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getEstimatedMonthlyCost() {
        return new WebDriverWait(driver, Duration.ofSeconds(20),Duration.ofSeconds(3))
                .until(driver -> {
                    driver.switchTo().frame("ifmail");
                    if (elementExists(ESTIMATED_MONTHLY_COST_LOCATOR)) {
                        return driver.findElement(ESTIMATED_MONTHLY_COST_LOCATOR);
                    } else {
                        driver.switchTo().defaultContent();
                        driver.navigate().refresh();
                        return null;
                    }
                }).getText();
    }
}

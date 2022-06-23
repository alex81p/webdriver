package com.example.page.yopmail;

import com.example.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InboxPage extends AbstractPage {

    private final String inboxFrameName = "ifinbox";
    private final String mailFrameName = "ifmail";
    private final By estimatedMonthlyCostLetterLocator = By.xpath("//div[text()='Google Cloud Price Estimate']/ancestor::button");

    @FindBy(xpath = "//h2[contains(text(),'Estimated Monthly Cost:')]")
    private WebElement estimatedMonthlyCost;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public InboxPage openEstimatedMonthlyCostLetter() {
        driver.switchTo().defaultContent();
        new WebDriverWait(driver, Duration.ofSeconds(20),Duration.ofSeconds(3))
                .until(driver -> {
                    driver.switchTo().frame(inboxFrameName);
                    if (elementExists(estimatedMonthlyCostLetterLocator)) {
                        return driver.findElement(estimatedMonthlyCostLetterLocator);
                    }
                    driver.navigate().refresh();
                    return null;
                }).click();
        return this;
    }

    public String getEstimatedMonthlyCost() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(mailFrameName);
        return estimatedMonthlyCost.getText();
    }
}

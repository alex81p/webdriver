package com.example.page.pastebin;

import com.example.entities.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement pasteInput;

    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement pasteSyntaxHighlightingDropDown;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationDropDown;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteTitleInput;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPasteButton;

    public PasteBinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public PasteBinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PasteBinHomePage inputPaste(String string) {
        pasteInput.sendKeys(string);
        return this;
    }

    public PasteBinHomePage setSyntaxHighlighting(String option) {
        pasteSyntaxHighlightingDropDown.click();
        driver.findElement(By.xpath(String.format("//ul[@id='select2-postform-format-results']//li[text()='%s']", option)))
                .click();
        return this;
    }

    public PasteBinHomePage setExpiration(String option) {
        pasteExpirationDropDown.click();
        driver.findElement(By.xpath(String.format("//ul[@id='select2-postform-expiration-results']//li[text()='%s']", option)))
                .click();
        return this;
    }

    public PasteBinHomePage setTitle(String string) {
        pasteTitleInput.sendKeys(string);
        return this;
    }

    public PastePage submitNewPaste() {
        createNewPasteButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='post-view js-post-view']")));
        return new PastePage(driver);
    }
}

package com.example.page.yopmail;

import com.example.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EMailGeneratorPage extends AbstractPage {

    @FindBy(id = "cprnd")
    private WebElement copyToClipboardButton;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement checkInboxButton;

    public EMailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public EMailGeneratorPage clickCopyToClipboardButton() {
        waitUntilElementIsClickable(copyToClipboardButton).click();
        return this;
    }

    public InboxPage clickCheckInboxButton() {
        waitUntilElementIsClickable(checkInboxButton).click();
        return new InboxPage(driver);
    }
}

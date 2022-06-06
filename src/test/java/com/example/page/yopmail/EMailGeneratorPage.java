package com.example.page.yopmail;

import com.example.entities.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMailGeneratorPage extends AbstractPage {

    @FindBy(id = "cprnd")
    private WebElement copyToClipboardButton;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement checkInboxButton;

    public EMailGeneratorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
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

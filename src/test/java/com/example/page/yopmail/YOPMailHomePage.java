package com.example.page.yopmail;

import com.example.entities.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YOPMailHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://yopmail.com";

    @FindBy(xpath = "//a[@href='email-generator']")
    private WebElement eMailGeneratorLink;

    public YOPMailHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public YOPMailHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public EMailGeneratorPage clickEMailGeneratorLink() {
        waitUntilElementIsClickable(eMailGeneratorLink).click();
        return new EMailGeneratorPage(driver);
    }
}

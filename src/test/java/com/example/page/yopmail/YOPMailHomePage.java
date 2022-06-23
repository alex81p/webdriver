package com.example.page.yopmail;

import com.example.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YOPMailHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://yopmail.com";

    @FindBy(xpath = "//a[@href='email-generator']")
    private WebElement eMailGeneratorLink;

    public YOPMailHomePage(WebDriver driver) {
        super(driver);
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

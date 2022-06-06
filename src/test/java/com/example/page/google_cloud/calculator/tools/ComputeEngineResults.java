package com.example.page.google_cloud.calculator.tools;

import com.example.entities.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputeEngineResults extends AbstractPage {

    @FindBy(xpath = "//div[contains(text(), 'Provisioning model:')]")
    private WebElement provisioningModel;

    @FindBy(xpath = "//div[contains(text(), 'Instance type:')]")
    private WebElement instanceType;

    @FindBy(xpath = "//div[contains(text(), 'Region:')]")
    private WebElement region;

    @FindBy(xpath = "//div[contains(text(), 'Local SSD:')]")
    private WebElement localSSD;

    @FindBy(xpath = "//div[contains(text(), 'Commitment term:')]")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//b[contains(text(), 'Total Estimated Cost:')]")
    private WebElement totalEstimatedCost;

    @FindBy(id = "email_quote")
    private WebElement eMailEstimateButton;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement eMailInput;

    @FindBy(xpath = "//button[normalize-space(text())='Send Email']")
    private WebElement sendEMailButton;

    public ComputeEngineResults(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getProvisioningModel() {
        return getValue(waitUntilElementIsVisible(provisioningModel).getText());
    }

    public String getInstanceType() {
        return getValue(waitUntilElementIsVisible(instanceType).getText());
    }

    public String getRegion() {
        return getValue(waitUntilElementIsVisible(region).getText());
    }

    public String getLocalSSD() {
        return getValue(waitUntilElementIsVisible(localSSD).getText());
    }

    public String getCommitmentTerm() {
        return getValue(waitUntilElementIsVisible(commitmentTerm).getText());
    }

    public String getTotalEstimatedCost() {
        return getValue(waitUntilElementIsVisible(totalEstimatedCost).getText());
    }

    public ComputeEngineResults clickEMailEstimateButton() {
        waitUntilElementIsClickable(eMailEstimateButton).click();
        return this;
    }

    public ComputeEngineResults inputEMail(String eMail) {
        waitUntilElementIsVisible(eMailInput).sendKeys(eMail);
        return this;
    }

    public ComputeEngineResults clickSendEMailButton() {
        waitUntilElementIsClickable(sendEMailButton).click();
        return this;
    }

    private String getValue(String string) {
        return string
                .lines()
                .findFirst()
                .get()
                .substring(string.lastIndexOf(':') + 1).strip();
    }
}

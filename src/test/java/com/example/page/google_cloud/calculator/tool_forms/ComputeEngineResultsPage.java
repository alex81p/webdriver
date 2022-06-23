package com.example.page.google_cloud.calculator.tool_forms;

import com.example.page.AbstractPage;
import com.example.page.google_cloud.calculator.PricingCalculatorMainFrame;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputeEngineResultsPage extends AbstractPage {

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

    public ComputeEngineResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getProvisioningModel() {
        return provisioningModel.getText();
    }

    public String getInstanceType() {
        return instanceType.getText();
    }

    public String getRegion() {
        return region.getText();
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText();
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost.getText();
    }

    public ComputeEngineResultsPage clickEMailEstimateButton() {
        waitUntilElementIsClickable(eMailEstimateButton).click();
        return this;
    }

    public ComputeEngineResultsPage inputEMail(String eMail) {
        waitUntilElementIsVisible(eMailInput).sendKeys(eMail);
        return this;
    }

    public ComputeEngineResultsPage clickSendEMailButton() {
        waitUntilElementIsClickable(sendEMailButton).click();
        return this;
    }

    public ComputeEngineResultsPage switchToCalculatorFrame() {
        PricingCalculatorMainFrame.switchToCalculatorFrame(driver);
        return this;
    }
}

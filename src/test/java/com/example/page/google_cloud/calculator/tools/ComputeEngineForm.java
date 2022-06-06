package com.example.page.google_cloud.calculator.tools;

import com.example.entities.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputeEngineForm extends AbstractPage {

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement provisioningModelDropdown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement gpuCountDropdown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[normalize-space(text())='Add to Estimate']")
    private WebElement addInstancesToEstimateButton;

    public ComputeEngineForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ComputeEngineForm setNumberOfInstances(String number) {
        waitUntilElementIsVisible(numberOfInstancesInput).sendKeys(number);
        return this;
    }

    public ComputeEngineForm setOperatingSystem(String option) {
        selectOption(operatingSystemDropdown, option);
        return this;
    }

    public ComputeEngineForm setProvisioningModel(String option) {
        selectOption(provisioningModelDropdown, option);
        return this;
    }

    public ComputeEngineForm setSeries(String option) {
        selectOption(seriesDropdown, option);
        return this;
    }

    public ComputeEngineForm setMachineType(String option) {
        selectOption(machineTypeDropdown, option);
        return this;
    }

    public ComputeEngineForm addGPUs(String gpuType, String gpuCount) {
        waitUntilElementIsVisible(addGPUsCheckbox).click();
        selectOption(gpuTypeDropdown, gpuType);
        selectOption(gpuCountDropdown, gpuCount);
        return this;
    }

    public ComputeEngineForm setLocalSSD(String option) {
        selectOption(localSSDDropdown, option);
        return this;
    }

    public ComputeEngineForm setLocation(String option) {
        selectOption(datacenterLocationDropdown, option);
        return this;
    }

    public ComputeEngineForm setCommittedUsage(String option) {
        selectOption(committedUsageDropdown, option);
        return this;
    }

    public ComputeEngineForm clickAddInstancesToEstimateButton() {
        waitUntilElementIsClickable(addInstancesToEstimateButton).click();
        return this;
    }

    public ComputeEngineResults switchToComputeEngineResults() {
        return new ComputeEngineResults(driver);
    }

    private void selectOption(WebElement selector, String option) {
        waitUntilElementIsVisible(selector).click();
        String xpath = String.format("//div[@id='%s']//div[normalize-space(text())='%s']",
                selector.getAttribute("aria-owns"), option);
        waitUntilElementIsVisible(By.xpath(xpath)).click();
    }
}

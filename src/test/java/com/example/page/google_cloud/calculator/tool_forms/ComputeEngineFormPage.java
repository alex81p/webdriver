package com.example.page.google_cloud.calculator.tool_forms;

import com.example.model.google_cloud.ComputeEngineForm;
import com.example.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputeEngineFormPage extends AbstractPage {

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

    private final String optionLocator = "//div[@id='%s']//div[normalize-space(text())='%s']";

    public ComputeEngineFormPage(WebDriver driver) {
        super(driver);
    }

    public ComputeEngineFormPage setNumberOfInstances(String number) {
        if (number != null) {
            waitUntilElementIsVisible(numberOfInstancesInput).sendKeys(number);
        }
        return this;
    }

    public ComputeEngineFormPage setOperatingSystem(String option) {
        if (option != null) {
            selectOption(operatingSystemDropdown, option);
        }
        return this;
    }

    public ComputeEngineFormPage setProvisioningModel(String option) {
        if (option != null) {
            selectOption(provisioningModelDropdown, option);
        }
        return this;
    }

    public ComputeEngineFormPage setSeries(String option) {
        if (option != null) {
            selectOption(seriesDropdown, option);
        }
        return this;
    }

    public ComputeEngineFormPage setMachineType(String option) {
        if (option != null) {
            selectOption(machineTypeDropdown, option);
        }
        return this;
    }

    public ComputeEngineFormPage addGPUs(String gpuType, String gpuCount) {
        if (gpuType != null && gpuCount != null) {
            waitUntilElementIsVisible(addGPUsCheckbox).click();
            selectOption(gpuTypeDropdown, gpuType);
            selectOption(gpuCountDropdown, gpuCount);
        }
        return this;
    }

    public ComputeEngineFormPage setLocalSSD(String option) {
        if (option != null) {
            selectOption(localSSDDropdown, option);
        }
        return this;
    }

    public ComputeEngineFormPage setLocation(String option) {
        if (option != null) {
            selectOption(datacenterLocationDropdown, option);
        }
        return this;
    }

    public ComputeEngineFormPage setCommittedUsage(String option) {
        if (option != null) {
            selectOption(committedUsageDropdown, option);
        }
        return this;
    }

    public ComputeEngineFormPage clickAddInstancesToEstimateButton() {
        waitUntilElementIsClickable(addInstancesToEstimateButton).click();
        return this;
    }

    public ComputeEngineFormPage fillComputeEngineForm(ComputeEngineForm computeEngineForm) {
        return this
                .setNumberOfInstances(computeEngineForm.getNumberOfInstances())
                .setOperatingSystem(computeEngineForm.getOperatingSystem())
                .setProvisioningModel(computeEngineForm.getProvisioningModel())
                .setSeries(computeEngineForm.getSeries())
                .setMachineType(computeEngineForm.getInstanceType())
                .addGPUs(computeEngineForm.getGpuType(), computeEngineForm.getGpuCount())
                .setLocalSSD(computeEngineForm.getLocalSSD())
                .setLocation(computeEngineForm.getRegion())
                .setCommittedUsage(computeEngineForm.getCommitmentTerm());
    }

    public ComputeEngineResultsPage switchToComputeEngineResults() {
        return new ComputeEngineResultsPage(driver);
    }

    private void selectOption(WebElement selector, String option) {
        waitUntilElementIsVisible(selector).click();
        String xpath = String.format(optionLocator,
                selector.getAttribute("aria-owns"), option);
        waitUntilElementIsVisible(By.xpath(xpath)).click();
    }
}

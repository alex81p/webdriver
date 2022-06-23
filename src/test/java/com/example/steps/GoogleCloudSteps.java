package com.example.steps;

import com.example.model.google_cloud.ComputeEngineForm;
import com.example.page.google_cloud.GoogleCloudHomePage;
import com.example.page.google_cloud.calculator.tool_forms.ComputeEngineResultsPage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudSteps {

    WebDriver driver;

    public GoogleCloudSteps(WebDriver driver) {
        this.driver = driver;
    }

    public ComputeEngineResultsPage createComputeEngineCalculation(String searchRequest, String linkText,
                                                                   ComputeEngineForm computeEngineForm) {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .search(searchRequest)
                .openPricingCalculatorPage(linkText)
                .selectComputeEngine()
                .fillComputeEngineForm(computeEngineForm)
                .clickAddInstancesToEstimateButton()
                .switchToComputeEngineResults();
    }

    public ComputeEngineResultsPage sendComputeEngineResultsToEMail(String eMail) {
        return new ComputeEngineResultsPage(driver)
                .switchToCalculatorFrame()
                .clickEMailEstimateButton()
                .inputEMail(eMail)
                .clickSendEMailButton();
    }
}

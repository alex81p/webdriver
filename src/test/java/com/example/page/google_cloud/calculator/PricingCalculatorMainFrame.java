package com.example.page.google_cloud.calculator;

import com.example.page.AbstractPage;
import com.example.page.google_cloud.calculator.tool_forms.ComputeEngineFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PricingCalculatorMainFrame extends AbstractPage {

    private static final String TOOL_LOCATOR = "//md-pagination-wrapper//div[text()='%s']";
    private static final String FRAME_LOCATOR = "//article[@id='cloud-site']//iframe";
    private static final String SUB_FRAME_NAME = "myFrame";

    public PricingCalculatorMainFrame(WebDriver driver) {
        super(driver);
    }

    public ComputeEngineFormPage selectComputeEngine() {
        switchToCalculatorFrame(driver);
        selectTool("Compute Engine");
        return new ComputeEngineFormPage(driver);

    }
    private void selectTool(String tool) {
        waitUntilElementIsVisible(By.xpath(String.format(TOOL_LOCATOR, tool))).click();
    }

    public static void switchToCalculatorFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath(FRAME_LOCATOR)));
        driver.switchTo().frame(SUB_FRAME_NAME);
    }
}

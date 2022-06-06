package com.example.page.google_cloud.calculator;

import com.example.entities.AbstractPage;
import com.example.page.google_cloud.calculator.tools.ComputeEngineForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingCalculatorMainFrame extends AbstractPage {

    @FindBy(xpath = "//article[@id='cloud-site']//iframe")
    private WebElement calculatorFrame;

    public PricingCalculatorMainFrame(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ComputeEngineForm selectComputeEngine() {
        selectTool("Compute Engine");
        return new ComputeEngineForm(driver);

    }
    private void selectTool(String tool) {
        switchToCalculatorFrame();
        waitUntilElementIsVisible(By.xpath(String.format("//md-pagination-wrapper//div[text()='%s']", tool))).click();
    }

    public void switchToCalculatorFrame(){
        driver.switchTo().frame(calculatorFrame);
        driver.switchTo().frame("myFrame");
    }
}

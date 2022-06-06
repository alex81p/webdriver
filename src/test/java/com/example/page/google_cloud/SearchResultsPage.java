package com.example.page.google_cloud;

import com.example.entities.AbstractPage;
import com.example.page.google_cloud.calculator.PricingCalculatorMainFrame;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends AbstractPage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public PricingCalculatorMainFrame openPricingCalculatorPage(String linkText) {
            waitUntilElementIsVisible(By.linkText(linkText)).click();
            return new PricingCalculatorMainFrame(driver);
    }
}

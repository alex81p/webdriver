package com.example.page.google_cloud;

import com.example.page.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPage search(String searchRequest) {
        searchInput.sendKeys(searchRequest + Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}

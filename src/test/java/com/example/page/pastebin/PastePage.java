package com.example.page.pastebin;

import com.example.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='source']/ol")
    private WebElement pasteSyntaxHighlighting;

    public PastePage(WebDriver driver) {
        super(driver);
    }

    public String getPasteSyntaxHighlighting() {
        return pasteSyntaxHighlighting.getAttribute("class");
    }

    public String getPasteText() {
        return pasteSyntaxHighlighting.getText();
    }

}

package com.example.page.pastebin;

import com.example.entities.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='source']/ol")
    private WebElement pasteSyntaxHighlighting;


    public PastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getPasteSyntaxHighlighting() {
        return pasteSyntaxHighlighting.getAttribute("class");
    }

    public String getPasteText() {
        return pasteSyntaxHighlighting.getText();
    }

}

package com.google.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchListPage  extends PageObject{

    @FindBy(className = "Tg7LZd")
    private WebElement searchButton;

    @FindBy(name = "q")
    private WebElement searchInput;

    public GoogleSearchListPage(WebDriver webDriver, String expectedTitle) {
        super(webDriver);
        webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    public GoogleSearchListPage clickSearchButton(String word){
        searchButton.click();
        return new GoogleSearchListPage(webDriver, String.format("%s - Szukaj w Google", word));
    }


    public void enterSearchText(String word){
        searchInput.clear();
        searchInput.sendKeys(word);
    }
}

package com.google.automation.page;

import cucumber.runtime.Timeout;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

import static cucumber.runtime.Timeout.timeout;

public class GooglePage extends PageObject {
    //    String actualTitle = webDriver.getTitle();
    String expectedTitle = "Google";

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    @FindBy(id = "logo")
    private WebElement logohButton;

    @FindBy(xpath = "//h3[@class='LC20lb'")
    private WebElement headlines;

    public GooglePage(WebDriver webDriver) {
        super(webDriver);
        webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    public void enterNormalWord(String word) {

        webDriverWait.until(ExpectedConditions.visibilityOf(searchInput));//visibilityOfElementLocated jest do "by."(id,xpath) a korzystamy z visibilityOf ponieważ mamy dostęp do zmiennych typu web element
        searchInput.clear();
        searchInput.sendKeys(word);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchButton));
    }

    public GoogleSearchListPage clickSearchButton(String word){
        searchButton.click();
        return new GoogleSearchListPage(webDriver, String.format("%s - Szukaj w Google", word));
    }



}

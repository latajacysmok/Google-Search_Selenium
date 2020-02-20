package com.google.automation.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GoogleCheckingHeadersPage extends PageObject{

//    @FindBy(xpath = "//h3[@class='LC20lb']")
//    private WebElement searchHeadlines;

    public GoogleCheckingHeadersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkWebsiteHeadlines(String args){
            List<WebElement> allLinks = webDriver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
    //        List<WebElement> allLinks = searchHeadlines;

            System.out.println(allLinks.size());
        System.out.println(allLinks);

            for (WebElement webElement : allLinks) {
                String name = webElement.getText();
                System.out.println(name);
            Assert.assertTrue("Text not found!", name.toLowerCase().contains(args.toLowerCase()));
        }
    }
}

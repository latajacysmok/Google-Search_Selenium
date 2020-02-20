package com.google.automation;

import com.google.automation.page.GoogleCheckingHeadersPage;
import com.google.automation.page.GoogleSearchListPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import com.google.automation.config.WebDriverType;
import com.google.automation.page.GooglePage;

public class WebDriverTest {
        @Test
        public void shouldOpenChromeBrawser() {
            WebDriver webDriver = WebDriverType.CHROME.create();
            webDriver.get("https://www.google.com/");
        GooglePage googlePage = new GooglePage(webDriver);
        GoogleCheckingHeadersPage googleCheckingHeadersPage = new GoogleCheckingHeadersPage(webDriver);
        String[] words = {"Home",
                "Dog",
                "Orange",
                "Math",
                "Tiger"};
        String[] numbers = {"6354738920",
                "5879269841984",
                "9879265987197",
                "8787198174856",
                "8798516496695"};
        String[] characters = {"!@#$%^&*<>?",
                ",./`-_|",
                "{}[]';:=}",
        };
        System.out.println("****************Start the test!!!****************");
        googlePage.enterNormalWord("Sky");
        GoogleSearchListPage googleSearchListPage = googlePage.clickSearchButton("Sky");
        googleCheckingHeadersPage.checkWebsiteHeadlines("Sky");
        for (int i = 0; i < words.length; i++) {
            googleSearchListPage.enterSearchText(words[i]);
            googleSearchListPage.clickSearchButton(words[i]);
            googleCheckingHeadersPage.checkWebsiteHeadlines(words[i]);
        }
        System.out.println("*********The test withs words is over!!!*********");
        for (int i = 0; i < numbers.length; i++) {
            googleSearchListPage.enterSearchText(numbers[i]);
            googleSearchListPage.clickSearchButton(numbers[i]);
        }
        System.out.println("********The test withs numbers is over!!!********");
        for (int i = 0; i < characters.length; i++) {
            googleSearchListPage.enterSearchText(characters[i]);
            googleSearchListPage.clickSearchButton(characters[i]);
        }
        System.out.println("******The test withs characters is over!!!*******");
         googleSearchListPage.enterSearchText(""); //assertThatThrownBy()
         googleSearchListPage.clickSearchButton(characters[characters.length-1]);
        System.out.println("***********The tests was successful!!!***********");
        webDriver.close();
    }
}

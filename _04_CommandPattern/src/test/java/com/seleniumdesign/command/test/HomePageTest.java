package com.seleniumdesign.command.test;

import com.seleniumdesign.command.HomePage;
import com.seleniumdesign.strategy.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest() {
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));

    }

    // Sequential execution time: 30sec 588ms
    // Parallel execution time: 20sec 615ms
    // Parallel execution time with List.of method in page object: 15sec 615ms
}

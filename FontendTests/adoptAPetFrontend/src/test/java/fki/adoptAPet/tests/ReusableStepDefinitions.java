package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.HomePage;
import fki.adoptAPet.PageFactory.LoginPage;
import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReusableStepDefinitions {

    private static WebDriver driver;

    public static void setDriver(WebDriver webdriver) {
        driver = webdriver;
    }

    public static String getCurrentUrl() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.getCurrentUrl();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        new HomePage(driver).openHomePage();
    }

    @When("I am logged in")
    public void iAmLoggedIn() {
        new NavbarPage(driver).goToLoginPage();
        new LoginPage(driver).inputCredentials();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Set<Cookie> cookies = driver.manage().getCookies();
        assertFalse(cookies.isEmpty(), "There are no cookies");
    }

    @When("I am NOT logged in")
    public void iAmNOTLoggedIn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Set<Cookie> cookies = driver.manage().getCookies();
        assertTrue(cookies.isEmpty(), "There are some cookies stored in browser");
    }


}

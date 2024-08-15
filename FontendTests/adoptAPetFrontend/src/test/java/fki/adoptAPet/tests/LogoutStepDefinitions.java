package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.LogoutPage;
import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutStepDefinitions {
    WebDriver driver = new ChromeDriver();
    NavbarPage navbarPage = new NavbarPage(driver);
    LogoutPage logoutPage = new LogoutPage(driver);

    @Before("@logout")
    public void setDriverToReusableStepDefinitions() {
        ReusableStepDefinitions.setDriver(driver);
    }

    @When("I press logout button")
    public void iPressLogoutButton() {
        navbarPage.openLogoutPage();
    }

    @And("I confirm that I want to logout")
    public void iConfirmThatIWantToLogout() {
        logoutPage.confirmLogout();
    }

    @Then("I am notified that I am no longer logged in")
    public void iAmNotifiedThatIAmNoLongerLoggedIn() {
        String expectedMessage = "You have logged out successfully.";
        String message = logoutPage.logoutMessageIs();
        assertEquals(expectedMessage, message);
    }

    @And("I am redirected to home page")
    public void iAmRedirectedToHomePage() {
        String expectedUrl= "http://localhost:4200/home";
        String currentUrl = ReusableStepDefinitions.getCurrentUrl();
        assertEquals(expectedUrl,currentUrl);
    }
    @After("@logout")
    public void TearDown(){
        try {
            driver.quit();
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
        }
    }

}

package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.HomePage;
import fki.adoptAPet.PageFactory.LoginPage;
import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageStepDefinitions {

    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    NavbarPage navbarPage = new NavbarPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Before("@home")
    public void setDriverToReusableStepDefinitions() {
        ReusableStepDefinitions.setDriver(driver);
    }

    @Then("I can see navbar")
    public void iCanSeeNavbar() {
        navbarPage.navbar_is_present();
    }

    @And("I can see welcome message")
    public void iCanSeeWelcomeMessage() {
        homePage.messagePresent();
    }

    @Then("I can see on the navbar home, adoptable pets, login and registration buttons")
    public void iCanSeeOnTheNavbarHomeAdoptablePetsLoginAndRegistrationButtons() {
        assertTrue(navbarPage.homeButtonIsVisible(), "Home button is not visible");
        assertTrue(navbarPage.adoptablePetsButtonIsVisible(), "Adoptable Pets button is not visible");
        assertTrue(navbarPage.loginButtonIsVisible(), "Login button is not visible");
        assertTrue(navbarPage.registrationButtonIsVisible(), "Registration button is not visible");

    }

    @Then("I can see home, adoptable pets, my applications and logout buttons")
    public void iCanSeeHomeAdoptablePetsMyApplicationsAndLogoutButtons() {
        assertTrue(navbarPage.homeButtonIsVisible(), "Home button is not visible");
        assertTrue(navbarPage.adoptablePetsButtonIsVisible(), "Adoptable Pets button is not visible");
        assertTrue(navbarPage.applicationButtonIsVisible(), "My application button is not visible");
        assertTrue(navbarPage.HelloUserIsVisible(), "Hello User message is not visible");
        assertTrue(navbarPage.LogoutButtonIsVisible(), "Logout button is not visible");
    }

    @Given("I click on Home button")
    public void iClickOnHomeButton() {
        navbarPage.openHomePage();
    }

    @After("@home")
    public void TearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
        }
    }
}

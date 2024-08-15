package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.HomePage;
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

    WebDriver driver;
    HomePage homePage;
    NavbarPage navbarPage;

    @Before("@home")
    public void setDriverToReusableStepDefinitions() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        navbarPage = new NavbarPage(driver);
        ReusableStepDefinitions.setDriver(driver);
        driver.manage().window().maximize();
    }

    @Then("I can see the navbar")
    public void iCanSeeTheNavbar() {
        navbarPage.navbar_is_present();
    }

    @And("I can see the welcome message")
    public void iCanSeeTheWelcomeMessage() {
        homePage.messagePresent();
    }

    @Then("I can see the Home, Adoptable Pets, Login, and Registration buttons on the navbar")
    public void iCanSeeTheHomeAdoptablePetsLoginAndRegistrationButtonsOnTheNavbar() {
        assertTrue(navbarPage.homeButtonIsVisible(), "Home button is not visible");
        assertTrue(navbarPage.adoptablePetsButtonIsVisible(), "Adoptable Pets button is not visible");
        assertTrue(navbarPage.loginButtonIsVisible(), "Login button is not visible");
        assertTrue(navbarPage.registrationButtonIsVisible(), "Registration button is not visible");

    }

    @Then("I can see the Home, Adoptable Pets, My Applications, and Logout buttons on the navbar")
    public void ICanSeeTheHomeAdoptablePetsMyApplicationsAndLogoutButtonsOnTheNavbar() {
        assertTrue(navbarPage.homeButtonIsVisible(), "Home button is not visible");
        assertTrue(navbarPage.adoptablePetsButtonIsVisible(), "Adoptable Pets button is not visible");
        assertTrue(navbarPage.applicationButtonIsVisible(), "My application button is not visible");
        assertTrue(navbarPage.HelloUserIsVisible(), "Hello User message is not visible");
        assertTrue(navbarPage.LogoutButtonIsVisible(), "Logout button is not visible");
    }

    @Given("I click on the Home button")
    public void iClickOnTheHomeButton() {
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

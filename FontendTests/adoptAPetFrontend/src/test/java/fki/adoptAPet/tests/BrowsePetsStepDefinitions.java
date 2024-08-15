package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.AdoptPage;
import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowsePetsStepDefinitions {

    WebDriver driver;
    NavbarPage navbarPage;
    AdoptPage adoptPage;


    @Before("@browsePets")
    public void setDriverToReusableStepDefinitions() {
        driver = new ChromeDriver();
        navbarPage = new NavbarPage(driver);
        adoptPage = new AdoptPage(driver);
        driver.manage().window().maximize();
        ReusableStepDefinitions.setDriver(driver);
    }

    @When("I click on Adoptable pets button")
    public void iClickOnAdoptablePetsButton() {
        navbarPage.openAdoptable_petsPage();
    }

    @Then("I can see if there are any pets for adoption")
    public void iCanSeeIfThereAreAnyPetsForAdoption() {
        assertTrue(adoptPage.adoptablePetsAreVisible());
    }

    @When("I choose {}")
    public void iChoose(String arg0) {
        adoptPage.selectFilter(arg0);
    }

    @Then("I can see only {} types of animal or message that there are no animals of this type")
    public void iCanSeeOnlyTypesOfAnimalOrMessageThatThereAreNoAnimalsOfThisType(String arg0) {
        assertTrue(adoptPage.adoptableAnimalsAreFiltered(arg0));
    }

    @After("@browsePets")
    public void TearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            driver.quit();
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
        }
    }
}

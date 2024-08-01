package fki.adoptAPet.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class NavbarPage {

    WebDriver chromedriver;

    @FindBy(css = "[data-test='link-home']")
    WebElement HomeButton;
    @FindBy(css = "[data-test='link-adopt']")
    WebElement Adoptable_pets;
    @FindBy(css = "[data-test='link-applications']")
    WebElement My_applications;

    public NavbarPage(WebDriver driver) {
        this.chromedriver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        HomeButton.click();
    }

    public void openAdoptable_petsPage() {
        Adoptable_pets.click();
    }

    public void openMy_ApplicationsPage() {
        My_applications.click();
    }
}

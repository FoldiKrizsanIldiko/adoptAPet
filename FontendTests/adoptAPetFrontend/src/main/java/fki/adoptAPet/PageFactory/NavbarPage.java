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
    WebElement Adoptable_petsButton;
    @FindBy(css = "[data-test='link-applications']")
    WebElement My_applicationsButton;
    @FindBy(css = "[data-test='link-login']")
    WebElement LoginButton;
    @FindBy(css = "[data-test='link-registration']")
    WebElement RegistrationButton;
    @FindBy(css = "[data-test='subsite-links']")
    WebElement Navbar;
    @FindBy(css = "[data-test='hello']")
    WebElement HelloUserMessage;
    @FindBy(css = "[data-test='link-logout']")
    WebElement LogoutButton;

    public NavbarPage(WebDriver driver) {
        this.chromedriver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        HomeButton.click();
    }

    public void openAdoptable_petsPage() {
        Adoptable_petsButton.click();
    }

    public void openMy_ApplicationsPage() {
        My_applicationsButton.click();
    }

    public void navbar_is_present() {
        Navbar.isDisplayed();
    }

    public boolean homeButtonIsVisible() {
        return HomeButton.isEnabled();
    }

    public boolean adoptablePetsButtonIsVisible() {
        return Adoptable_petsButton.isEnabled() && Adoptable_petsButton.isDisplayed();
    }

    public boolean loginButtonIsVisible() {
        return LoginButton.isEnabled() && LoginButton.isDisplayed();
    }

    public boolean registrationButtonIsVisible() {
        return RegistrationButton.isEnabled() && RegistrationButton.isDisplayed();
    }

    public boolean applicationButtonIsVisible() {
        return My_applicationsButton.isEnabled() && My_applicationsButton.isDisplayed();
    }

    public boolean HelloUserIsVisible() {
        return HelloUserMessage.isDisplayed();
    }

    public boolean LogoutButtonIsVisible() {
        return LogoutButton.isEnabled() && LogoutButton.isDisplayed();
    }

    public void goToLoginPage() {
        LoginButton.click();
    }

    public void openRegistrationPage() {
        RegistrationButton.click();
    }
}

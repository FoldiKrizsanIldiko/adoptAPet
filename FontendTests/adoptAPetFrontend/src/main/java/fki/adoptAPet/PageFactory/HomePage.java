package fki.adoptAPet.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    WebDriver chromedriver;
    String URL = "http://localhost:4200/home";
    @FindBy(xpath = "//h1[text()='This is the best place if you want to save an orphan animal.']")
    WebElement WelcomeMessage;

    public HomePage(WebDriver driver) {
        this.chromedriver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void openHomePage() {
        chromedriver.get(URL);
    }

    public void messagePresent() {
        WelcomeMessage.isDisplayed();
    }
}

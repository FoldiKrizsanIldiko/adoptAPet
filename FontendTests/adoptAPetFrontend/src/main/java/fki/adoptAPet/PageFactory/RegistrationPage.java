package fki.adoptAPet.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class RegistrationPage {
    String firstName= "testUser123first";
    String lastName= "testUser123last";
    String email= "testUser123@mail.com";
    String password = "Password123+";


    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @FindBy(css= "[data-test='input-firstname']")
    WebElement firstNameField;
    @FindBy(css="[data-test='input-lastname']")
    WebElement lastNameField;



}

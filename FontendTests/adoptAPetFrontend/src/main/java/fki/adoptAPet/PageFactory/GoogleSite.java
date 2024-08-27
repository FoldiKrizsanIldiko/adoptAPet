package fki.adoptAPet.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSite {
    WebDriver driver;

    public GoogleSite(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='Google']")
    WebElement google;

    public void OpenGooglePage(){
        driver.get("https://www.google.commmm/");
    }

    public void GoogleSignIsDisplayed(){
        google.isDisplayed();
    }
}

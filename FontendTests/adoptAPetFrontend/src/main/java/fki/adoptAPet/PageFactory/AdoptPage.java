package fki.adoptAPet.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdoptPage {
    WebDriver chromedriver;
    WebDriverWait wait;

    @FindBy(xpath = "//select[@name='speciesValue']/option")
    List<WebElement> selectorOfSpecies;

    @FindBy(xpath = "//ul[@data-test='adoptable-pets-list']/li")
    List<WebElement> adoptablePets;

    @FindBy(xpath = "//h2[contains(text(),' Sorry, we do not have adoptable')]")
    WebElement messageNotHavePets;

    @FindBy(css = "[test-data='not-have-applications']")
    WebElement message;
    //You haven't handed in an application to adopt a pet yet.

    public AdoptPage(WebDriver driver) {
        this.chromedriver = driver;
        PageFactory.initElements(driver, this);
        chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(chromedriver, Duration.ofSeconds(15));
    }

    public boolean adoptablePetsAreVisible() {
        return !adoptablePets.isEmpty();
    }

    public void selectFilter(String filter) {
        selectorOfSpecies.stream().filter(e -> e.getAttribute("value").equals(filter)).findFirst().ifPresent(WebElement::click);
    }

    public boolean adoptableAnimalsAreFiltered(String filter) {
        if (adoptablePets.isEmpty()) {
            return messageNotHaveAnimals();
        }
        if (!filter.equals("all")) {

            return adoptablePets.stream()
                    .allMatch(pet -> {
                        WebElement genderAndSpeciesElement = pet.findElement(By.xpath(".//*[@data-test ='pet-gender-and-species']"));
                        return genderAndSpeciesElement.getText().contains(filter.substring(0, filter.length() - 1));
                    });
        } else return true
                ;
    }

    private boolean messageNotHaveAnimals() {
        return messageNotHavePets.isDisplayed();
    }
}

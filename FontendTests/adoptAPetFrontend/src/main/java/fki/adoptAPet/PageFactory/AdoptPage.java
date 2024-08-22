package fki.adoptAPet.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AdoptPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//select[@name='speciesValue']/option")
    List<WebElement> selectorOfSpecies;

    @FindBy(xpath = "//li[@data-test='adoptable-pet-list-item']")
    List<WebElement> adoptablePets;

    @FindBy(xpath = "//h2[contains(text(),' Sorry, we do not have adoptable')]")
    WebElement messageNotHavePets;

    @FindBy(css = "[test-data='not-have-applications']")
    WebElement message;

    public AdoptPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
        } else return true;
    }

    private boolean messageNotHaveAnimals() {
        return messageNotHavePets.isDisplayed();
    }

    public boolean thereAreAdoptablePets() {
        if (adoptablePets.isEmpty()) {
            return false;
        } else {
            //.filter(e->e.getAttribute("data-test").equals("adopt-button"))
            return adoptablePets.stream().anyMatch(pet -> {
                WebElement currentButton = pet.findElement(By.xpath(".//*[@data-test='adopt-button']"));
                return !currentButton.getAttribute("class").equals("disabled");
            });
        }
    }

    public void clickOnAdoptAPet() {
        adoptablePets.stream()
                .map(e -> e.findElement(By.xpath(".//*[@data-test='adopt-button']")))
                .filter(button -> !button.getAttribute("class").equals("disabled"))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void acceptNotification() {
        driver.switchTo().alert().accept();
    }

    public boolean AppliedPetButtonIsDisabled(List<String> appliedPetsName) {
        List<WebElement> adoptablePetsDisabled = adoptablePets.stream().filter(e -> e.findElement(By.xpath(".//*[@data-test='adopt-button']")).getAttribute("class").equals("disabled")).collect(Collectors.toList());
        if (appliedPetsName.size() != adoptablePetsDisabled.size()) return false;
        else {
            List<WebElement> disabledNames = adoptablePetsDisabled.stream().map(e -> e.findElement(By.cssSelector("[data-test = 'pet-name']"))).collect(Collectors.toList());
            return disabledNames.stream().allMatch(name -> {
                String disName = name.getText();
                return appliedPetsName.stream().anyMatch(e -> e.contains(disName));
            });
        }
    }

}

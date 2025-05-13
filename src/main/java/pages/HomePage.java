package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[data-testid='search-input']")
    WebElement searchBox;

    @FindBy(css = "li span[data-testid='Japan-name']")
    WebElement japanLocalOption;

    public void searchForJapan() {
        searchBox.sendKeys("Japan");
        new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.visibilityOf(japanLocalOption));
        japanLocalOption.click();
    }
}

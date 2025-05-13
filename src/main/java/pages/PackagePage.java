package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackagePage extends BasePage {

    public PackagePage(WebDriver driver) {
        super(driver);
    }

    //locate the popup and wait for it to be displayed
    @FindBy(css = "div.sim-detail-top")
    WebElement popupHeader;

    public void waitForPopupToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(popupHeader));
    }

    @FindBy(xpath = "//button[contains(text(),'BUY NOW')]")
    List<WebElement> buyNowButtons;

    public void selectFirstPackage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> buyNowButtons.size() > 0);
        buyNowButtons.get(0).click();  // First real paid package
    }

    @FindBy(css = "div.sim-detail-top p[data-testid='COVERAGE-value']")
    WebElement coverage;

    @FindBy(css = "div.sim-detail-top p[data-testid='DATA-value']")
    WebElement data;

    @FindBy(css = "div.sim-detail-top p[data-testid='VALIDITY-value']")
    WebElement validity;

    @FindBy(css = "div.sim-detail-top p[data-testid='PRICE-value']")
    WebElement price;


    public Map<String, String> getPackageDetails() {
        Map<String, String> details = new HashMap<>();
        details.put("Coverage", coverage.getText().trim());
        details.put("Data", data.getText().trim());
        details.put("Validity", validity.getText().trim());
        details.put("Price", price.getText().trim());
        return details;
    }
}

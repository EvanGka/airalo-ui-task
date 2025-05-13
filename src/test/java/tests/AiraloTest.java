package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.PackagePage;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class AiraloTest {

    WebDriver driver;
    HomePage homePage;
    PackagePage packagePage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.airalo.com");

        homePage = new HomePage(driver);
        packagePage = new PackagePage(driver);
    }

    @Test(description = "Validate Japan eSIM details after selecting from the homepage")
    public void testJapanPackageFlow() {
        homePage.searchForJapan();
        packagePage.selectFirstPackage();
        packagePage.waitForPopupToLoad(); // wait for the popup before doing the assertions

        Map<String, String> details = packagePage.getPackageDetails();

        assertEquals(details.get("Coverage"), "Japan");
        assertEquals(details.get("Data"), "1 GB");
        assertEquals(details.get("Validity"), "7 days");
        assertEquals(details.get("Price"), "$4.50");
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}

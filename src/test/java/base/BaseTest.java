package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected String baseUrl = "https://automationexercise.com";
    protected void handleGoogleVignetteIfPresent() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("#google_vignette")) {
            String cleanUrl = currentUrl.replace("#google_vignette", "");
            ((JavascriptExecutor) driver).executeScript(
                    "window.location.href = arguments[0];", cleanUrl
            );
        }
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
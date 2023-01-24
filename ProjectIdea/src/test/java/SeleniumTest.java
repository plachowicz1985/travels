import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        Dimension windowSize = new Dimension(200,200);
        driver.manage().window().setSize(windowSize);
        driver.get("https://www.google.com/");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.google.com/','blank','height=200,width=200')");
        driver.close();
        //driver.quit();

    }

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "safari" :
                return new SafariDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }

}

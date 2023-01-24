import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void openGooglePage() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        agreeButton.click();

        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Selenium");
        searchBar.sendKeys(Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//a[contains(@href, 'selenium.dev')]//h3"));
        Assert.assertTrue(result.isDisplayed());

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

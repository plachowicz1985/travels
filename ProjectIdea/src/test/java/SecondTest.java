import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SecondTest {

    //shop i weryfikujemy czy jest produkt java selenium webdriver
    //

    @Test
    public void seleniumBuy() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumdemo.com/");

        driver.findElement(By.xpath("//span[text()='Shop']")).click();

        WebElement seleniumButton = driver.findElement(By.xpath("//h2[contains(text(), 'Java Selenium WebDriver')]"));
        Assert.assertEquals(seleniumButton.getText(), "Java Selenium WebDriver");
        Assert.assertTrue(seleniumButton.isDisplayed());

    }



}

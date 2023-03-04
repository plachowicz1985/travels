import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelSearchWithoutNameTest extends BaseTest{

    @Test
    public void searchHotelTest() {
        driver.findElement(By.name("checkin")).sendKeys("27/02/2023");
        driver.findElement(By.name("checkout")).click();
        driver.findElements(By.xpath("//td[@class='day ' and text()='28']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();

        WebElement noResult = driver.findElement(By.xpath("//div[@class='itemscontainer']"));

        Assert.assertTrue(noResult.isDisplayed());
        Assert.assertEquals(noResult.getText(), "No Results Found");
    }
}

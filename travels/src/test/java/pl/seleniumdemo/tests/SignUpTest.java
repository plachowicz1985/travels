package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.SignUpPage;
import pl.seleniumdemo.tests.BaseTest;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {

        String lastName = "Cobain";
        int randomNumber = (int) (Math.random()*1000);
        String email = "tester_0"+randomNumber+"@tester.pl";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Kurt");
        signUpPage.setLastName(lastName);
        signUpPage.setPhone("511511511");
        signUpPage.setEmail(email);
        signUpPage.setPassword("Piotrek");
        signUpPage.setConfirmPassword("Piotrek");
        signUpPage.clickSubmitButton();


        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));
        Assert.assertTrue(heading.getText().contains(lastName));
        Assert.assertEquals(heading.getText(),"Hi, Kurt Cobain");
    }
}

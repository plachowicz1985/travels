package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.SignUpPage;

import java.util.List;

public class HomeworkTest extends BaseTest {

    @Test
    public void signUpEmptyFormTest() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSubmitButton();

        List<String> errors = signUpPage.getErrors();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();
    }

    @Test
    public void signUpInvalidEmail() {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Kurt");
        signUpPage.setLastName("Cobain");
        signUpPage.setPhone("511511511");
        signUpPage.setEmail("tester");
        signUpPage.setPassword("Piotrek");
        signUpPage.setConfirmPassword("Piotrek");
        signUpPage.clickSubmitButton();

        Assert.assertTrue(signUpPage.getErrors().contains("The Email field must contain a valid email address."));

    }
}

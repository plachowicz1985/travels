package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpPage {

    @FindBy (name = "firstname")
    private WebElement firstNameInput;

    @FindBy (name = "lastname")
    private WebElement lasNameInput;

    @FindBy (name = "phone")
    private WebElement phoneInput;

    @FindBy (name = "email")
    private WebElement emailInput;

    @FindBy (name = "password")
    private WebElement passwordInput;

    @FindBy (name = "confirmpassword")
    private WebElement condirmPasswordInput;

    @FindBy (xpath = "//button[@type='submit' and text()=' Sign Up']")
    private WebElement submitButton;

    @FindBy (xpath = "//form[@id='headersignupform'] // p")
    private List<WebElement> errors;


    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lasNameInput.sendKeys(lastName);
    }

    public void setPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void setConfirmPassword(String confirmpassword) {
        condirmPasswordInput.sendKeys(confirmpassword);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public List<String> getErrors() {

        return errors.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
